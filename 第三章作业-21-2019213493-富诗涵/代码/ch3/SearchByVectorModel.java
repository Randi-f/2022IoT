package ch3;
/**
 * @author Shihan Fu
 * @version 1.0
 * 向量模型
 * update 0608
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SearchByVectorModel {
	ArrayList<String> documentContent=new ArrayList<String>();
	static double[] sim= {0.0,0.0,0.0,0.0,0.0,0.0,0.0};
	
	int[][] djDocument = new int[][] {//vsm document matrix
		{4,2,0,0,0,0},
		{2,0,2,2,0,0},
		{0,3,2,1,0,0},
		{0,3,0,0,2,2},
		{1,1,0,0,1,1},
		{1,1,1,0,0,1},
		{0,0,0,0,0,0}
	};
	
	int[][] qQuery = new int[][] {
		{1,0,0,0,0,0},
		{0,1,0,0,0,0},
		{1,1,0,0,0,0},
		{0,0,1,1,0,0},
		{0,0,0,0,1,1}
	}; 
	static int sortResult[]= {0,0,0,0,0,0,0};
	public SearchByVectorModel() {
		readDocument();
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchByVectorModel s= new SearchByVectorModel();
		
		//s.cosine(4);
		//s.sortMe();
		//System.out.println(sim[0]+"");
		//for(int i=6;i>=0;i--) {
		//	System.out.println(sortResult[i]);//反过来就是相似度由大到小
		//}
		System.out.println(s.returnResult(4));
	}
	
	public String returnResult(int queryNo) {
		cosine(queryNo);
		sortMe();
		String str="";
		for(int i=6;i>=0;i--) {
			if(sim[i]!=-1&&sortResult[i]!=-1) {
				str=str+documentContent.get(sortResult[i])+" with sim:"+ sim[sortResult[i]]+"\n";
			}
			
		}
		return str;
	}

	public void sortMe() {

		double index[]=new double[7];
		double[] sim2=new double[7];
		for(int i=0;i<7;i++) {
			sim2[i]=sim[i];
		}
		System.arraycopy(sim2, 0, index, 0, 7); 
		java.util.Arrays.sort(sim2); 
		for(int i=0;i<sim2.length;i++){ 
			for(int j=0;j<index.length;j++){ 
				if(sim2[i]==0) {
					sortResult[i]=-1;
				}
				else if(sim2[i]==index[j]){ 
					System.out.println(sim2[i]+"的原下标为:"+j);
					sortResult[i]=j;
				} } }
	}
	
	public void cosine(int queryNo) {
		double fenzi=0.0;
		double fenmu1=0.0;
		double fenmu2=0.0;
		for(int i=0;i<7;i++) {
			for(int x=0;x<6;x++) {
				fenzi+=djDocument[i][x]*qQuery[queryNo][x];
			}
			for(int y=0;y<6;y++) {
				fenmu1+=djDocument[i][y]*djDocument[i][y];
			}
			for(int y=0;y<6;y++) {
				fenmu2+=qQuery[queryNo][y]*qQuery[queryNo][y];
			}
			//System.out.println(fenzi);
			if(fenmu1!=0) {
				sim[i]=fenzi/Math.sqrt(fenmu1*fenmu2);
			}
			else {
				sim[i]=0.0;
			}
			
		}
	}
	
	//专门读取document文件，放进全局变量ArrayList<String> documentContent里
		public void readDocument() {
					File file = new File("document.txt");// 创建目录
			        Scanner sc;
			        String str="";	
					try {
						sc = new Scanner(file);						        	        
				        while (sc.hasNext()) {
				            str = sc.nextLine();
				            documentContent.add(str);      
				        }
				       sc.close();		       
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
		}
}

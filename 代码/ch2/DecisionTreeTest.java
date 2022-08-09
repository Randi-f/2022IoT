package ch2;
/**
 * @author Shihan Fu
 * @version 1.0
 * 计算权重，看哪一个标签作为上级节点分类的判断依据
 * update 0608
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DecisionTreeTest {
	int id;
	float cpc;
	float cpm;
	String is_anomaly;
	public DecisionTreeTest(String info) {
		String [] strArray = info.split(",");
		this.id=Integer.parseInt(strArray[0]);
		this.cpc=Float.parseFloat(strArray[1]);
		this.cpm=Float.parseFloat(strArray[2]);	
		this.is_anomaly=strArray[3];
	}
	
	public float getCpc() {
		return this.cpc;
	}
	public float getCpm() {
		return this.cpm;
	}
	public String getStatus() {
		return this.is_anomaly;
	}
	
	
	public static void main(String[] args) {
		
		ArrayList<DecisionTreeTest> dataSet = new ArrayList<DecisionTreeTest>();
		 
        File file = new File("C:\\Users\\lenovo\\Desktop\\第二章大作业\\测试数据.csv");// 创建目录
        Scanner sc;
        int line=-1;
		try {
			sc = new Scanner(file);
	        String str;
	        
	        while (sc.hasNext()) {
	        	str=sc.nextLine();//按行读取文件
	        	if(line!=-1) {
	        		dataSet.add(new DecisionTreeTest(str));	        		
	        	}
	        	line++;	        	
	        }
	       sc.close();	       
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//System.out.println(""+line);
		
		double[] cpcSmallerThanNum1={0.0,0.0};//{TRUE, FALSE}
		double[] cpcLargerThanNum1={0.0,0.0};
		double[] cpmSmallerThanNum1={0.0,0.0};
		double[] cpmLargerThanNum1={0.0,0.0};
		String[] result= {"1","2","3","4"};
		for(int i=0;i<dataSet.size();i++) {
			
			if(dataSet.get(i).getCpc()<0.3) {
				if(dataSet.get(i).getStatus().equals("TRUE")) {
					cpcSmallerThanNum1[0]++;
				}
				else {
					cpcSmallerThanNum1[1]++;
				}
			}
			else {
				if(dataSet.get(i).getStatus().equals("TRUE")) {
					cpcLargerThanNum1[0]++;
				}
				else {
					cpcLargerThanNum1[1]++;
				}
			}
			
			if(dataSet.get(i).getCpm()<0.04) {
				if(dataSet.get(i).getStatus().equals("TRUE")) {
					cpmSmallerThanNum1[0]++;
				}
				else {
					cpmSmallerThanNum1[1]++;
				}
			}
			else {
				if(dataSet.get(i).getStatus().equals("TRUE")) {
					cpmLargerThanNum1[0]++;
				}
				else {
					cpmLargerThanNum1[1]++;
				}
			}
		}
		
		double Info_cpc=(cpcSmallerThanNum1[0]+cpcSmallerThanNum1[1])/line*I(cpcSmallerThanNum1[0],cpcSmallerThanNum1[1])+
				(cpcLargerThanNum1[0]+cpcLargerThanNum1[1])/line*I(cpcLargerThanNum1[0],cpcLargerThanNum1[1]);
		double Info_cpm=(cpmSmallerThanNum1[0]+cpmSmallerThanNum1[1])/line*I(cpmSmallerThanNum1[0],cpmSmallerThanNum1[1])+
				(cpmLargerThanNum1[0]+cpmLargerThanNum1[1])/line*I(cpmLargerThanNum1[0],cpmLargerThanNum1[1]);
		int trueNo=0;
		int falseNo=0;
		if(Info_cpc<Info_cpm) {
			System.out.println("cpm大");

		}
		else {
			System.out.println("cpc大");
		}
	
	}
	
	
	public static double I(double a, double b) {
		if(a==0||b==0) {
			return 0.0;
		}
		else{
			double p1=a/(a+b);
			double p2=b/(a+b);
			return -p1*Math.log(p1)/Math.log(2)-p2*Math.log(p2)/Math.log(2);
		}
		
	}
	

}

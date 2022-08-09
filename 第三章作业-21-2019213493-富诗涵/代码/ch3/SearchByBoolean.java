package ch3;
/**
 * @author Shihan Fu
 * @version 1.0
 * ����ģ��
 * update 0608
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SearchByBoolean {
	ArrayList<String> indexList = new ArrayList<String>();
	//int[][] documentMatrix = new int[7][6];
	int[][] documentMatrix = new int[][]{ 
		{1,1,0,0,0,0},
		{1,0,1,1,0,0},
		{0,1,1,1,0,0},
		{0,1,0,0,1,1},
		{1,1,0,0,1,1},
		{1,1,1,0,0,1},
		{0,0,0,0,0,0}		
		};
	
	ArrayList<String> documentContent=new ArrayList<String>();
	
	public SearchByBoolean() {
		readDocument();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchByBoolean a = new SearchByBoolean();
		
		//�ɹ���ͳ����Ҫ�����Ĵ���ArrayList<String>��ʽ����
		//ArrayList<String> showme =a.createIndexList();
		//System.out.println(showme);
		
		//a.createBooleanModel();
		
		a.BooleanModelSearchByQueryDocNo(2);

	}
	
	//�Զ�������
	public String BooleanModelSearchByOneself(int[] search) {
		String result="";
		boolean check=true;
		int i=0;
		for(i=0;i<7;i++) {
			check=true;
			for(int j=0;j<6;j++) {
				if(search[j]!=-1) {
					if(documentMatrix[i][j]!=search[j]) {
						check=false;
						break;
					}
				}
			}
			if(check==true) {
				result=result+documentContent.get(i)+"\n";
			}
			
		}
		
		return result;
	}
	
	//����query�ĵ����������������
	public String BooleanModelSearchByQueryDocNo(int QueryDocNo) {
		String result="";
		//��ƹ���-1��û�����ƣ�1���У�2����
		int[] search= {-1,-1,-1,-1,-1,-1};
		
		if(QueryDocNo==0) {
			search[0]=1;
		}
		else if(QueryDocNo==1) {
			search[1]=1;
		}
		else if(QueryDocNo==2) {
			search[0]=1;
			search[1]=1;
		}
		else if(QueryDocNo==3) {
			search[2]=1;
			search[3]=1;
		}
		else if(QueryDocNo==4) {
			search[4]=1;
			search[5]=1;
		}

		boolean check=true;
		int i=0;
		for(i=0;i<7;i++) {
			check=true;
			for(int j=0;j<6;j++) {
				if(search[j]!=-1) {
					if(documentMatrix[i][j]!=search[j]) {
						check=false;
						break;
					}
				}
			}
			if(check==true) {
				result=result+documentContent.get(i)+"\n";
			}
			
		}
		
		return result;
	}
	
	//ר�Ŷ�ȡdocument�ļ����Ž�ȫ�ֱ���ArrayList<String> documentContent��
	public void readDocument() {
				File file = new File("document.txt");// ����Ŀ¼
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
	
	//���ݲ��ҹؼ������ɲ���ģ��
	public void createBooleanModel() {
		
		for(int i=0;i<7;i++) {//��ʼ��
			for(int j=0;j<6;j++) {
				documentMatrix[i][j]=0;
			}
		}

		indexList.add("to");//0		
		indexList.add("do");//1
		indexList.add("i");//2
		indexList.add("am");//3
		indexList.add("let");//4
		indexList.add("it");//5
		
		
		//1.���Ƚ��ĵ���ȡ��һ��һά����֮��(str�У�
		File file = new File("document.txt");// ����Ŀ¼
        Scanner sc;
        String str="";	
        String [] strArray;
        int line=1;
		try {
			sc = new Scanner(file);						        	        
	        while (sc.hasNext()) {
	            str = sc.nextLine();
	            str=str.replace('.', ' ');
	            str=str.toLowerCase();
	            strArray = str.split(" ");
	            for(int i=0;i<strArray.length;i++) {
	            	for(int j=0;j<6;j++) {
	            		if(strArray[i].equals(indexList.get(j))) {
	            			documentMatrix[line-1][j]=1;
	            		}
	            	}
	            	
	            }
	            line++;
	        }
	        
	       sc.close();		       
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		for(int i=0;i<7;i++) {//��ʼ��
			for(int j=0;j<6;j++) {
				System.out.print(documentMatrix[i][j]);
			}
			System.out.print("\n");
		}
		/*��ȷ���
		 * 110000
			101100
			011100
			010011
			110001
			111001
			000000
		 */
		
	}
	
	
	//��ȡquery�ļ�
	//�������� https://blog.csdn.net/WXS153322/article/details/123898165
	public ArrayList<String> createIndexList() {
			//1.���Ƚ��ĵ���ȡ��һ��һά����֮��(str�У�
			File file = new File("read_write_test_file.txt");// ����Ŀ¼
	        Scanner sc;
	        String str="";	
	        String buff = new String();
			try {
				sc = new Scanner(file);						        	        
		        while (sc.hasNext()) {
		            buff = sc.nextLine();
		            str=str+buff;
		        }
		       //System.out.println("�ļ��ڵ��ַ���Ϣ��" + buff);
		       sc.close();		       
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			//System.out.println("�ļ��ڵ��ַ���Ϣ��" + str);
			
			//2.��ÿƪ�ĵ�ת����һ����token���б�
			//2.1 ���ı�ȫ��ת����Сд
			str=str.toLowerCase();
			//System.out.println("�ļ��ڵ��ַ���Ϣ��" + str);
			//2.2 ���ݡ����ַ������ı�ʹ��������ʽ�����и�
			
			String [] strArray = str.split(" ");
			/*
			for(int i=0;i<strArray.length;i++) {
				System.out.println("�ļ��ڵ��ַ���Ϣ��" + strArray[i]);
			}*/
			
			//3.������������
			ArrayList<String> indexList = new ArrayList<String>();
			for(int i=0;i<strArray.length;i++) {
				if(strArray[i].endsWith(":")==false) {//�����б�ʶ��
					if(indexList.contains(strArray[i])==false) {//���ڹؼ�����������
						indexList.add(strArray[i]);
					}
				}
			}
			//System.out.print(indexList);
			//indexList����������Ϊ[to, do, I, am, Let, it]
			return indexList;
	}

}


package ch3;
/**
 * @author Shihan Fu
 * @version 1.0
 * 布尔模型
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
		
		//成功，统计需要搜索的词以ArrayList<String>形式储存
		//ArrayList<String> showme =a.createIndexList();
		//System.out.println(showme);
		
		//a.createBooleanModel();
		
		a.BooleanModelSearchByQueryDocNo(2);

	}
	
	//自定义搜索
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
	
	//按照query文档里的搜索命令搜索
	public String BooleanModelSearchByQueryDocNo(int QueryDocNo) {
		String result="";
		//设计规则：-1是没有限制，1是有，2是无
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
	
	//根据查找关键词生成布尔模型
	public void createBooleanModel() {
		
		for(int i=0;i<7;i++) {//初始化
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
		
		
		//1.首先将文档读取到一个一维数据之中(str中）
		File file = new File("document.txt");// 创建目录
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
		
		for(int i=0;i<7;i++) {//初始化
			for(int j=0;j<6;j++) {
				System.out.print(documentMatrix[i][j]);
			}
			System.out.print("\n");
		}
		/*正确输出
		 * 110000
			101100
			011100
			010011
			110001
			111001
			000000
		 */
		
	}
	
	
	//读取query文件
	//倒排索引 https://blog.csdn.net/WXS153322/article/details/123898165
	public ArrayList<String> createIndexList() {
			//1.首先将文档读取到一个一维数据之中(str中）
			File file = new File("read_write_test_file.txt");// 创建目录
	        Scanner sc;
	        String str="";	
	        String buff = new String();
			try {
				sc = new Scanner(file);						        	        
		        while (sc.hasNext()) {
		            buff = sc.nextLine();
		            str=str+buff;
		        }
		       //System.out.println("文件内的字符信息：" + buff);
		       sc.close();		       
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			//System.out.println("文件内的字符信息：" + str);
			
			//2.将每篇文档转换成一个个token的列表
			//2.1 将文本全部转换成小写
			str=str.toLowerCase();
			//System.out.println("文件内的字符信息：" + str);
			//2.2 根据“非字符”对文本使用正则表达式进行切割
			
			String [] strArray = str.split(" ");
			/*
			for(int i=0;i<strArray.length;i++) {
				System.out.println("文件内的字符信息：" + strArray[i]);
			}*/
			
			//3.构建倒排索引
			ArrayList<String> indexList = new ArrayList<String>();
			for(int i=0;i<strArray.length;i++) {
				if(strArray[i].endsWith(":")==false) {//不是行标识符
					if(indexList.contains(strArray[i])==false) {//不在关键词索引表中
						indexList.add(strArray[i]);
					}
				}
			}
			//System.out.print(indexList);
			//indexList的索引序列为[to, do, I, am, Let, it]
			return indexList;
	}

}


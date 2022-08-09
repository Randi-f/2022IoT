package ch3;
/**
 * @author Shihan Fu
 * @version 1.0
 * 倒排索引
 * update 0626
 */
import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * @author Shihan Fu
 * @version 1.0
 * This is the inverted Index algorithm
 * update 0608
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class InvertedIndex {
	
	private static ArrayList<String> documentContent=new ArrayList<String>();
	
	private static ArrayList<occurance> toList=new ArrayList<occurance>();
	private static ArrayList<occurance> doList=new ArrayList<occurance>();
	private static ArrayList<occurance> iList=new ArrayList<occurance>();
	private static ArrayList<occurance> amList=new ArrayList<occurance>();
	private static ArrayList<occurance> letList=new ArrayList<occurance>();
	private static ArrayList<occurance> itList=new ArrayList<occurance>();
	
	public InvertedIndex() {
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InvertedIndex ii= new InvertedIndex();
		//ii.initiateItList();
		System.out.println(ii.returnResult(0));
		System.out.println(ii.returnResult(2));
	}
	
	public String returnResult(int query) {
		readDocument();
		String result="";
		if(query==0) {//q1:to
			initiateToList();
			for(int i=0;i<toList.size();i++) {
				result+=documentContent.get(toList.get(i).getDocuNo())+"\n";
			}
		}
		else if(query==1) {//q2: do 
			initiateDoList();
			for(int i=0;i<doList.size();i++) {
				result+=documentContent.get(doList.get(i).getDocuNo())+"\n";
			}
		}
		else if(query==2) {//q3: to do 
			initiateToList();
			initiateDoList();
			for(int i=0;i<toList.size();i++) {
				for(int j=0;j<doList.size();j++) {
					if(doList.get(j).getDocuNo()==toList.get(i).getDocuNo()) {
						result+=documentContent.get(toList.get(i).getDocuNo())+"\n";
					}
				}
				
			}
		}
		else if(query==3) {//q4: I am 
			initiateIList();
			initiateAmList();
			for(int i=0;i<iList.size();i++) {
				for(int j=0;j<amList.size();j++) {
					if(amList.get(j).getDocuNo()==iList.get(i).getDocuNo()) {
						result+=documentContent.get(iList.get(i).getDocuNo())+"\n";
					}
				}
				
			}
		}
		else if(query==4) {//q5: Let it 
			initiateLetList();
			initiateItList();
			for(int i=0;i<letList.size();i++) {
				for(int j=0;j<itList.size();j++) {
					if(itList.get(j).getDocuNo()==letList.get(i).getDocuNo()) {
						result+=documentContent.get(letList.get(i).getDocuNo())+"\n";
					}
				}
				
			}
		}
		System.out.println(result);
		removeAll();
		return result;
	}
	
	//清楚之前的信息，否则会对下一次使用造成影响
	public void removeAll() {
		toList.removeAll(toList);
		doList.removeAll(doList);
		iList.removeAll(iList);
		amList.removeAll(amList);
		letList.removeAll(letList);
		itList.removeAll(itList);
		documentContent.removeAll(documentContent);
	}
	public void initiateToList() {
		int docNo=0;
		System.out.println("to InvertedIndexMatrix:");
		for(String str: documentContent) {
			String [] strArray;
			occurance occ=new occurance(docNo);
			 str=str.replace('.', ' ');
	         str=str.toLowerCase();
	         strArray = str.split(" ");
	         //to
	         
	         for(int i=0;i<strArray.length;i++) {
	        	 if(strArray[i].equals("to")) {
	        		 occ.increserOccurTimes();
	        	 }
	         }
	         if(occ.occurTimes!=0) {
	        	 toList.add(occ);
	         }
	         docNo++;
		}
	
		Collections.sort(toList);
		for(int i=0;i<toList.size();i++) {
			System.out.println(toList.get(i).getDocuNo()+" with the occurTimes of: "+toList.get(i).getOccurTimes());
		}
	}
	
	public void initiateDoList() {
		int docNo=0;
		System.out.println("do InvertedIndexMatrix:");
		for(String str: documentContent) {
			String [] strArray;
			occurance occ=new occurance(docNo);
			 str=str.replace('.', ' ');
	         str=str.toLowerCase();
	         strArray = str.split(" ");

	         for(int i=0;i<strArray.length;i++) {
	        	 if(strArray[i].equals("do")) {
	        		 occ.increserOccurTimes();
	        	 }
	         }
	         if(occ.occurTimes!=0) {
	        	 doList.add(occ);
	         }
	         docNo++;
		}
	
		Collections.sort(doList);
		for(int i=0;i<doList.size();i++) {
			System.out.println(doList.get(i).getDocuNo()+" with the occurTimes of: "+doList.get(i).getOccurTimes());
		}
	}
	
	public void initiateIList() {
		int docNo=0;
		System.out.println("i InvertedIndexMatrix:");
		for(String str: documentContent) {
			String [] strArray;
			occurance occ=new occurance(docNo);
			 str=str.replace('.', ' ');
	         str=str.toLowerCase();
	         strArray = str.split(" ");

	         for(int i=0;i<strArray.length;i++) {
	        	 if(strArray[i].equals("i")) {
	        		 occ.increserOccurTimes();
	        	 }
	         }
	         if(occ.occurTimes!=0) {
	        	 iList.add(occ);
	         }
	         docNo++;
		}
	
		Collections.sort(iList);
		for(int i=0;i<iList.size();i++) {
			System.out.println(iList.get(i).getDocuNo()+" with the occurTimes of: "+iList.get(i).getOccurTimes());
		}
	}
	
	public void initiateAmList() {
		int docNo=0;
		System.out.println("am InvertedIndexMatrix:");
		for(String str: documentContent) {
			String [] strArray;
			occurance occ=new occurance(docNo);
			 str=str.replace('.', ' ');
	         str=str.toLowerCase();
	         strArray = str.split(" ");

	         for(int i=0;i<strArray.length;i++) {
	        	 if(strArray[i].equals("am")) {
	        		 occ.increserOccurTimes();
	        	 }
	         }
	         if(occ.occurTimes!=0) {
	        	 amList.add(occ);
	         }
	         docNo++;
		}
	
		Collections.sort(amList);
		for(int i=0;i<amList.size();i++) {
			System.out.println(amList.get(i).getDocuNo()+" with the occurTimes of: "+amList.get(i).getOccurTimes());
		}
	}
	
	public void initiateLetList() {
		int docNo=0;
		System.out.println("let InvertedIndexMatrix:");
		for(String str: documentContent) {
			String [] strArray;
			occurance occ=new occurance(docNo);
			 str=str.replace('.', ' ');
	         str=str.toLowerCase();
	         strArray = str.split(" ");

	         for(int i=0;i<strArray.length;i++) {
	        	 if(strArray[i].equals("let")) {
	        		 occ.increserOccurTimes();
	        	 }
	         }
	         if(occ.occurTimes!=0) {
	        	 letList.add(occ);
	         }
	         docNo++;
		}
	
		Collections.sort(letList);
		for(int i=0;i<letList.size();i++) {
			System.out.println(letList.get(i).getDocuNo()+" with the occurTimes of: "+letList.get(i).getOccurTimes());
		}
	}
	
	public void initiateItList() {
		int docNo=0;
		System.out.println("it InvertedIndexMatrix:");
		for(String str: documentContent) {
			String [] strArray;
			occurance occ=new occurance(docNo);
			 str=str.replace('.', ' ');
	         str=str.toLowerCase();
	         strArray = str.split(" ");

	         for(int i=0;i<strArray.length;i++) {
	        	 if(strArray[i].equals("it")) {
	        		 occ.increserOccurTimes();
	        	 }
	         }
	         if(occ.occurTimes!=0) {
	        	 itList.add(occ);
	         }
	         docNo++;
		}
	
		Collections.sort(itList);
		for(int i=0;i<itList.size();i++) {
			System.out.println(itList.get(i).getDocuNo()+" with the occurTimes of: "+itList.get(i).getOccurTimes());
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

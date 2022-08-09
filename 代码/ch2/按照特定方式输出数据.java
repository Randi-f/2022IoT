package ch2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class 按照特定方式输出数据 {
	public static void main(String[] args) {
        ArrayList<Point> dataSet = new ArrayList<Point>();
 
        File file = new File("C:\\Users\\lenovo\\Desktop\\第二章大作业\\测试数据_test.csv");// 创建目录
        Scanner sc;
		try {
			sc = new Scanner(file);
	        String str;
	        int line=0;
	        while (sc.hasNext()) {
	        	str=sc.nextLine();//按行读取文件
	        	if(line!=0) {
	        		dataSet.add(new Point(str));
	        		
	        	}
	        	line++;
	        	
	        }
	       sc.close();
	        
	       
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Point point:dataSet) {
			System.out.println(point.getAnOutput());
		}
	}
}

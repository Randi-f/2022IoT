package ch2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class �����ض���ʽ������� {
	public static void main(String[] args) {
        ArrayList<Point> dataSet = new ArrayList<Point>();
 
        File file = new File("C:\\Users\\lenovo\\Desktop\\�ڶ��´���ҵ\\��������_test.csv");// ����Ŀ¼
        Scanner sc;
		try {
			sc = new Scanner(file);
	        String str;
	        int line=0;
	        while (sc.hasNext()) {
	        	str=sc.nextLine();//���ж�ȡ�ļ�
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

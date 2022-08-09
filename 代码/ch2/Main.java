package ch2;
/**
 * @author Shihan Fu
 * @version 1.0
 * This is the test file of k_means
 * 参考：https://blog.csdn.net/fox_wayen/article/details/80467233?utm_medium=distribute.pc_relevant.none-task-blog-2~default~baidujs_title~default-0-80467233-blog-124992548.pc_relevant_default&spm=1001.2101.3001.4242.1&utm_relevant_index=3    
 * 另一种比较可行的办法：https://blog.csdn.net/jshayzf/article/details/22067855
 * update 0608
 */
import java.util.ArrayList;
import java.util.Set;
import java.io.*;
import java.util.Scanner;
public class Main {
	

	

	
	public static void main(String[] args) {
        ArrayList<Point> dataSet = new ArrayList<Point>();
 
        File file = new File("C:\\Users\\lenovo\\Desktop\\第二章大作业\\测试数据4.csv");// 创建目录
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
	
		
        
 
		//k-means		
        KMeansRun kRun =new KMeansRun(3, dataSet);
 
        Set<Cluster> clusterSet = kRun.run();
        System.out.println("单次迭代运行次数："+kRun.getIterTimes());
        for (Cluster cluster : clusterSet) {
            System.out.println(cluster);
        }
    }
}

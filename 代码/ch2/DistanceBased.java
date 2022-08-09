package ch2;
/**
 * @author Shihan Fu
 * @version 1.0
 * This is the distance-based method
 * update 0611
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DistanceBased {


	public static void main(String[] args) {
		//存放所有点
	    ArrayList<Point> dataSet = new ArrayList<Point>();
	    //存放异常点
	    ArrayList<Point> outlier = new ArrayList<Point>();
	    // 创建目录
	    File file = new File("C:\\Users\\lenovo\\Desktop\\第二章大作业\\测试数据.csv");
	    Scanner sc;
	    int line=0;
	    
		try {
			sc = new Scanner(file);
	        String str;
	        
	        while (sc.hasNext()) {
	        	str=sc.nextLine();//按行读取文件
	        	if(line!=0) {
	        		dataSet.add(new Point(str));	
	        	}
	        	line++;//实际数据行数line-1
	        }
	       sc.close();    
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		DistanceCompute dc = new DistanceCompute();
		double dist=0;
		double r=0.1;//一个一个试出来的0.1的表现最好
		double pai=0.1;
		int count=0;
		boolean isOutlier=true;
		for(int i=0;i<line-1;i++) {
			count=0;
			isOutlier=true;
			for(int j=0;j<line-1;j++) {
				dist=dc.getEuclideanDis(dataSet.get(i), dataSet.get(j));
				if((i!=j)&&(dist<=r)) {
					count++;
					if(count>=(line-1)*pai) {
						isOutlier=false;
						break;
					}
				}
			}
			if(isOutlier==true) {
				outlier.add(dataSet.get(i));
			}						
		}
		
		double correct=0.0;
		//一共检测出多少个异常点
		System.out.println("异常点数量："+outlier.size());
		for (Point point : outlier) {
			if(point.getStatus()==true) {
				correct++;
			}
		}
		int hasAnomaly=0;
		for(Point point : dataSet) {
			if(point.getStatus()==true) {
				hasAnomaly++;
			}
		}
		System.out.println("检出率："+correct/hasAnomaly);
		System.out.println("准确率："+correct/outlier.size());
		
	}
}

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
		//������е�
	    ArrayList<Point> dataSet = new ArrayList<Point>();
	    //����쳣��
	    ArrayList<Point> outlier = new ArrayList<Point>();
	    // ����Ŀ¼
	    File file = new File("C:\\Users\\lenovo\\Desktop\\�ڶ��´���ҵ\\��������.csv");
	    Scanner sc;
	    int line=0;
	    
		try {
			sc = new Scanner(file);
	        String str;
	        
	        while (sc.hasNext()) {
	        	str=sc.nextLine();//���ж�ȡ�ļ�
	        	if(line!=0) {
	        		dataSet.add(new Point(str));	
	        	}
	        	line++;//ʵ����������line-1
	        }
	       sc.close();    
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		DistanceCompute dc = new DistanceCompute();
		double dist=0;
		double r=0.1;//һ��һ���Գ�����0.1�ı������
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
		//һ���������ٸ��쳣��
		System.out.println("�쳣��������"+outlier.size());
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
		System.out.println("����ʣ�"+correct/hasAnomaly);
		System.out.println("׼ȷ�ʣ�"+correct/outlier.size());
		
	}
}

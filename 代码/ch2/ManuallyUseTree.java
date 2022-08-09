package ch2;
/**
 * @author Shihan Fu
 * @version 1.0
 * �������ɵľ��������в������ݵ��ж��쳣ֵ����
 * update 0608
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ManuallyUseTree {

	public static void main(String[] args) {
		ArrayList<DecisionTreeTest> dataSet = new ArrayList<DecisionTreeTest>();
		 
        File file = new File("C:\\Users\\lenovo\\Desktop\\�ڶ��´���ҵ\\��������_test.csv");// ����Ŀ¼
        Scanner sc;
        int line=-1;
		try {
			sc = new Scanner(file);
	        String str;
	        
	        while (sc.hasNext()) {
	        	str=sc.nextLine();//���ж�ȡ�ļ�
	        	if(line!=-1) {
	        		dataSet.add(new DecisionTreeTest(str));	        		
	        	}
	        	line++;	        	
	        }
	       sc.close();	       
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ArrayList<DecisionTreeTest> outlier=new ArrayList<DecisionTreeTest>();
		
		float theCpc;
		float theCpm;
		//�ֶ�����
		for(int i=0;i<dataSet.size();i++) {
			theCpc=dataSet.get(i).getCpc();
			theCpm=dataSet.get(i).getCpm();
			if(theCpc<=0.3024) {
				if(theCpm<=0.1815) {
					if(theCpm>0.0667) {
						if(theCpm<-0.0668) {
							outlier.add(dataSet.get(i));
						}
					}
				}
				else {
					if(theCpc<=0.0549) {
						outlier.add(dataSet.get(i));
					}
					else {
						if(theCpc>0.1766) {
							outlier.add(dataSet.get(i));
						}
					}
				}
			}
			else {
				if(theCpc>0.8375) {
					outlier.add(dataSet.get(i));
				}
				else {
					if(theCpc>0.6618) {
						if(theCpm>0.5249) {
						outlier.add(dataSet.get(i));
						}
					}
					else {
						if(theCpc>0.4471) {
							outlier.add(dataSet.get(i));
						}
						else {
							if(theCpc<=0.3887) {
								if(theCpm>0.0947) {
									outlier.add(dataSet.get(i));
								}
								else {
									if(theCpm<=0.0645) {
										outlier.add(dataSet.get(i));
									}
								}
							}
						}
					}
					
				}
			}
		}

		
		
		double correct=0.0;
		//һ���������ٸ��쳣��
		System.out.println("�쳣��������"+outlier.size());
		for (DecisionTreeTest point : outlier) {
			if(point.getStatus().equals("TRUE")) {
				correct++;
			}
		}
		int hasAnomaly=0;
		for(DecisionTreeTest point : dataSet) {
			if(point.getStatus().equals("TRUE")) {
				hasAnomaly++;
			}
		}
		System.out.println("����ʣ�"+correct/hasAnomaly);
		System.out.println("׼ȷ�ʣ�"+correct/outlier.size());
		
		
		
	}

}

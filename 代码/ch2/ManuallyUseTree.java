package ch2;
/**
 * @author Shihan Fu
 * @version 1.0
 * 根据生成的决策树进行测试数据的判断异常值处理
 * update 0608
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ManuallyUseTree {

	public static void main(String[] args) {
		ArrayList<DecisionTreeTest> dataSet = new ArrayList<DecisionTreeTest>();
		 
        File file = new File("C:\\Users\\lenovo\\Desktop\\第二章大作业\\测试数据_test.csv");// 创建目录
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
		ArrayList<DecisionTreeTest> outlier=new ArrayList<DecisionTreeTest>();
		
		float theCpc;
		float theCpm;
		//手动放树
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
		//一共检测出多少个异常点
		System.out.println("异常点数量："+outlier.size());
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
		System.out.println("检出率："+correct/hasAnomaly);
		System.out.println("准确率："+correct/outlier.size());
		
		
		
	}

}

package ch2;
/**
 * @author Shihan Fu
 * @version 1.0
 * 测试infoGain结果是否准确
 * update 0608
 */
public class tt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		double[] cpcSmallerThanNum1={2.0,3.0};//{TRUE, FALSE}
		int line=14;
		double Info_cpc=(cpcSmallerThanNum1[0]+cpcSmallerThanNum1[1])/line*I(cpcSmallerThanNum1[0],cpcSmallerThanNum1[1]);
		
		cpcSmallerThanNum1[0]=4.0;
		cpcSmallerThanNum1[0]=0.0;
		Info_cpc+=(cpcSmallerThanNum1[0]+cpcSmallerThanNum1[1])/line*I(cpcSmallerThanNum1[0],cpcSmallerThanNum1[1]);
		cpcSmallerThanNum1[0]=3.0;
		cpcSmallerThanNum1[0]=2.0;
		Info_cpc+=(cpcSmallerThanNum1[0]+cpcSmallerThanNum1[1])/line*I(cpcSmallerThanNum1[0],cpcSmallerThanNum1[1]);
		
		System.out.println(Info_cpc);
	}

	public static double I(double a, double b) {
		if(a==0||b==0) {
			return 0.0;
		}
		else{
			double p1=a/(a+b);
			double p2=b/(a+b);
			return -p1*Math.log(p1)/Math.log(2)-p2*Math.log(p2)/Math.log(2);
		}
		
	}
	
}

package ch3;
/**
 * @author Shihan Fu
 * @version 1.0
 * ����������Ҫ���࣬�����ĵ���+����Ƶ��
 * update 0608
 */
public class occurance implements Comparable<occurance>{

	int docuNo;
	int occurTimes=0;
	public occurance(int docNo) {
		this.docuNo=docNo;
	}
	public void increserOccurTimes() {
		this.occurTimes++;
	}
	public int getOccurTimes() {
		return this.occurTimes;
	}
	public int getDocuNo() {
		return this.docuNo;
	}
	@Override
    public int compareTo(occurance o) {
        
        return this.occurTimes-o.getOccurTimes();
    }

}

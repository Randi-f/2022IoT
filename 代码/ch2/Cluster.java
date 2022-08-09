package ch2;
/**
 * @author Shihan Fu
 * @version 1.0
 * This is the cluster package of k_means
 * update 0608
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
 
public class Cluster{
    private int id;// ��ʶ
    private Point center;// ����
    private List<Point> members = new ArrayList<Point>();// ��Ա
 
    public Cluster(int id, Point center) {
        this.id = id;
        this.center = center;
    }
 
    public Cluster(int id, Point center, List<Point> members) {
        this.id = id;
        this.center = center;
        this.members = members;
    }
 
    public void addPoint(Point newPoint) {
        if (!members.contains(newPoint)){
            members.add(newPoint);
        }else{
            System.out.println("�������ݵ� {"+newPoint.toString()+"} �Ѿ����ڣ�");
        }
    }
 
    public int getId() {
        return id;
    }
 
    public Point getCenter() {
        return center;
    }
 
    public void setCenter(Point center) {
        this.center = center;
    }
 
    public List<Point> getMembers() {
        return members;
    }
 
   
    
    @Override
    public String toString() {
        String toString = "Cluster \n" + "Cluster_id=" + this.id + ", center:{" + this.center.toString()+"}";
        float maxDist=0;
    	int theID=0;
    	boolean status=false;
    	//ʹ��sort���򷽷�����members����ѡ������2��
    	//members.sort(null);
    	Collections.sort(members, new Comparator<Point>() {
            @Override
            public int compare(Point u1, Point u2) {
                if(u1.getDist() > u2.getDist()) {
                    //return -1:��Ϊ��������
                    return 1;
                }else if (u1.getDist() == u2.getDist()) {
                    return 0;
                }else {
                    //return 1: ��Ϊ��������
                    return -1;
                }
            }
        });

    	 
    	 
    	int index=members.size();
    	//���������������������ѡ2��
    	if(index>=2) {
    		theID=members.get(index-1).getId();
    		maxDist=members.get(index-1).getDist();
    		status=members.get(index-1).getStatus();
    		toString+="\n�쳣�㣺[id]"+theID+" dist: "+maxDist+" status:"+ status+"\n";
    		theID=members.get(index-2).getId();
    		maxDist=members.get(index-2).getDist();
    		status=members.get(index-2).getStatus();
    		toString+="\n�쳣�㣺[id]"+theID+" dist: "+maxDist+" status:"+ status+"\n";
    	}
    	else {//ѡһ��
    		theID=members.get(index-1).getId();
    		maxDist=members.get(index-1).getDist();
    		status=members.get(index-1).getStatus();
    		toString+="\n�쳣�㣺[id]"+theID+" dist: "+maxDist+" status:"+ status+"\n";
    	}
    	
    	
    	//��ÿһ����ѡ����Զdist��Ϊ�쳣��
       // for (Point point : members) {
        	
        	//if(point.getDist()>maxDist) {
        		//maxDist=point.getDist();
        		//theID=point.getId();
        		//status=point.getStatus();
        	//}
           // toString+="\n"+point.toString();
        	
        //}
        ///toString+="\n�쳣�㣺[id]"+theID+" dist: "+maxDist+" status:"+ status;
        return toString+"\n";
    }
}
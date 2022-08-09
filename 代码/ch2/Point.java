package ch2;
/**
 * @author Shihan Fu
 * @version 1.0
 * This is the point package of k_means
 * update 0608
 */

public class Point implements Comparable<Point>{
	private float[] localArray= new float[2];
	private float dist;     // 标识和所属类中心的距离。
    private int id;
    private int clusterId;  // 标识属于哪个类中心。
 
    private boolean is_anomaly;
    
    public  Point(String info) {
		String [] strArray = info.split(",");
		this.id=Integer.parseInt(strArray[0]);
		this.localArray[0]=Float.parseFloat(strArray[1]);
		this.localArray[1]=Float.parseFloat(strArray[2]);	
		if(strArray[3].equals("TRUE")) {
			this.is_anomaly=true;
		}
		else {
			this.is_anomaly=false;
		}
	}
    
    public Point(int id, float[] localArray) {
        this.id = id;
        this.localArray = localArray;
    }
 
    public Point(float[] localArray) {
        this.id = -1; //表示不属于任意一个类
        this.localArray = localArray;
    }
 
    public float[] getlocalArray() {
        return localArray;
    }
 
    public int getId() {
        return id;
    }
 
    public void setClusterId(int clusterId) {
        this.clusterId = clusterId;
    }
 
    public int getClusterid() {
        return clusterId;
    }
 
    public float getDist() {
        return dist;
    }
 
    public boolean getStatus() {
    	return is_anomaly;
    }
    public void setDist(float dist) {
        this.dist = dist;
    }
 
    @Override
    public String toString() {
    	return "`"+this.id+" " + this.localArray[0]+","+this.localArray[1]+" dist: "+dist+ " anomaly:"+ is_anomaly;
    	/*
        String result = "Point_id=" + id + "  [";
        for (int i = 0; i < localArray.length; i++) {
            result += localArray[i] + " ";
        }
        return result.trim()+"] clusterId: "+clusterId+" dist: "+dist;*/
    }
 
    @Override
    public int compareTo(Point p) {
    	return (int)(this.dist - p.dist);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass())
            return false;
 
        Point point = (Point) obj;
        if (point.localArray.length != localArray.length)
            return false;
 
        for (int i = 0; i < localArray.length; i++) {
            if (Float.compare(point.localArray[i], localArray[i]) != 0) {
                return false;
            }
        }
        return true;
    }
 
    @Override
    public int hashCode() {
        float x = localArray[0];
        float y = localArray[localArray.length - 1];
        long temp = x != +0.0d ? Double.doubleToLongBits(x) : 0L;
        int result = (int) (temp ^ (temp >>> 32));
        temp = y != +0.0d ? Double.doubleToLongBits(y) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
    
    public String getAnOutput() {
    	return "['1',"+ + this.localArray[0]+","+this.localArray[1]+"],";
    	//return "'"+this.is_anomaly+"',";
    }
}
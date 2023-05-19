public class VertexInfo {
    private double distance;
    private int previous;
    public VertexInfo(double d, int p){
        this.distance = d;
        this.previous = p;
    }
    public double getDistance(){
        return distance;
    }
    public int getPrevious(){
        return previous;
    }
}

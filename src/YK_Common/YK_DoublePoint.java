package YK_Common;

public class YK_DoublePoint {

    public double x;
    public double y;

    public YK_DoublePoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if(getClass() == obj.getClass()) {
            return ((x == ((YK_DoublePoint)obj).x) && (y == ((YK_DoublePoint)obj).y));
        }
        return false;
    }

    @Override
    public String toString() {
        return "[" + x + "," + y + "]";
    }
}

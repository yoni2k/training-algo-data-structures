package YK_Common;

public class YK_Line {
    protected double slope;
    protected double yInt;

    public YK_Line(YK_DoublePoint p1, YK_DoublePoint p2) {
        slope = (p2.y - p1.y)/(p2.x - p1.x);
        yInt = p1.y - slope*p1.x;
    }

    public YK_DoublePoint getPointGivenX(double x) {
        return new YK_DoublePoint(x, x*slope + yInt);
    }

    @Override
    public boolean equals(Object obj) {
        if(getClass() == obj.getClass()) {
            return ((slope == ((YK_Line)obj).slope) && (yInt == ((YK_Line)obj).yInt));
        }
        return false;
    }

    @Override
    public int hashCode() {
        //really bad hash function, just to make sure things work by calling equals above
        return (int)slope + (int)yInt;
    }

    @Override
    public String toString() {
        return "Line: [y=" + slope + "*x + " + yInt + "]";
    }
}

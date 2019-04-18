package YK_Common;

public class YK_Line {
    private double slope;
    private double yInt;

    private double minX;
    private double maxX;
    private double minY;
    private double maxY;

    public YK_Line(YK_DoublePoint p1, YK_DoublePoint p2) {
        slope = (p2.y - p1.y)/(p2.x - p1.x);
        yInt = p1.y - slope*p1.x;
        minX = Math.min(p1.x, p2.x);
        maxX = Math.max(p1.x, p2.x);
        minY = Math.min(p1.y, p2.y);
        maxY = Math.max(p1.y, p2.y);
    }

    public YK_DoublePoint getPointGivenX(double x) {
        return new YK_DoublePoint(x, x*slope + yInt);
    }

    public boolean inScope(YK_DoublePoint p) {
        return ((p.x >= minX) && (p.x <= maxX) && (p.y >= minY) && (p.y <= maxY));
    }

    public YK_DoublePoint getIntercept(YK_Line l2) {
        if ((slope == l2.slope) && (yInt != l2.yInt)) {
            return null; //will never cross even theoretically
        }

        double possibleX;

        if(slope != l2.slope) {
            possibleX = (l2.yInt - yInt)/(slope - l2.slope);
        } else { //if ((l1.slope == l2.slope) && (l1.yInt == l2.yInt))
            possibleX = Math.max(minX, l2.minX); //there are actually many points, returning one of them with smallest X
        }

        YK_DoublePoint interP = getPointGivenX(possibleX);

        if(!inScope(interP) || !l2.inScope(interP)) {
            return null;
        }

        return interP;
    }
}

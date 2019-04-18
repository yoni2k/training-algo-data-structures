package YK_Common;

public class YK_LineSegment extends YK_Line {

    private double minX;
    private double maxX;
    private double minY;
    private double maxY;

    public YK_LineSegment(YK_DoublePoint p1, YK_DoublePoint p2) {
        super(p1, p2);

        minX = Math.min(p1.x, p2.x);
        maxX = Math.max(p1.x, p2.x);
        minY = Math.min(p1.y, p2.y);
        maxY = Math.max(p1.y, p2.y);
    }

    public boolean inSegment(YK_DoublePoint p) {
        return ((p.x >= minX) && (p.x <= maxX) && (p.y >= minY) && (p.y <= maxY));
    }

    public YK_DoublePoint getInterceptInSegment(YK_LineSegment l2) {
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

        if(!inSegment(interP) || !l2.inSegment(interP)) {
            return null;
        }

        return interP;
    }
}

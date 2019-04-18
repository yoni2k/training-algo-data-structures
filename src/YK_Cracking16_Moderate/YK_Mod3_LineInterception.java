package YK_Cracking16_Moderate;

/*
 Source: Cracking 16.3
 Given two straight line segments represented as 2 start and end points, return point of interception.
 If don't intercept, return null


 */

import YK_Common.YK_DoublePoint;

public class YK_Mod3_LineInterception {
    private class Line {
        double slope;
        double yInt;

        double minX;
        double maxX;
        double minY;
        double maxY;

        Line(YK_DoublePoint p1, YK_DoublePoint p2) {
            slope = (p2.y - p1.y)/(p2.x - p1.x);
            yInt = p1.y - slope*p1.x;
            minX = Math.min(p1.x, p2.x);
            maxX = Math.max(p1.x, p2.x);
            minY = Math.min(p1.y, p2.y);
            maxY = Math.max(p1.y, p2.y);
        }

        YK_DoublePoint getPointGivenX(double x) {
            return new YK_DoublePoint(x, x*slope + yInt);
        }

        boolean inScope(YK_DoublePoint p) {
            return ((p.x >= minX) && (p.x <= maxX) && (p.y >= minY) && (p.y <= maxY));
        }

        YK_DoublePoint getIntercept(Line l2) {
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

    public YK_DoublePoint getIntercept(YK_DoublePoint s1, YK_DoublePoint e1, YK_DoublePoint s2, YK_DoublePoint e2) {
        Line l1 = new Line(s1, e1);
        Line l2 = new Line(s2, e2);

        return l1.getIntercept(l2);
    }
}

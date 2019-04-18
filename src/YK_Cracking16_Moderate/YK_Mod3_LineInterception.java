package YK_Cracking16_Moderate;

/*
 Source: Cracking 16.3
 Given two straight line segments represented as 2 start and end points, return point of interception.
 If don't intercept, return null


 */

import YK_Common.YK_DoublePoint;
import YK_Common.YK_Line;
import YK_Common.YK_LineSegment;

public class YK_Mod3_LineInterception {

    public YK_DoublePoint getIntercept(YK_DoublePoint s1, YK_DoublePoint e1, YK_DoublePoint s2, YK_DoublePoint e2) {
        YK_LineSegment ls1 = new YK_LineSegment(s1, e1);
        YK_LineSegment ls2 = new YK_LineSegment(s2, e2);

        return ls1.getInterceptInSegment(ls2);
    }
}

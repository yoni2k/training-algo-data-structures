package YK_Cracking16_Moderate;

/*
 Source: Cracking 16.3
 Given two straight line segments represented as 2 start and end points, return point of interception.
 If don't intercept, return null


 */

import YK_Common.YK_DoublePoint;
import YK_Common.YK_Line;

public class YK_Mod3_LineInterception {

    public YK_DoublePoint getIntercept(YK_DoublePoint s1, YK_DoublePoint e1, YK_DoublePoint s2, YK_DoublePoint e2) {
        YK_Line l1 = new YK_Line(s1, e1);
        YK_Line l2 = new YK_Line(s2, e2);

        return l1.getIntercept(l2);
    }
}

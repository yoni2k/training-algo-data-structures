package YK_Cracking16_Moderate;

import YK_Common.YK_DoublePoint;
import YK_Common.YK_Line;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YK_Mod14_MostPointsOnLineTest {

    @Test
    void simple() {
        YK_DoublePoint[] points = new YK_DoublePoint[4];
        points[0] = new YK_DoublePoint(3,3);
        points[1] = new YK_DoublePoint(2,1);
        points[2] = new YK_DoublePoint(6,6);
        points[3] = new YK_DoublePoint(1,1);

        YK_Line line = new YK_Mod14_MostPointsOnLine().getLineMostPoints(points);
        System.out.println(line.toString());

        assertEquals(line, new YK_Line(points[3], points[2]));
    }
}
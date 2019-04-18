package YK_Cracking16_Moderate;

import YK_Common.YK_DoublePoint;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YK_Mod3_LineInterceptionTest {

    @Test
    void diffSlopePosXPosY() {
        assertEquals(   new YK_DoublePoint(2.0,2.0),
                        new YK_Mod3_LineInterception().getIntercept(
                            new YK_DoublePoint(1,1),
                            new YK_DoublePoint(3,3),
                            new YK_DoublePoint(3,0),
                            new YK_DoublePoint(1,4)
                ));
        assertEquals(   new YK_DoublePoint(2.0,2.0),
                new YK_Mod3_LineInterception().getIntercept(
                        new YK_DoublePoint(3,3),
                        new YK_DoublePoint(1,1),
                        new YK_DoublePoint(3,0),
                        new YK_DoublePoint(1,4)
                ));
        assertEquals(   new YK_DoublePoint(2.0,2.0),
                new YK_Mod3_LineInterception().getIntercept(
                        new YK_DoublePoint(3,3),
                        new YK_DoublePoint(1,1),
                        new YK_DoublePoint(1,4),
                        new YK_DoublePoint(3,0)
                ));

        assertEquals(   new YK_DoublePoint(2.0,2.0),
                new YK_Mod3_LineInterception().getIntercept(
                        new YK_DoublePoint(3,3),
                        new YK_DoublePoint(0,0),
                        new YK_DoublePoint(1,4),
                        new YK_DoublePoint(3,0)
                ));
        assertEquals(   new YK_DoublePoint(2.0,2.0),
                new YK_Mod3_LineInterception().getIntercept(
                        new YK_DoublePoint(3,3),
                        new YK_DoublePoint(-1,-1),
                        new YK_DoublePoint(1,4),
                        new YK_DoublePoint(3,0)
                ));
        assertEquals(   new YK_DoublePoint(2.0,2.0),
                new YK_Mod3_LineInterception().getIntercept(
                        new YK_DoublePoint(3,3),
                        new YK_DoublePoint(-1,-1),
                        new YK_DoublePoint(1,4),
                        new YK_DoublePoint(4,-2)
                ));
    }

    @Test
    void diffSlopeNegXPosY() {
        assertEquals(   new YK_DoublePoint(-2.0,2.0),
                new YK_Mod3_LineInterception().getIntercept(
                        new YK_DoublePoint(-1,1),
                        new YK_DoublePoint(-3,3),
                        new YK_DoublePoint(-3,0),
                        new YK_DoublePoint(-1,4)
                ));
        assertEquals(   new YK_DoublePoint(-2.0,2.0),
                new YK_Mod3_LineInterception().getIntercept(
                        new YK_DoublePoint(-3,3),
                        new YK_DoublePoint(-1,1),
                        new YK_DoublePoint(-3,0),
                        new YK_DoublePoint(-1,4)
                ));
        assertEquals(   new YK_DoublePoint(-2.0,2.0),
                new YK_Mod3_LineInterception().getIntercept(
                        new YK_DoublePoint(-3,3),
                        new YK_DoublePoint(-1,1),
                        new YK_DoublePoint(-1,4),
                        new YK_DoublePoint(-3,0)
                ));

        assertEquals(   new YK_DoublePoint(-2.0,2.0),
                new YK_Mod3_LineInterception().getIntercept(
                        new YK_DoublePoint(-3,3),
                        new YK_DoublePoint(0,0),
                        new YK_DoublePoint(-1,4),
                        new YK_DoublePoint(-3,0)
                ));
        assertEquals(   new YK_DoublePoint(-2.0,2.0),
                new YK_Mod3_LineInterception().getIntercept(
                        new YK_DoublePoint(-3,3),
                        new YK_DoublePoint(1,-1),
                        new YK_DoublePoint(-1,4),
                        new YK_DoublePoint(-3,0)
                ));
        assertEquals(   new YK_DoublePoint(-2.0,2.0),
                new YK_Mod3_LineInterception().getIntercept(
                        new YK_DoublePoint(-3,3),
                        new YK_DoublePoint(1,-1),
                        new YK_DoublePoint(-1,4),
                        new YK_DoublePoint(-4,-2)
                ));
    }

    @Test
    void diffSlopePosXNegY() {
        assertEquals(   new YK_DoublePoint(2.0,-2.0),
                new YK_Mod3_LineInterception().getIntercept(
                        new YK_DoublePoint(1,-1),
                        new YK_DoublePoint(3,-3),
                        new YK_DoublePoint(3,0),
                        new YK_DoublePoint(1,-4)
                ));
        assertEquals(   new YK_DoublePoint(2.0,-2.0),
                new YK_Mod3_LineInterception().getIntercept(
                        new YK_DoublePoint(3,-3),
                        new YK_DoublePoint(1,-1),
                        new YK_DoublePoint(3,0),
                        new YK_DoublePoint(1,-4)
                ));
        assertEquals(   new YK_DoublePoint(2.0,-2.0),
                new YK_Mod3_LineInterception().getIntercept(
                        new YK_DoublePoint(3,-3),
                        new YK_DoublePoint(1,-1),
                        new YK_DoublePoint(1,-4),
                        new YK_DoublePoint(3,0)
                ));

        assertEquals(   new YK_DoublePoint(2.0,-2.0),
                new YK_Mod3_LineInterception().getIntercept(
                        new YK_DoublePoint(3,-3),
                        new YK_DoublePoint(0,0),
                        new YK_DoublePoint(1,-4),
                        new YK_DoublePoint(3,0)
                ));
        assertEquals(   new YK_DoublePoint(2.0,-2.0),
                new YK_Mod3_LineInterception().getIntercept(
                        new YK_DoublePoint(3,-3),
                        new YK_DoublePoint(-1,1),
                        new YK_DoublePoint(1,-4),
                        new YK_DoublePoint(3,0)
                ));
        assertEquals(   new YK_DoublePoint(2.0,-2.0),
                new YK_Mod3_LineInterception().getIntercept(
                        new YK_DoublePoint(3,-3),
                        new YK_DoublePoint(-1,1),
                        new YK_DoublePoint(1,-4),
                        new YK_DoublePoint(4,2)
                ));
    }

    @Test
    void diffSlopeNegXNegY() {
        assertEquals(   new YK_DoublePoint(-2.0,-2.0),
                new YK_Mod3_LineInterception().getIntercept(
                        new YK_DoublePoint(-1,-1),
                        new YK_DoublePoint(-3,-3),
                        new YK_DoublePoint(-3,0),
                        new YK_DoublePoint(-1,-4)
                ));
        assertEquals(   new YK_DoublePoint(-2.0,-2.0),
                new YK_Mod3_LineInterception().getIntercept(
                        new YK_DoublePoint(-3,-3),
                        new YK_DoublePoint(-1,-1),
                        new YK_DoublePoint(-3,0),
                        new YK_DoublePoint(-1,-4)
                ));
        assertEquals(   new YK_DoublePoint(-2.0,-2.0),
                new YK_Mod3_LineInterception().getIntercept(
                        new YK_DoublePoint(-3,-3),
                        new YK_DoublePoint(-1,-1),
                        new YK_DoublePoint(-1,-4),
                        new YK_DoublePoint(-3,0)
                ));

        assertEquals(   new YK_DoublePoint(-2.0,-2.0),
                new YK_Mod3_LineInterception().getIntercept(
                        new YK_DoublePoint(-3,-3),
                        new YK_DoublePoint(0,0),
                        new YK_DoublePoint(-1,-4),
                        new YK_DoublePoint(-3,0)
                ));
        assertEquals(   new YK_DoublePoint(-2.0,-2.0),
                new YK_Mod3_LineInterception().getIntercept(
                        new YK_DoublePoint(-3,-3),
                        new YK_DoublePoint(1,1),
                        new YK_DoublePoint(-1,-4),
                        new YK_DoublePoint(-3,0)
                ));
        assertEquals(   new YK_DoublePoint(-2.0,-2.0),
                new YK_Mod3_LineInterception().getIntercept(
                        new YK_DoublePoint(-3,-3),
                        new YK_DoublePoint(1,1),
                        new YK_DoublePoint(-1,-4),
                        new YK_DoublePoint(-4,2)
                ));
    }

    @Test
    void bothPossSlope() {
        assertEquals(   new YK_DoublePoint(2.0,2.0),
                new YK_Mod3_LineInterception().getIntercept(
                        new YK_DoublePoint(0,0),
                        new YK_DoublePoint(4,4),
                        new YK_DoublePoint(1,0),
                        new YK_DoublePoint(3,4)
                ));
    }

    @Test
    void intersectAt0() {
        assertEquals(   new YK_DoublePoint(0,0),
                new YK_Mod3_LineInterception().getIntercept(
                        new YK_DoublePoint(-1,-1),
                        new YK_DoublePoint(1,1),
                        new YK_DoublePoint(-1,1),
                        new YK_DoublePoint(1,-1)
                ));
    }

    @Test
    void sameSlopeDiffIntX() {
        assertNull(
                new YK_Mod3_LineInterception().getIntercept(
                        new YK_DoublePoint(0,0),
                        new YK_DoublePoint(1,1),
                        new YK_DoublePoint(0,1),
                        new YK_DoublePoint(1,2)
                ));
    }

    @Test
    void sameSlopeSameIntXNotTouching() {
        assertNull(
                new YK_Mod3_LineInterception().getIntercept(
                        new YK_DoublePoint(0,0),
                        new YK_DoublePoint(1,1),
                        new YK_DoublePoint(2,2),
                        new YK_DoublePoint(3,3)
                ));
    }

    @Test
    void diffSlopeNotTouching() {
        assertNull(
                new YK_Mod3_LineInterception().getIntercept(
                        new YK_DoublePoint(1,3),
                        new YK_DoublePoint(2,2),
                        new YK_DoublePoint(2,1),
                        new YK_DoublePoint(3,2)
                ));
    }

    @Test
    void diffSlopeTouchingNotCrossing() {
        assertEquals(   new YK_DoublePoint(2,2),
                new YK_Mod3_LineInterception().getIntercept(
                        new YK_DoublePoint(1,1),
                        new YK_DoublePoint(3,3),
                        new YK_DoublePoint(1,3),
                        new YK_DoublePoint(2,2)
                ));
    }

    @Test
    void sameSlopeTouching() {
        assertEquals(   new YK_DoublePoint(2,2),
                new YK_Mod3_LineInterception().getIntercept(
                        new YK_DoublePoint(1,1),
                        new YK_DoublePoint(2,2),
                        new YK_DoublePoint(2,2),
                        new YK_DoublePoint(3,3)
                ));
    }

    @Test
    void sameSlopeOverLapping() {
        assertEquals(   new YK_DoublePoint(2,2),
                new YK_Mod3_LineInterception().getIntercept(
                        new YK_DoublePoint(1,1),
                        new YK_DoublePoint(3,3),
                        new YK_DoublePoint(2,2),
                        new YK_DoublePoint(3,3)
                ));
    }
}
package YK_Cracking16_Moderate;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class YK_Mod22_LangtonsAntTest {

    @Test
    void k1() {
        for(int i = 0; i < 10; i++) {
            new YK_Mod22_LangtonsAnt().printKMoves(1);
        }
    }

    @Test
    void k2() {
        for(int i = 0; i < 10; i++) {
            new YK_Mod22_LangtonsAnt().printKMoves(2);
        }
    }

    @Test
    void k3() {
        for(int i = 0; i < 10; i++) {
            new YK_Mod22_LangtonsAnt().printKMoves(3);
        }
    }

    @Test
    void k4() {
        for(int i = 0; i < 10; i++) {
            new YK_Mod22_LangtonsAnt().printKMoves(4);
        }
    }

    @Test
    void k5() {
        for(int i = 0; i < 10; i++) {
            new YK_Mod22_LangtonsAnt().printKMoves(5);
        }
    }

    @Test
    void randomK() {
        Random rand = new Random();
        for(int i = 0; i < 100; i++) {
            new YK_Mod22_LangtonsAnt().printKMoves(rand.nextInt(100));
        }
    }

}
package YK_Cracking17_Hard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class YK_Hard13_ReSpaceTest {

    @Test
    void test() {
        String conc = "mynameisyoninolastname";
        String[] dic = {"i","in","is","last","me","my","no","name","on"};
        String[] exp = {"my","name","is","y","on","i","no","last","name"};
        String[] act = new YK_Hard13_ReSpace().unconcatenate(dic, conc);

        System.out.println("Actual: " + Arrays.toString(act));

        assertArrayEquals(exp, new YK_Hard13_ReSpace().unconcatenate(dic, conc));

    }

}
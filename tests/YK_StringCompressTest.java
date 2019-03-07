import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YK_StringCompressTest {

    @Test
    void zeroLen() {
        assertEquals("",YK_StringCompress.compress(""));
    }

    @Test
    void nothingToCompress() {
        assertEquals("a",YK_StringCompress.compress("a"));
        assertEquals("ab",YK_StringCompress.compress("ab"));
        assertEquals("ababa",YK_StringCompress.compress("ababa"));
    }

    @Test
    void noLenImprove() {
        //only 1 pair
        assertEquals("aa",YK_StringCompress.compress("aa"));//only
        assertEquals("XXb",YK_StringCompress.compress("XXb"));//beginning
        assertEquals("bXXXc",YK_StringCompress.compress("bXXXc"));//middle
        assertEquals("bXX",YK_StringCompress.compress("bXX"));//end

        //a lot of 1s
        assertEquals("abXXXX",YK_StringCompress.compress("abXXXX"));//same len
        assertEquals("abcXXXX",YK_StringCompress.compress("abcXXXX"));//even worse
    }

    @Test
    void lenImprove() {
        //only 1 tripple/4/5 letters
        assertEquals("a3",YK_StringCompress.compress("aaa"));//only
        assertEquals("X4a1",YK_StringCompress.compress("XXXXa"));//beginning
        assertEquals("a1X5b1",YK_StringCompress.compress("aXXXXXb"));//middle
        assertEquals("a1X4",YK_StringCompress.compress("aXXXX"));//end

        //2 tripples + letter
        assertEquals("a3b3",YK_StringCompress.compress("aaabbb"));//only
        assertEquals("X1a3b3",YK_StringCompress.compress("Xaaabbb"));//beginning
        assertEquals("a3X1b3",YK_StringCompress.compress("aaaXbbb"));//middle
        assertEquals("a3b3X1",YK_StringCompress.compress("aaabbbX"));//end

        //Long different
        assertEquals("a3b3c2d1e2f1g1h4",YK_StringCompress.compress("aaabbbccdeefghhhh"));//end
    }
}
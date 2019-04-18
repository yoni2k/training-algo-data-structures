package YK_Cracking16_Moderate;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class YK_Mod4_TicTacToeTest {

    @Test
    void row0() {
        YK_Mod4_TicTacToe board = new YK_Mod4_TicTacToe(3);

        board.move(new Point(0,0), YK_Mod4_TicTacToe.PLAYER.ONE);
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWon());
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWonFromScratch());

        board.move(new Point(2,0), YK_Mod4_TicTacToe.PLAYER.TWO);
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWon());
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWonFromScratch());


        board.move(new Point(0,1), YK_Mod4_TicTacToe.PLAYER.ONE);
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWon());
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWonFromScratch());

        board.move(new Point(2,1), YK_Mod4_TicTacToe.PLAYER.TWO);
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWon());
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWonFromScratch());


        board.move(new Point(0,2), YK_Mod4_TicTacToe.PLAYER.ONE);
        assertEquals(YK_Mod4_TicTacToe.PLAYER.ONE, board.whoWon());
        assertEquals(YK_Mod4_TicTacToe.PLAYER.ONE, board.whoWonFromScratch());
    }

    @Test
    void row1() {
        YK_Mod4_TicTacToe board = new YK_Mod4_TicTacToe(3);

        board.move(new Point(1,0), YK_Mod4_TicTacToe.PLAYER.ONE);
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWon());
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWonFromScratch());

        board.move(new Point(2,0), YK_Mod4_TicTacToe.PLAYER.TWO);
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWon());
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWonFromScratch());


        board.move(new Point(1,1), YK_Mod4_TicTacToe.PLAYER.ONE);
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWon());
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWonFromScratch());

        board.move(new Point(2,1), YK_Mod4_TicTacToe.PLAYER.TWO);
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWon());
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWonFromScratch());


        board.move(new Point(1,2), YK_Mod4_TicTacToe.PLAYER.ONE);
        assertEquals(YK_Mod4_TicTacToe.PLAYER.ONE, board.whoWon());
        assertEquals(YK_Mod4_TicTacToe.PLAYER.ONE, board.whoWonFromScratch());
    }

    @Test
    void row2() {
        YK_Mod4_TicTacToe board = new YK_Mod4_TicTacToe(3);

        board.move(new Point(2,0), YK_Mod4_TicTacToe.PLAYER.ONE);
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWon());
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWonFromScratch());

        board.move(new Point(1,0), YK_Mod4_TicTacToe.PLAYER.TWO);
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWon());
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWonFromScratch());


        board.move(new Point(2,1), YK_Mod4_TicTacToe.PLAYER.ONE);
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWon());
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWonFromScratch());

        board.move(new Point(1,1), YK_Mod4_TicTacToe.PLAYER.TWO);
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWon());
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWonFromScratch());


        board.move(new Point(2,2), YK_Mod4_TicTacToe.PLAYER.ONE);
        assertEquals(YK_Mod4_TicTacToe.PLAYER.ONE, board.whoWon());
        assertEquals(YK_Mod4_TicTacToe.PLAYER.ONE, board.whoWonFromScratch());
    }

    @Test
    void column0() {
        YK_Mod4_TicTacToe board = new YK_Mod4_TicTacToe(3);

        board.move(new Point(0,0), YK_Mod4_TicTacToe.PLAYER.ONE);
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWon());
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWonFromScratch());

        board.move(new Point(0,2), YK_Mod4_TicTacToe.PLAYER.TWO);
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWon());
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWonFromScratch());


        board.move(new Point(1,0), YK_Mod4_TicTacToe.PLAYER.ONE);
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWon());
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWonFromScratch());

        board.move(new Point(1,2), YK_Mod4_TicTacToe.PLAYER.TWO);
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWon());
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWonFromScratch());


        board.move(new Point(2,0), YK_Mod4_TicTacToe.PLAYER.ONE);
        assertEquals(YK_Mod4_TicTacToe.PLAYER.ONE, board.whoWon());
        assertEquals(YK_Mod4_TicTacToe.PLAYER.ONE, board.whoWonFromScratch());
    }

    @Test
    void diagonal1() {
        YK_Mod4_TicTacToe board = new YK_Mod4_TicTacToe(3);

        board.move(new Point(0,0), YK_Mod4_TicTacToe.PLAYER.ONE);
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWon());
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWonFromScratch());

        board.move(new Point(0,2), YK_Mod4_TicTacToe.PLAYER.TWO);
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWon());
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWonFromScratch());


        board.move(new Point(1,1), YK_Mod4_TicTacToe.PLAYER.ONE);
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWon());
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWonFromScratch());

        board.move(new Point(1,2), YK_Mod4_TicTacToe.PLAYER.TWO);
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWon());
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWonFromScratch());


        board.move(new Point(2,2), YK_Mod4_TicTacToe.PLAYER.ONE);
        assertEquals(YK_Mod4_TicTacToe.PLAYER.ONE, board.whoWon());
        assertEquals(YK_Mod4_TicTacToe.PLAYER.ONE, board.whoWonFromScratch());
    }

    @Test
    void diagonal2() {
        YK_Mod4_TicTacToe board = new YK_Mod4_TicTacToe(3);

        board.move(new Point(2,0), YK_Mod4_TicTacToe.PLAYER.ONE);
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWon());
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWonFromScratch());

        board.move(new Point(0,0), YK_Mod4_TicTacToe.PLAYER.TWO);
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWon());
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWonFromScratch());


        board.move(new Point(1,1), YK_Mod4_TicTacToe.PLAYER.ONE);
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWon());
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWonFromScratch());

        board.move(new Point(2,2), YK_Mod4_TicTacToe.PLAYER.TWO);
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWon());
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWonFromScratch());


        board.move(new Point(0,2), YK_Mod4_TicTacToe.PLAYER.ONE);
        assertEquals(YK_Mod4_TicTacToe.PLAYER.ONE, board.whoWon());
        assertEquals(YK_Mod4_TicTacToe.PLAYER.ONE, board.whoWonFromScratch());
    }

    @Test
    void none() {
        YK_Mod4_TicTacToe board = new YK_Mod4_TicTacToe(3);

        board.move(new Point(0,0), YK_Mod4_TicTacToe.PLAYER.ONE);
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWon());
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWonFromScratch());

        board.move(new Point(0,1), YK_Mod4_TicTacToe.PLAYER.TWO);
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWon());
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWonFromScratch());


        board.move(new Point(0,2), YK_Mod4_TicTacToe.PLAYER.ONE);
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWon());
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWonFromScratch());

        board.move(new Point(1,0), YK_Mod4_TicTacToe.PLAYER.TWO);
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWon());
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWonFromScratch());


        board.move(new Point(1,1), YK_Mod4_TicTacToe.PLAYER.ONE);
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWon());
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWonFromScratch());

        board.move(new Point(2,0), YK_Mod4_TicTacToe.PLAYER.TWO);
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWon());
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWonFromScratch());


        board.move(new Point(1,2), YK_Mod4_TicTacToe.PLAYER.ONE);
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWon());
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWonFromScratch());

        board.move(new Point(2,2), YK_Mod4_TicTacToe.PLAYER.TWO);
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWon());
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWonFromScratch());


        board.move(new Point(2,1), YK_Mod4_TicTacToe.PLAYER.ONE);
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWon());
        assertEquals(YK_Mod4_TicTacToe.PLAYER.NONE, board.whoWonFromScratch());
    }

}
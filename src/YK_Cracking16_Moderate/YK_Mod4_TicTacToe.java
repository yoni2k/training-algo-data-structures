package YK_Cracking16_Moderate;

import YK_Common.YK_Exception;

import java.awt.*;

/*
Source: Cracking 16.4
Implement tick-tac-toe with 2 ways of checking who won if any:
1. If need to calculate decision from scratch
2. If need to give decision asap based on previous calculations
 */

public class YK_Mod4_TicTacToe {

    enum PLAYER {ONE, TWO, NONE}

    private PLAYER[][] board;

    private PLAYER whoWon = PLAYER.NONE;

    private int[] numRowsOne;
    private int[] numRowsTwo;
    private int[] numColOne;
    private int[] numColTwo;
    private int numDiag1PlayerOne = 0;
    private int numDiag1PlayerTwo = 0;
    private int numDiag2PlayerOne = 0;
    private int numDiag2PlayerTwo = 0;

    private PLAYER lastMove = PLAYER.NONE;

    public YK_Mod4_TicTacToe(int n) {
        board = new PLAYER[n][n];

        numRowsOne = new int[n];
        numRowsTwo = new int[n];
        numColOne = new int[n];
        numColTwo = new int[n];

        for (int i = 0; i < n; i++) {
            board[i] = new PLAYER[n];
            for (int j = 0; j < n; j++) {
                board[i][j] = PLAYER.NONE;
            }
        }
    }

    public void move(Point point, PLAYER player) {

        if (player == lastMove) {
            throw new YK_Exception("Wrong player to move, previous: " + lastMove + ", this: " + player);
        }
        lastMove = player;

        if (board[point.x][point.y] != PLAYER.NONE) {
            throw new YK_Exception("Moving to filled place already, [" + point.x + "," + point.y + "], previous value:  " + board[point.x][point.y]);
        }
        board[point.x][point.y] = player;

        if(player == PLAYER.ONE) {
            numColOne[point.x]++;
            numRowsOne[point.y]++;
            if(point.x == point.y) {
                numDiag1PlayerOne++;
            }
            if(point.x == (board.length - 1 - point.y)) {
                numDiag2PlayerOne++;
            }
            if((    (numColOne[point.x] == board.length) ||
                    (numRowsOne[point.y] == board.length) ||
                    (numDiag1PlayerOne == board.length) ||
                    (numDiag2PlayerOne == board.length))
                    && (whoWon == PLAYER.NONE)) {
                whoWon = PLAYER.ONE;
            }
        } else { //player == PLAYER.TWO
            numColTwo[point.x]++;
            numRowsTwo[point.y]++;
            if(point.x == point.y) {
                numDiag1PlayerTwo++;
            }
            if(point.x == (board.length - 1 - point.y)) {
                numDiag2PlayerTwo++;
            }
            if((    (numColTwo[point.x] == board.length) ||
                    (numRowsTwo[point.y] == board.length) ||
                    (numDiag1PlayerTwo == board.length) ||
                    (numDiag2PlayerTwo == board.length))
                    && (whoWon == PLAYER.NONE)) {
                whoWon = PLAYER.TWO;
            }
        }
    }

    public PLAYER whoWon() {
        return whoWon;
    }

    public PLAYER whoWonFromScratch() {
        int numOne;
        int numTwo;
        int i;

        for (i = 0; i < board.length; i++) {
            numOne = 0;
            numTwo = 0;
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == PLAYER.ONE) {
                    numOne++;
                } else if (board[i][j] == PLAYER.TWO) {
                    numTwo++;
                }
                if ((board[i][j] == PLAYER.NONE) || ((numOne > 0) && (numTwo > 0))) {
                    break;
                }
            }
            if (numOne == board.length) {
                return PLAYER.ONE;
            } else if (numTwo == board.length) {
                return PLAYER.TWO;
            }
        }

        for (i = 0; i < board.length; i++) {
            numOne = 0;
            numTwo = 0;
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] == PLAYER.ONE) {
                    numOne++;
                } else if (board[j][i] == PLAYER.TWO) {
                    numTwo++;
                }
                if ((board[j][i] == PLAYER.NONE) || ((numOne > 0) && (numTwo > 0))) {
                    break;
                }
            }
            if (numOne == board.length) {
                return PLAYER.ONE;
            } else if (numTwo == board.length) {
                {
                    return PLAYER.TWO;
                }
            }
        }

        numOne = 0;
        numTwo = 0;

        for (i = 0; i < board.length; i++) {
            if (board[i][i] == PLAYER.ONE) {
                numOne++;
            } else if (board[i][i] == PLAYER.TWO) {
                numTwo++;
            }
            if ((board[i][i] == PLAYER.NONE) || ((numOne > 0) && (numTwo > 0))) {
                break;
            }
        }
        if (numOne == board.length) {
            return PLAYER.ONE;
        } else if (numTwo == board.length) {
            return PLAYER.TWO;
        }

        numOne = 0;
        numTwo = 0;
        for (i = 0; i < board.length; i++) {
            if (board[i][board.length - 1 - i] == PLAYER.ONE) {
                numOne++;
            } else if (board[i][board.length - 1 - i] == PLAYER.TWO) {
                numTwo++;
            }
            if ((board[i][board.length - 1 - i] == PLAYER.NONE) || ((numOne > 0) && (numTwo > 0))) {
                break;
            }
        }
        if (numOne == board.length) {
            return PLAYER.ONE;
        } else if (numTwo == board.length) {
            return PLAYER.TWO;
        }

        return PLAYER.NONE;

    }
}

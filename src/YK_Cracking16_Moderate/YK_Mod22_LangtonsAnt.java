package YK_Cracking16_Moderate;

import YK_Common.YK_Exception;

import java.util.Random;

/*
Source: Cracking 16.22
Read the book for the question
Implemented a simple but not easily extendable solution, and somewhat wasteful on memory
There are a few other options in the book
 */

public class YK_Mod22_LangtonsAnt {

    private boolean[][] getRandomMatrix(int size) {
        Random rand = new Random();

        boolean[][] m = new boolean[size][];

        for(int i = 0; i < size; i++) {
            m[i] = new boolean[size];
        }

        for(int i = 0 ; i < size ; i++) {
            for(int j = 0 ; j < size ; j++) {
                m[i][j] = (rand.nextInt(2) == 1);
            }
        }

        return m;
    }

    private void printMatrix(boolean[][] m) {
        System.out.println("Printing matrix");
        int i;
        for(boolean[] arr : m) {
            StringBuilder sb = new StringBuilder();
            for(boolean b : arr) {
                i = b ? 1 : 0;
                sb.append(i);
            }
            System.out.println(sb.toString());
        }
    }


    private void doMoves(boolean[][] m, int moves, int startIndex) {
        int i = startIndex;
        int j = startIndex;
        int iDir = 0;
        int jDir = 1;
        int newIDir;
        int newJDir;

        for(int move = 0; move < moves; move++) {
            if(m[i][j] == false) { //white
                m[i][j] = true;
                newIDir = jDir;
                newJDir = iDir * (-1);
            } else {
                m[i][j] = false;
                newIDir = jDir * (-1);
                newJDir = iDir;
            }
            iDir = newIDir;
            jDir = newJDir;
            i += iDir;
            j += jDir;

            if ((i < 0) || (j < 0) || (i >= m.length) || (j >= m.length)) {
                throw new YK_Exception("i: " + i + ", j: " + j + ", length: " + m.length);
            }
        }
    }

    public void printKMoves(int k) {
        int startIndex = (((k % 2) == 0) ? k/2 : (k+1)/2);
        int size = startIndex * 2 + 1;

        boolean[][] matrix = getRandomMatrix(size);
        System.out.println("Matrix before moves:");
        printMatrix(matrix);

        doMoves(matrix, k, startIndex);
        System.out.println("Matrix after moves:");
        printMatrix(matrix);
        System.out.println("--------------------------------------");
    }
}

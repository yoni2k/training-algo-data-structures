package YK_Cracking10_SortSearch;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class YK_RankFromStreamTest {

    @Test
    void manyRandoms() {
        final int NUM_NUMBERS = 50;

        int[] numInstances;
        boolean[] appeared;
        YK_RankFromStream ranking;
        Random rand;
        int randNum;

        for(int i = 1; i < 100; i++) { //do 100 times to make sure nothing was special in one time
            ranking = new YK_RankFromStream();
            rand = new Random();
            numInstances = new int[NUM_NUMBERS];
            appeared = new boolean[NUM_NUMBERS];

            for (int j = 0; j < (i * i); j++) {
                randNum = rand.nextInt(NUM_NUMBERS);
                ranking.track(randNum);
                appeared[randNum] = true;

                //System.out.println("i: " + i + ", j: " + j + ", rand: " + randNum);

                for(int k = randNum + 1; k < NUM_NUMBERS; k++) numInstances[k]++;

                assertEquals(numInstances[randNum], ranking.getRankOfNumber(randNum));
            }

            for(int j = 0; j < NUM_NUMBERS; j++) {
                if(appeared[j] == false) {
                    assertEquals(-1, ranking.getRankOfNumber(j));
                }
            }

        }
    }
}
package YK_AmazonPrep;

import java.util.ArrayList;
import java.util.List;

/*
Given states (1 active, 0 not active) of 8 houses, and X number of days passed,
return states after X days such that:
- if states of 2 neighbours were different previous day - active next day
- if states were the same (both active or inactive) - inactive next day
- neighbour to the left of house 0 and to the right of house 7 are as if they are always inactive
 */

public class YK_Sample1_ActiveHouses {
    private final int NUM_HOUSES = 8;

    private int getNewState(int[] oldStates, int h) {
        if (h == 0) {
            return (oldStates[1] == 1) ? 1 : 0;
        } else if (h == 7) {
            return (oldStates[6] == 1) ? 1 : 0;
        } else {
            return (oldStates[h-1] != oldStates[h+1]) ? 1 : 0;
        }

    }

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public List<Integer> cellCompete(int[] states, int days)
    {
        int[] prevStates;
        int[] newStates = states;

        for(int d = 0; d < days; d++) {
            prevStates = newStates;

            newStates = new int[NUM_HOUSES];

            for(int h = 0; h < NUM_HOUSES; h++) {
                newStates[h] = getNewState(prevStates, h);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < NUM_HOUSES; i++) {
            result.add(newStates[i]);
        }

        return result;
    }
}

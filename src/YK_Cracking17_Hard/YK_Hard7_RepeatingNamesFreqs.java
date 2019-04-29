package YK_Cracking17_Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
Source: Cracking 17.7
Given census data of names and their frequencies, and pairs of similar names, create new census data
putting similar names together

Similar to what's in the book
 */

public class YK_Hard7_RepeatingNamesFreqs {

    private class FinalInfo {
        String name;
        int freq;

        FinalInfo(String name, int freq) {
            this.name = name;
            this.freq = freq;
        }
    }

    private class NameInfo {
        int freq;
        ArrayList<String> syns = new ArrayList<>();
        boolean visited = false;

        NameInfo(int freq) {
            this.freq = freq;
        }
    }

    private int getFreq(NameInfo nInfo, HashMap<String, NameInfo> init) {
        NameInfo nInfoSyn;
        int freq = nInfo.freq;

        nInfo.visited = true;

        for(String synName : nInfo.syns) {
            nInfoSyn = init.get(synName);
            if(nInfoSyn.visited == false) {
                freq += getFreq(nInfoSyn, init);
            }
        }

        return freq;
    }

    public String[][] getRealFreq(String[][] namesFreq,  String[][] pairs) {
        HashMap<String, NameInfo> init = new HashMap<>();
        ArrayList<FinalInfo> finalList = new ArrayList<>();
        int newFreq;

        for(String[] nameFreq : namesFreq) {
            init.put(nameFreq[0], new NameInfo(Integer.parseInt(nameFreq[1])));
        }

        for(String[] pair : pairs) {
            init.get(pair[0]).syns.add(pair[1]);
            init.get(pair[1]).syns.add(pair[0]);
        }

        for(Map.Entry<String, NameInfo> ent : init.entrySet()) {
            if(ent.getValue().visited == false) {
                newFreq = getFreq(ent.getValue(), init);
                finalList.add(new FinalInfo(ent.getKey(), newFreq));
            }
        }

        String[][] ans = new String[finalList.size()][];
        FinalInfo singleInfo;
        for(int i = 0; i < finalList.size(); i++) {
            ans[i] = new String[2];
            singleInfo = finalList.get(i);
            ans[i][0] = singleInfo.name;
            ans[i][1] = Integer.toString(singleInfo.freq);
        }
        return ans;
    }
}

package YK_Cracking8_RecDynamicMem;

/*
Cracking 8.11
How many ways are there to change a certain number of cents into 25, 10, 5, 1 cents.

The solution in the book is more generic, but harder to follow.

Included a wrong direction that never worked on big numbers

 */

public class YK_CoinsVars {
/*
    private class CoinVar {

        int num1;
        int num5;
        int num10;
        int num25;

        private CoinVar(int num1, int num5, int num10, int num25) {
            this.num1 = num1;
            this.num5 = num5;
            this.num10 = num10;
            this.num25 = num25;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();

            sb.append("[num1: ");
            sb.append(num1);
            sb.append(", num5: ");
            sb.append(num5);
            sb.append(", num10: ");
            sb.append(num10);
            sb.append(", num25: ");
            sb.append(num25);
            sb.append(']');

            return sb.toString();
        }

    }

    private int recNumCoinsVars(int cents, CoinVar prefix, HashMap<CoinVar, Boolean>[] prefixes) {

        if (cents < 0) return 0;
        if (cents == 0) return 1;

        if (prefixes[cents].containsKey(prefix)) return 0;

        prefixes[cents].put(prefix, true);

        int result = 0;

        result+= recNumCoinsVars(cents - 1,  new CoinVar(prefix.num1 + 1, prefix.num5, prefix.num10, prefix.num25), prefixes);
        result+= recNumCoinsVars(cents - 5,  new CoinVar(prefix.num1, prefix.num5 + 1, prefix.num10, prefix.num25), prefixes);
        result+= recNumCoinsVars(cents - 10, new CoinVar(prefix.num1, prefix.num5, prefix.num10 + 1, prefix.num25), prefixes);
        result+= recNumCoinsVars(cents - 25, new CoinVar(prefix.num1, prefix.num5, prefix.num10, prefix.num25 + 1), prefixes);

        return result;
    }

    private String prefixesToString(HashMap<CoinVar, Boolean>[] prefixes) {
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i < prefixes.length;  i++) {
            sb.append(i);
            sb.append(": ");
            for(CoinVar prefix : prefixes[i].keySet()) {
                sb.append(prefix);
                sb.append(", ");
            }
            sb.append("\n");

        }

        return sb.toString();
    }

    private int recNumCoinsVarsDebug(int cents, CoinVar prefix, HashMap<CoinVar, Boolean>[] prefixes) {

        if (cents < 0) {System.out.println("Short - Negative cents: " + cents + ", returning 0");return 0;}
        if (cents == 0) {System.out.println("Short - Cents = 0, returning 1, prefix: " + prefix);return 1;}

        System.out.println("Start - Cents: " + cents + ", putting prefix: " + prefix);
        System.out.println("Start - Prefixes: ");
        System.out.print(prefixesToString(prefixes));

        if (prefixes[cents].containsKey(prefix)) {System.out.println("Short - Returning 0, cents: " + cents + ", contains prefix: " + prefix); return 0;}

        System.out.println("Middle - Cents: " + cents + ", putting prefix: " + prefix);

        prefixes[cents].put(prefix, true);

        int result = 0;

        result+= recNumCoinsVarsDebug(cents - 1,  new CoinVar(prefix.num1 + 1, prefix.num5, prefix.num10, prefix.num25), prefixes);
        result+= recNumCoinsVarsDebug(cents - 5,  new CoinVar(prefix.num1, prefix.num5 + 1, prefix.num10, prefix.num25), prefixes);
        result+= recNumCoinsVarsDebug(cents - 10, new CoinVar(prefix.num1, prefix.num5, prefix.num10 + 1, prefix.num25), prefixes);
        result+= recNumCoinsVarsDebug(cents - 25, new CoinVar(prefix.num1, prefix.num5, prefix.num10, prefix.num25 + 1), prefixes);

        System.out.println("End - for cents: " + cents + ", for prefix: " + prefix + ", result: " + result);
        System.out.println("End - Prefixes: ");
        System.out.print(prefixesToString(prefixes));
        return result;
    }

    public int numCoinsVars(int cents) {

        HashMap<CoinVar, Boolean>[] prefixes = new HashMap[cents + 1];//+1 to use native human indexes

        for(int i = 1; i <= cents; i++) {
            prefixes[i] = new HashMap<>();
        }

        return recNumCoinsVarsDebug(cents, new CoinVar(0,0,0,0), prefixes);
    }
*/
    private int num5(int cents, int[] cache5) {
        int i = 0;

        if(cache5[cents] != 0) return cache5[cents];

        while (i * 5 <= cents) i++;

        cache5[cents] = i;
        return i;
    }

    private int num10(int cents, int[] cache10) {
        int i = 0;
        int res = 0;

        int[] cache5 = new int[cents + 1];

        if(cache10[cents] != 0) return cache10[cents];

        while (i * 10 <= cents) {
            res += num5(cents - (i * 10), cache5);
            i++;
        }

        cache10[cents] = res;
        return res;
    }

    public int numCoinsVariations(int cents) {

        int i = 0;
        int res = 0;
        int[] cache10 = new int[cents + 1];

        while (i * 25 <= cents) {
            res += num10(cents - (i * 25), cache10);
            i++;
        }

        return res;
    }
}

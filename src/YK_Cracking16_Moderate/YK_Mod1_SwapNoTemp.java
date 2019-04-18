package YK_Cracking16_Moderate;

public class YK_Mod1_SwapNoTemp {
    public int[] swapPlusMinus(int one, int two) {
        one -= two;
        two += one;
        one = two - one;
        return new int[] {one, two};
    }

    public int[] swapXor(int one, int two) {
        one ^= two;
        two ^= one;
        one ^= two;
        return new int[] {one, two};
    }
}

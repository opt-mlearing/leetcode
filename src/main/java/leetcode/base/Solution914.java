package leetcode.base;

/**
 * 914. 卡牌分组
 * https://leetcode.cn/problems/x-of-a-kind-in-a-deck-of-cards/
 */
public class Solution914 {

    public boolean hasGroupsSizeX(int[] deck) {
        int[] count = new int[10001];
        int size = deck.length;
        for (int i = 0; i < size; ++i) {
            count[deck[i]]++;
        }
        int x = -1;
        for (int i = 0; i <= 10000; ++i) {
            if (count[i] > 0) {
                if (x == -1) {
                    x = count[i];
                } else {
                    x = gcd(x, count[i]);
                }
            }
        }
        return x >= 2;
    }

    private int gcd(int m, int n) {
        return m == 0 ? n : gcd(n % m, m);
    }

}

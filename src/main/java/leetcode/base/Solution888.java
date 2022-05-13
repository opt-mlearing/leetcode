package leetcode.base;

import java.util.HashSet;
import java.util.Set;

/**
 * 888. 公平的糖果交换
 * https://leetcode.cn/problems/fair-candy-swap/
 */
public class Solution888 {

    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sumA = 0;
        Set<Integer> set = new HashSet<Integer>();
        for (int alice : aliceSizes) {
            sumA += alice;
            set.add(alice);
        }
        int sumB = 0;
        for (int bob : bobSizes) {
            sumB += bob;
        }
        // delta 可正可负
        int delta = (sumA - sumB) / 2;
        if (delta != 0) {
            for (int bob : bobSizes) {
                int ali = bob + delta;
                if (set.contains(ali)) {
                    return new int[]{ali, bob};
                }
            }
        }
        return new int[]{-1, 1};
    }

}

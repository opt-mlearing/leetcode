package leetcode.base;

import java.util.HashSet;
import java.util.Set;

/**
 * 672. 灯泡开关 Ⅱ
 * https://leetcode.cn/problems/bulb-switcher-ii/
 */
public class Solution672 {

    public int flipLights(int n, int m) {
        Set<Integer> seen = new HashSet();
        n = Math.min(n, 6);
        int shift = Math.max(0, 6 - n);
        for (int cand = 0; cand < 16; ++cand) {
            int bcount = Integer.bitCount(cand);
            if (bcount % 2 == m % 2 && bcount <= m) {
                int lights = 0;
                if (((cand >> 0) & 1) > 0) {
                    lights ^= (0b111111 >> shift);
                }
                if (((cand >> 1) & 1) > 0) {
                    lights ^= (0b010101 >> shift);
                }
                if (((cand >> 2) & 1) > 0) {
                    lights ^= (0b101010 >> shift);
                }
                if (((cand >> 3) & 1) > 0) {
                    lights ^= (0b100100 >> shift);
                }
                seen.add(lights);
            }
        }
        return seen.size();
    }

}

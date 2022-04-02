package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 二进制表示中质数个计算置位
 * https://leetcode-cn.com/problems/prime-number-of-set-bits-in-binary-representation/
 */
public class Solution762 {

    private Set<Integer> primeSet = new HashSet<Integer>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19));

    public int countPrimeSetBits(int left, int right) {
        int res = 0;
        for (int i = left; i <= right; ++i) {
            int count = Integer.bitCount(i);
            if (primeSet.contains(count)) {
                res++;
            }
        }
        return res;
    }

}

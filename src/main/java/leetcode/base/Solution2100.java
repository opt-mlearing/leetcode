package leetcode.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 适合打劫银行的日子
 *
 * @Link https://leetcode-cn.com/problems/find-good-days-to-rob-the-bank
 * <p></p>
 * 动态规划
 */
public class Solution2100 {

    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int size = security.length;
        // 其中必然left[0]= 0.
        int[] left = new int[size];
        Arrays.fill(left, 0);
        // 必然right[size- 1]= 0.
        int[] right = new int[size];
        Arrays.fill(right, 0);
        for (int i = 1; i < size; ++i) {
            if (security[i] <= security[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
            if (security[size - i - 1] <= security[size - i]) {
                right[size - i - 1] = right[size - i] + 1;
            }
        }
        List<Integer> result = new ArrayList<Integer>();
        for (int i = time; i < size - time; ++i) {
            if (left[i] >= time && right[i] >= time) {
                result.add(i);
            }
        }
        return result;
    }

}

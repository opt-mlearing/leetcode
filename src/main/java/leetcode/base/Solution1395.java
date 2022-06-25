package leetcode.base;

/**
 * 1395. 统计作战单位数
 * https://leetcode.cn/problems/count-number-of-teams/
 *
 * @author: caogl
 * @date: 2022/6/26, 1:27
 **/
public class Solution1395 {

    public int numTeams(int[] rating) {
        int size = rating.length;
        int res = 0;
        for (int i = 0; i < size - 2; ++i) {
            for (int j = i + 1; j < size - 1; ++j) {
                for (int k = j + 1; k < size; ++k) {
                    if ((rating[i] > rating[j] && rating[j] > rating[k]) ||
                            (rating[i] < rating[j] && rating[j] < rating[k])) {
                        res++;
                    }
                }
            }
        }
        return res;
    }

}

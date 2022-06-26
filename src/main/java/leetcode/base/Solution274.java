package leetcode.base;

import java.util.Arrays;

/**
 * 274. H 指数
 * https://leetcode.cn/problems/h-index/
 *
 * @author: caogl
 * @date: 2022/6/26, 18:57
 **/
public class Solution274 {

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int size = citations.length;
        int right = size - 1;
        int res = 0;
        while (right >= 0 && citations[right] > res) {
            right--;
            res++;
        }
        return res;
    }

}

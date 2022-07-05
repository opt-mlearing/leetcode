package leetcode.base;

import java.util.Arrays;

/**
 * 455. 分发饼干
 * https://leetcode.cn/problems/assign-cookies/
 *
 * @author: caogl
 * @date: 2022/7/6, 3:32
 **/
public class Solution455 {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int size = g.length;
        int j = s.length - 1;
        int res = 0;
        for (int i = size - 1; i >= 0; --i) {
            if (j >= 0 && s[j] >= g[i]) {
                j--;
                res++;
            }
        }
        return res;
    }

}

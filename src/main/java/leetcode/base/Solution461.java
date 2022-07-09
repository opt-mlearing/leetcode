package leetcode.base;

/**
 * 461. 汉明距离
 * https://leetcode.cn/problems/hamming-distance/
 *
 * @author: caogl
 * @date: 2022/7/10, 1:39
 **/
public class Solution461 {

    public int hammingDistance(int x, int y) {
        int s = x ^ y;
        int res = 0;
        while (s > 0) {
            res += s & 1;
            s = s >> 1;
        }
        return res;
    }

}

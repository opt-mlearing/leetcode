package leetcode.offer;

/**
 * 剑指 Offer 62. 圆圈中最后剩下的数字
 * https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
 */
public class SolutionOffer_62 {

    // 优化，反向思维.
    public int lastRemaining(int n, int m) {
        if (n == 1) {
            return 0;
        }
        int res = 0;
        for (int i = 2; ; ++i) {
            res = (res + m) % i;
            if (i == n) {
                break;
            }
        }
        return res;
    }

    // 递归.
    public int lastRemaining_1(int n, int m) {
        if (n == 1) {
            return 0;
        }
        return (lastRemaining(n - 1, m) + m) % n;
    }

}

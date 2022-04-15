package leetcode.base;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 372. 超级次方
 * https://leetcode-cn.com/problems/super-pow/
 * 蛮不错的题解
 * https://leetcode-cn.com/problems/powx-n/solution/java-kuai-su-mi-si-lu-qing-xi-dai-ma-jia-60hk/
 */
public class Solution372 {

    private static final int MOD = 1337;

    public int superPow(int a, int[] b) {
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int item : b) {
            stack.push(item);
        }
        return doSuperPow(a, stack) % MOD;
    }

    // 幂指数规模的分解.
    private int doSuperPow(int a, Deque<Integer> stack) {
        if (stack.isEmpty()) {
            return 1;
        }
        int post = stack.pop();
        int n1 = fastPow(a, post);
        int n2 = fastPow(doSuperPow(a, stack), 10);
        return (n1 % MOD) * (n2 % MOD) % MOD;
    }

    // 快乘.
    private int fastPow(int a, int b) {
        if (b == 0) {
            return 1;
        } else if (b == 1) {
            return a;
        }
        if (b % 2 == 0) {
            return fastPow(((a % MOD) * (a % MOD)) % MOD, b / 2);
        } else {
            return ((a % MOD) * (fastPow(a, b - 1) % MOD)) % MOD;
        }
    }

}

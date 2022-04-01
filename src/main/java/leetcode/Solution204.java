package leetcode;

import java.util.Arrays;

/**
 * 计数质数
 * https://leetcode-cn.com/problems/count-primes/
 */
public class Solution204 {

    // 埃式筛.
    public int countPrimes(int n) {
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        int count = 0;
        // 0 和 1就直接跳过了.
        for (int i = 2; i < n; ++i) {
            if (isPrime[i] == 1) {
                count += isPrime[i];
                // i* i 可能会int越界，需要转成 long.
                if ((long) i * i >= n) {
                    continue;
                }
                // i是质数，那么i*i 就一定不是质数， 然后 i*(i+ 1) ...
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = 0;
                }
            }
        }
        return count;
    }

    // 贪心, 由于超时不能验证通过.
    public int countPrimes_greed(int n) {
        if (n == 0 || n == 1) {
            return 0;
        }
        int count = 0;
        for (int i = 2; i < n; ++i) {
            count += isPrime(i) ? 1 : 0;
        }
        return count;
    }

    // 1 && target 除外.
    // 故此，2～target-1 不存第二个可以整除的.
    private boolean isPrime(int target) {
        for (int i = 2; i * i < target; ++i) {
            if (target % i == 0) {
                return false;
            }
        }
        return true;
    }

}

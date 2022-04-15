package leetcode.base;

import java.util.Arrays;

/**
 * 质数排列
 * https://leetcode-cn.com/problems/prime-arrangements/
 */
public class Solution1175 {

    // 为什么是1000000007?
    // 1000000007 是最小的十位质数。模1000000007，可以保证值永远在int的范围内.
    private static long N = (long) 1e9 + 7;

    public int numPrimeArrangements(int n) {
        int primeSize = primeCount(n + 1);
        long res = 1;
        for (int i = 1; i <= primeSize; ++i) {
            res = (res % N) * i;
        }
        for (int i = 1; i <= n - primeSize; ++i) {
            res = (res % N) * i;
        }
        return (int) (res % N);
    }

    // 计算小于等于n中,质数的个数.
    private int primeCount(int n) {
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        int res = 0;
        for (int i = 2; i < n; ++i) {
            if (isPrime[i] == 1) {
                ++res;
            }
            if ((long) i * i >= n) {
                continue;
            }
            for (int j = i * i; j < n; j += i) {
                isPrime[j] = 0;
            }
        }
        return res;
    }

}

package leetcode;

/**
 * 50. Pow(x, n)
 * https://leetcode-cn.com/problems/powx-n/
 */
public class Solution50 {

    public double myPow(double x, int n) {
        return n >= 0 ? doMyPow(x, n) : 1 / doMyPow(x, n);
    }

    private double doMyPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        // if(n== 1){
        //     return x;
        // }
        double tmp = doMyPow(x, n / 2);
        return n % 2 == 0 ? tmp * tmp : x * tmp * tmp;
    }

}

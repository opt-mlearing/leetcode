package leetcode.base;

/**
 * 1186. 删除一次得到子数组最大和
 * https://leetcode-cn.com/problems/maximum-subarray-sum-with-one-deletion/
 */
public class Solution1186 {

    public int maximumSum_1(int[] arr) {
        int n = arr.length;
        // deleDp[i]表示以数组中第i个数，即以arr[i - 1]结尾的连续子数组删除一个元素后的最大值和
        int[] deleDp = new int[n + 1];
        // dp[i]表示以数组中第i个数，即以arr[i - 1]结尾的连续子数组没有执行删除操作的最大和
        int[] dp = new int[n + 1];
        // 最开始deleDp[0]和dp[0]都为0，deleDp[1]表示删除一位后的最大值，所以也为0；
        deleDp[0] = dp[0] = deleDp[1] = 0;
        dp[1] = arr[0];
        int res = arr[0];
        for (int i = 2; i <= n; i++) {
            // dp[i]表示未删除情况下以arr[i - 1]结尾的最大和，所以dp[i]要么等于dp[i - 1]加上第i个元素，要么就等于第i个元素
            dp[i] = Math.max(dp[i - 1] + arr[i - 1], arr[i - 1]);
            // deleDp[i]表示删除一个元素情况下以arr[i - 1]结尾的最大和，
            // 所以deleDp[i]要么等于deleDp[i - 1]加上第i个元素
            //（表示前面已经删除国一个元素，所以第i个元素不能删除），要么就等于dp[i - 1]（表示删除第i个元素）
            deleDp[i] = Math.max(deleDp[i - 1] + arr[i - 1], dp[i - 1]);
            //最后取最大值
            res = Math.max(res, Math.max(dp[i], deleDp[i]));
        }
        return res;
    }

    public int maximumSum_2(int[] arr) {
        int size = arr.length;
        int[][] dp = new int[size + 1][2];
        // dp[i][0]表示到第i个元素结束未删除元素的最大和
        // dp[i][1]表示到第i个元素结束删除一个元素的最大和.
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[1][0] = arr[0];
        dp[1][1] = 0;
        // 因为至少有一个元素，所以出初始化的时候，res= Math.max(dp[1][0], dp[1][1]) 是错误的.
        int res = dp[1][0];
        for (int i = 2; i <= size; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0] + arr[i - 1], arr[i - 1]);
            dp[i][1] = Math.max(dp[i - 1][1] + arr[i - 1], dp[i - 1][0]);
            res = Math.max(res, Math.max(dp[i][0], dp[i][1]));
        }
        return res;
    }

    // 这个是通用的，可支持k次.
    public int maximumSum(int[] arr) {
        int size = arr.length;
        // 这里k== 1.
        int k = 1;
        int[][] dp = new int[size + 1][k + 1];
        // dp[i][0]表示到第i个元素结束未删除元素的最大和
        // dp[i][1]表示到第i个元素结束删除一个元素的最大和.
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[1][0] = arr[0];
        // 因为至少有一个元素，所以出初始化的时候，res= Math.max(dp[1][0], dp[1][1]) 是错误的.
        int res = dp[1][0];
        for (int i = 2; i <= size; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0] + arr[i - 1], arr[i - 1]);
            for (int j = 1; j <= k; ++j) {
                dp[i][j] = Math.max(dp[i - 1][j] + arr[i - 1], dp[i - 1][j - 1]);
            }
            res = Math.max(res, Math.max(dp[i][0], dp[i][1]));
        }
        return res;
    }

}

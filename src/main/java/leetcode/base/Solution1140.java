package leetcode.base;

import java.util.HashMap;
import java.util.Map;

/**
 * 1140. 石子游戏 II
 * https://leetcode.cn/problems/stone-game-ii/
 */
public class Solution1140 {

    private Map<Integer, Map<Integer, Integer>> record;
    private int[] preSum;

    // dfs && 记忆化搜索.
    public int stoneGameII_dfs(int[] piles) {
        int size = piles.length;
        preSum = new int[size + 1];
        record = new HashMap<Integer, Map<Integer, Integer>>();
        for (int i = 0; i < size; ++i) {
            record.put(i, new HashMap<Integer, Integer>());
            preSum[i + 1] = preSum[i] + piles[i];
        }
        return dfs(piles, size, 0, 1);
    }

    private int dfs(int[] piles, int size, int start, int m) {
        if (start >= size) {
            return 0;
        }
        if (record.get(start).getOrDefault(m, -1) != -1) {
            return record.get(start).get(m);
        }
        int maxStone = 0;
        for (int x = 1; x <= 2 * m; ++x) {
            int nextM = Math.max(m, x);
            int nextMaxStore = dfs(piles, size, start + x, nextM);
            maxStone = Math.max(maxStone, preSum[size] - preSum[start] - nextMaxStore);
        }
        record.get(start).put(m, maxStone);
        return maxStone;
    }

    // dp
    public int stoneGameII_dp1(int[] piles) {
        int size= piles.length;
        //dp[i][j] 表示从 piles[i: size- 1]取j个先手最大.
        int[][] dp= new int[size][size+ 1];
        int sum= 0;
        for(int i= size- 1; i>= 0; --i){
            sum+= piles[i];
            // 特殊值，当i== 1的时候，m最小取1.
            for(int m= 1; m<= i|| m== 1; ++m){
                if(i+ 2* m>= size){
                    dp[i][m]= sum;
                }else {
                    for(int x= 1; x<= 2* m; ++x){
                        dp[i][m]= Math.max(dp[i][m], sum- dp[i+ x][Math.max(m, x)]);
                    }
                }
            }
        }
        return dp[0][1];
    }

    public int stoneGameII_dp2(int[] piles) {
        int size= piles.length;
        int[][] dp= new int[size][size+ 1];
        int sum= 0;
        for(int i= size; i>= 1; --i){
            sum+= piles[i- 1];
            // i== 0 时 m= 1, 改进下i的最小值.
            for(int m= 1; m<= i; ++m){
                if(i- 1+ 2* m>= size){
                    dp[i- 1][m]= sum;
                }else{
                    for(int x= 1; x<= 2* m; ++x){
                        dp[i- 1][m]= Math.max(dp[i- 1][m], sum- dp[i- 1+ x][Math.max(x, m)]);
                    }
                }
            }
        }
        return dp[0][1];
    }

}

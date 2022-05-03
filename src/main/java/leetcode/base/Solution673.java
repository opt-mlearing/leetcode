package leetcode.base;

import java.util.Arrays;

public class Solution673 {

    public int findNumberOfLIS(int[] nums) {
        if(nums== null || nums.length== 0){
            return 0;
        }
        // nums[j]< nums[i] --> dp[i]= max(dp[i], dp[j]+ 1)
        int[] dp= new int[nums.length];
        // 这个很重要，每个元素递增至少为1，就是nums[i]中那个数.
        Arrays.fill(dp, 1);
        int res= 1;
        for(int i= 1; i< nums.length; ++i){
            for(int j= 0; j< i; ++j){
                if(nums[j]< nums[i]){
                    dp[i]= Math.max(dp[j]+ 1, dp[i]);
                }
                res= Math.max(res, dp[i]);
            }
        }
        String[] tmp= new String[dp.length];
        for (int i= 0; i< dp.length; ++i){
            tmp[i]= String.valueOf(dp[i]);
        }
        System.out.println(String.join(",", tmp));
        return res;
    }

}

package leetcode.offer;

/**
 * 剑指 Offer 63. 股票的最大利润
 * https://leetcode.cn/problems/gu-piao-de-zui-da-li-run-lcof/
 *
 * @author: caogl
 * @date: 2022/6/13, 23:25
 **/
public class SolutionOffer_63 {

    public int maxProfit(int[] prices) {
        int size = prices.length;
        if (size <= 1) {
            return 0;
        }
        int res = 0;
        int preMin = Integer.MAX_VALUE;
        for (int i = 1; i < size; ++i) {
            preMin = Math.min(preMin, prices[i - 1]);
            res = Math.max(res, prices[i] - preMin);
        }
        return res;
    }

}

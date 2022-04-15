package leetcode.base;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 商品折扣后的最终价格
 * https://leetcode-cn.com/problems/final-prices-with-a-special-discount-in-a-shop/
 */
public class Solution1475 {

    public int[] finalPrices(int[] prices) {
        int size = prices.length;
        int[] res = new int[size];
        System.arraycopy(prices, 0, res, 0, size);
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < size; ++i) {
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                int tmp = stack.pop();
                res[tmp] = prices[tmp] - prices[i];
            }
            stack.push(i);
        }
        return res;
    }

}

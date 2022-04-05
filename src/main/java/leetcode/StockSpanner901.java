package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 股票价格跨度
 * https://leetcode-cn.com/problems/online-stock-span/
 */
public class StockSpanner901 {

    private Deque<Integer> prices;
    private Deque<Integer> days;

    public StockSpanner901() {
        prices = new LinkedList<Integer>();
        days = new LinkedList<Integer>();
    }

    public int next(int price) {
        int day = 1;
        while (!prices.isEmpty() && prices.peek() <= price) {
            prices.pop();
            day += days.pop();
        }
        prices.push(price);
        days.push(day);
        return day;
    }

}

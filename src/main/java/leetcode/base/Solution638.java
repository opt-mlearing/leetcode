package leetcode.base;

import java.util.ArrayList;
import java.util.List;

/**
 * 638. 大礼包
 * https://leetcode.cn/problems/shopping-offers/
 *
 * @author: caogl
 * @date: 2022/7/20, 2:34
 **/
public class Solution638 {

    // 回溯.
    // 2ms/ 41mb.
    // 不需要校验special大礼包一定比单独买便宜.
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return backTracking(price, special, needs, 0);
    }

    private int backTracking(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int index) {
        if (index == special.size()) {
            return originPriceWithRemain(needs, price);
        }
        List<Integer> tmp = new ArrayList<>();
        boolean flag = true;
        for (int i = 0; i < special.get(index).size() - 1; i++) {
            int diff = needs.get(i) - special.get(index).get(i);
            if (diff < 0) {
                flag = false;
                break;
            } else {
                tmp.add(diff);
            }
        }
        if (flag) {
            return Math.min(special.get(index).get(special.get(index).size() - 1)
                            + backTracking(price, special, tmp, index),
                    backTracking(price, special, needs, index + 1));
        } else {
            return backTracking(price, special, needs, index + 1);
        }
    }

    private int originPriceWithRemain(List<Integer> needs, List<Integer> price) {
        int sum = 0;
        for (int i = 0; i < needs.size(); i++) {
            sum += needs.get(i) * price.get(i);
        }
        return sum;
    }

}

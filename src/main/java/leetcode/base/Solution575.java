package leetcode.base;

import java.util.HashSet;
import java.util.Set;

/**
 * 575. 分糖果
 * https://leetcode.cn/problems/distribute-candies/
 *
 * @author: caogl
 * @date: 2022/7/24, 16:00
 **/
public class Solution575 {

    public int distributeCandies(int[] candyType) {
        int size = candyType.length;
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < size; ++i) {
            set.add(candyType[i]);
        }
        return Math.min(set.size(), size / 2);
    }

}

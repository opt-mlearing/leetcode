package leetcode.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 398. 随机数索引
 * https://leetcode.cn/problems/random-pick-index/
 *
 * @author: caogl
 * @date: 2022/6/18, 10:45
 **/
public class Solution398 {

    private Random random;
    private Map<Integer, List<Integer>> map;

    public Solution398(int[] nums) {
        random = new Random(1234L);
        map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            List<Integer> orDefault = map.getOrDefault(nums[i], new ArrayList<Integer>());
            orDefault.add(i);
            map.put(nums[i], orDefault);
        }
    }

    public int pick(int target) {
        List<Integer> list = map.get(target);
        if (list != null) {
            int size = list.size();
            return list.get(random.nextInt(size));
        }
        return Integer.MIN_VALUE;
    }

}

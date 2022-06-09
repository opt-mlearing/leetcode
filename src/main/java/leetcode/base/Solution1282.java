package leetcode.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1282. 用户分组
 * https://leetcode.cn/problems/group-the-people-given-the-group-size-they-belong-to/
 */
public class Solution1282 {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        int size = groupSizes.length;
        for (int i = 0; i < size; ++i) {
            int key = groupSizes[i];
            List<Integer> list = map.getOrDefault(key, new ArrayList<Integer>());
            list.add(i);
            if (list.size() == key) {
                res.add(new ArrayList<Integer>(list));
                list.clear();
            }
            map.put(key, list);
        }
        return res;
    }

}

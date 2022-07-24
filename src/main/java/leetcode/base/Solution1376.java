package leetcode.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1376. 通知所有员工所需的时间
 * https://leetcode.cn/problems/time-needed-to-inform-all-employees/
 *
 * @author: caogl
 * @date: 2022/7/24, 15:03
 **/
public class Solution1376 {

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < n; ++i) {
            map.put(i, new ArrayList<Integer>());
        }
        for (int i = 0; i < manager.length; ++i) {
            List<Integer> list = map.get(manager[i]);
            if (list != null) {
                list.add(i);
                map.put(manager[i], list);
            }
        }
        return dfs(map, headID, informTime);
    }

    private int dfs(Map<Integer, List<Integer>> map, int headID, int[] informTime) {
        int res = informTime[headID];
        List<Integer> list = map.get(headID);
        if (list.isEmpty()) {
            return res;
        }
        int tmp = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); ++i) {
            tmp = Math.max(tmp, dfs(map, list.get(i), informTime));
        }
        res += tmp;
        return res;
    }

}

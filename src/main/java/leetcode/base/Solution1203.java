package leetcode.base;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;

/**
 * 1203. 项目管理
 * https://leetcode-cn.com/problems/sort-items-by-groups-respecting-dependencies/
 */
public class Solution1203 {

    // 拓扑排序，存在两级，组的拓扑排序 优先于 项目的拓扑排序.
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        // 预处理group数据. 由于部分项目无分组信息，进行补全.
        for (int i = 0; i < n; ++i) {
            if (group[i] == -1) {
                group[i] = m++;
            }
        }
        // 组入度表 & 组邻接矩阵.
        int[] groupInDegree = new int[m];
        List<Integer>[] groupAdjacent = new ArrayList[m];
        for (int i = 0; i < m; ++i) {
            groupAdjacent[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < n; ++i) {
            int currentGroup = group[i];
            for (int beforeItem : beforeItems.get(i)) {
                int beforeGroup = group[beforeItem];
                if (currentGroup != beforeGroup) {
                    groupInDegree[currentGroup]++;
                    groupAdjacent[beforeGroup].add(currentGroup);
                }
            }
        }
        // 项目入度表 & 项目邻接矩阵.
        int[] itemInDegree = new int[n];
        List<Integer>[] itemAdjacent = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            itemAdjacent[i] = new ArrayList<Integer>();
        }
        for (int currentItem = 0; currentItem < n; ++currentItem) {
            for (int beforeItem : beforeItems.get(currentItem)) {
                itemInDegree[currentItem]++;
                itemAdjacent[beforeItem].add(currentItem);
            }
        }
        // 对组进行拓扑排序.
        List<Integer> groupSort = topologicalSorting(m, groupAdjacent, groupInDegree);
        if (groupSort.size() == 0) {
            return new int[0];
        }
        // 对项目进行拓扑排序.
        List<Integer> itemSort = topologicalSorting(n, itemAdjacent, itemInDegree);
        if (itemSort.size() == 0) {
            return new int[0];
        }
        // 先按照项目的拓扑序按照组聚合.
        Map<Integer, List<Integer>> groupByGroupWithItemSort = new HashMap<Integer, List<Integer>>();
        for (int item : itemSort) {
            groupByGroupWithItemSort.computeIfAbsent(group[item], integer -> new ArrayList<Integer>()).add(item);
        }
        // 然后再按照组的拓扑序填充项目.
        List<Integer> res = new ArrayList<Integer>();
        for (int groupIndex : groupSort) {
            res.addAll(groupByGroupWithItemSort.getOrDefault(groupIndex, new ArrayList<Integer>()));
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    // 拓扑排序
    private List<Integer> topologicalSorting(int n, List<Integer>[] adjacent, int[] inDegree) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < n; ++i) {
            if (inDegree[i] == 0) {
                deque.offer(i);
            }
        }
        while (!deque.isEmpty()) {
            int tmp = deque.poll();
            res.add(tmp);
            for (int item : adjacent[tmp]) {
                if (--inDegree[item] == 0) {
                    deque.offer(item);
                }
            }
        }
        return res.size() == n ? res : new ArrayList<Integer>();
    }

}

package leetcode.base;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 1462. 课程表 IV
 * https://leetcode-cn.com/problems/course-schedule-iv/submissions/
 */
public class Solution1462 {

    private Set<Integer>[] preSet;

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        // 临接矩阵.
        List<Integer>[] adjacent = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            adjacent[i] = new ArrayList<Integer>();
        }
        // 初始化入度表&邻接矩阵.
        for (int i = 0; i < prerequisites.length; ++i) {
            int pre = prerequisites[i][0];
            int post = prerequisites[i][1];
            // 注意，这里一定要反过来.
            adjacent[post].add(pre);
        }
        // 从每一个顶点出发，遍历访问
        preSet = new HashSet[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            preSet[i] = new HashSet<Integer>();
        }
        boolean[] isVisit = new boolean[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            dfs(i, isVisit, adjacent);
        }
        List<Boolean> res = new ArrayList<Boolean>();
        for (int i = 0; i < queries.length; ++i) {
            res.add(preSet[queries[i][1]].contains(queries[i][0]));
        }
        return res;
    }

    // 这里的adjacent是反转的
    private void dfs(int vertex, boolean[] isVisit, List<Integer>[] adjacent) {
        if (isVisit[vertex]) {
            return;
        }
        isVisit[vertex] = true;
        for (int item : adjacent[vertex]) {
            dfs(item, isVisit, adjacent);
            preSet[vertex].add(item);
            preSet[vertex].addAll(preSet[item]);
        }
    }

}
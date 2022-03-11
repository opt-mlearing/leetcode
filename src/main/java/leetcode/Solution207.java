package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 课程表
 *
 * @link https://leetcode-cn.com/problems/course-schedule/
 * 判断是否存在一种拓扑排序.
 */
public class Solution207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i) {
            graph.add(new ArrayList<Integer>());
        }
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; ++i) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            ++inDegree[prerequisites[i][0]];
        }
        // 找到入度为0的课程
        Deque<Integer> deque = new ArrayDeque<Integer>();
        for (int i = 0; i < numCourses; ++i) {
            if (inDegree[i] == 0) {
                deque.offer(i);
            }
        }
        int value = 0;
        while (!deque.isEmpty()) {
            int course = deque.poll();
            ++value;
            for (int i = 0; i < graph.get(course).size(); ++i) {
                --inDegree[graph.get(course).get(i)];
                if (inDegree[graph.get(course).get(i)] == 0) {
                    deque.offer(graph.get(course).get(i));
                }
            }
        }
        return value == numCourses;
    }

}

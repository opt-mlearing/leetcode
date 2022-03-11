package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 课程表II
 *
 * @Link https://leetcode-cn.com/problems/course-schedule-ii/
 */
public class Solution210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 入度
        int[] inDegree = new int[numCourses];
        // 相邻的边
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < prerequisites.length; ++i) {
            ++inDegree[prerequisites[i][0]];
            edges.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        Deque<Integer> deque = new ArrayDeque<Integer>();
        for (int i = 0; i < numCourses; ++i) {
            if (inDegree[i] == 0) {
                deque.offer(i);
            }
        }
        int count = 0;
        int[] result = new int[numCourses];
        while (!deque.isEmpty()) {
            int courseIndex = deque.pop();
            result[count] = courseIndex;
            ++count;
            for (int j = 0; j < edges.get(courseIndex).size(); ++j) {
                int newIndex = edges.get(courseIndex).get(j);
                --inDegree[newIndex];
                if (inDegree[newIndex] == 0) {
                    deque.offer(newIndex);
                }
            }
        }
        return count == numCourses ? result : new int[0];
    }

}

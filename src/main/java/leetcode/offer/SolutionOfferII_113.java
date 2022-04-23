package leetcode.offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer II 113. 课程顺序
 * https://leetcode-cn.com/problems/QA2IGt/
 */
public class SolutionOfferII_113 {

    // 拓扑排序
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i) {
            graph.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < prerequisites.length; ++i) {
            int[] prerequisity = prerequisites[i];
            graph.get(prerequisity[1]).add(prerequisity[0]);
            inDegree[prerequisity[0]]++;
        }
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; ++i) {
            if (inDegree[i] == 0) {
                deque.offer(i);
            }
        }
        List<Integer> list = new ArrayList<Integer>();
        while (!deque.isEmpty()) {
            int index = deque.poll();
            list.add(index);
            for (int vertex : graph.get(index)) {
                if (--inDegree[vertex] == 0) {
                    deque.offer(vertex);
                }
            }
        }
        // 并不所有的case都能支持正好学完.
        for (int i = 0; i < numCourses; ++i) {
            if (inDegree[i] != 0) {
                return new int[0];
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            res[i] = list.get(i);
        }
        return res;
    }

}

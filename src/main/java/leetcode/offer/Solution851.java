package leetcode.offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 851. 喧闹和富有
 * https://leetcode-cn.com/problems/loud-and-rich/
 */
public class Solution851 {

    // 注意：题目中已经明确逻辑自洽，所以不存在环.
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        // 一共n个人.
        int n = quiet.length;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            graph.add(new ArrayList<Integer>());
        }
        int[] inDegree = new int[n];
        // 反向取.
        for (int i = 0; i < richer.length; ++i) {
            int[] tmp = richer[i];
            graph.get(tmp[0]).add(tmp[1]);
            inDegree[tmp[1]]++;
        }
        Deque<Integer> deque = new LinkedList<Integer>();
        // 找入度为0，也就是最有钱的人开始.
        for (int i = 0; i < n; ++i) {
            if (inDegree[i] == 0) {
                deque.offer(i);
            }
        }
        int[] answer = new int[n];
        for (int i = 0; i < n; ++i) {
            // 至少是自己本身.
            answer[i] = i;
        }
        while (!deque.isEmpty()) {
            int index = deque.poll();
            for (int tmp : graph.get(index)) {
                // 注意，这里比较的answer[i]= ? 对应的value.
                if (quiet[answer[index]] < quiet[answer[tmp]]) {
                    // 具有传递性.
                    answer[tmp] = answer[index];
                }
                if (--inDegree[tmp] == 0) {
                    deque.offer(tmp);
                }
            }
        }
        return answer;
    }

}

package leetcode.offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer II 086. 分割回文子字符串
 * https://leetcode.cn/problems/M99OJA/
 */
public class SolutionOffer_II_086 {

    private List<List<String>> list;

    public String[][] partition(String s) {
        int size = s.length();
        boolean[][] dp = new boolean[size][size];
        char[] chars = s.toCharArray();
        for (int i = size - 1; i >= 0; --i) {
            for (int j = i; j < size; ++j) {
                if (chars[i] == chars[j] && (j - i <= 1 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                }
            }
        }
        list = new ArrayList<>();
        backTracking(s, 0, size, dp, new LinkedList<String>());
        String[][] res = new String[list.size()][];
        for (int i = 0; i < list.size(); ++i) {
            int cols = list.get(i).size();
            res[i] = new String[cols];
            for (int j = 0; j < cols; ++j) {
                res[i][j] = list.get(i).get(j);
            }
        }
        return res;
    }

    private void backTracking(String s, int index, int size, boolean[][] dp, Deque<String> path) {
        if (index == size) {
            list.add(new ArrayList<String>(path));
            return;
        }
        // 注意顺序.
        for (int i = index; i < size; ++i) {
            if (dp[index][i]) {
                path.offer(s.substring(index, i + 1));
                backTracking(s, i + 1, size, dp, path);
                path.pollLast();
            }
        }
    }

}

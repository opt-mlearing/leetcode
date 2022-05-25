package leetcode.base;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * https://leetcode.cn/problems/generate-parentheses/
 */
public class Solution22 {

    private List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<String>();
        backTracking(0, 0, n, new StringBuilder());
        return res;
    }

    private void backTracking(int left, int right, int n, StringBuilder path) {
        if (path.length() == 2 * n) {
            res.add(path.toString());
            return;
        }
        if (left < n) {
            path.append('(');
            backTracking(left + 1, right, n, path);
            path.deleteCharAt(path.length() - 1);
        }
        if (right < left) {
            path.append(')');
            backTracking(left, right + 1, n, path);
            path.deleteCharAt(path.length() - 1);
        }
    }

}

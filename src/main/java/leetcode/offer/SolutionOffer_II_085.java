package leetcode.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer II 085. 生成匹配的括号
 * https://leetcode.cn/problems/IDBivT/
 */
public class SolutionOffer_II_085 {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        helper(n, 0, 0, new StringBuilder(), list);
        return list;
    }

    private void helper(int n, int left, int right, StringBuilder path, List<String> res) {
        if (path.length() == 2 * n) {
            res.add(path.toString());
            return;
        }
        if (left < n) {
            path.append('(');
            helper(n, left + 1, right, path, res);
            path.deleteCharAt(path.length() - 1);
        }
        if (right < left) {
            path.append(')');
            helper(n, left, right + 1, path, res);
            path.deleteCharAt(path.length() - 1);
        }
    }

}

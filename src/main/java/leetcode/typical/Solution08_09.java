package leetcode.typical;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 08.09. 括号
 * https://leetcode-cn.com/problems/bracket-lcci/
 */
public class Solution08_09 {

    private List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<String>();
        backTracking(n, 0, 0, new StringBuilder());
        return res;
    }

    private void backTracking(int n, int left, int right, StringBuilder builder) {
        if (n * 2 == builder.length()) {
            res.add(builder.toString());
            return;
        }
        // 先增加左括号
        if (left < n) {
            builder.append("(");
            backTracking(n, left + 1, right, builder);
            builder.deleteCharAt(builder.length() - 1);
        }
        // 再增加右括号，注意，此时右括号上限是左括号当前的最大数量.
        if (right < left) {
            builder.append(")");
            backTracking(n, left, right + 1, builder);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

}

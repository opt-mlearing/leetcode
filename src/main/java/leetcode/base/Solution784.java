package leetcode.base;

import java.util.ArrayList;
import java.util.List;

/**
 * 字母大小写全排列
 * https://leetcode-cn.com/problems/letter-case-permutation/
 */
public class Solution784 {

    private List<String> res = null;

    public List<String> letterCasePermutation(String s) {
        res = new ArrayList<String>();
        char[] chars = s.toCharArray();
        dfs(chars, 0);
        return res;
    }

    private void dfs(char[] chars, int index) {
        if (chars.length == index) {
            res.add(new String(chars));
            return;
        }
        // 直接跳过当前位置.
        dfs(chars, index + 1);
        // 如果是字母的话进行转换.
        if (chars[index] >= 'a' && chars[index] <= 'z') {
            chars[index] -= 32;
            dfs(chars, index + 1);
            chars[index] += 32;
        } else if (chars[index] >= 'A' && chars[index] <= 'Z') {
            chars[index] += 32;
            dfs(chars, index + 1);
            chars[index] -= 32;
        }
    }

}

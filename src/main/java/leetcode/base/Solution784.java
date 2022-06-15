package leetcode.base;

import java.util.ArrayList;
import java.util.List;

/**
 * 784. 字母大小写全排列
 * https://leetcode-cn.com/problems/letter-case-permutation/
 *
 * @author: caogl
 * @date: 2022/6/15, 11:48
 **/
public class Solution784 {

    private List<String> res = null;

    public List<String> letterCasePermutation(String s) {
        res = new ArrayList<String>();
        char[] chars = s.toCharArray();
        backTracking(chars, 0);
        return res;
    }

    private void backTracking(char[] chars, int index) {
        if (index == chars.length) {
            res.add(new String(chars));
            return;
        }
        backTracking(chars, index + 1);
        Character tmp = chars[index];
        if (Character.isLetter(tmp)) {
            if (Character.isLowerCase(tmp)) {
                chars[index] = Character.toUpperCase(tmp);
                backTracking(chars, index + 1);
                chars[index] = Character.toLowerCase(tmp);
            } else {
                chars[index] = Character.toLowerCase(tmp);
                backTracking(chars, index + 1);
                chars[index] = Character.toUpperCase(tmp);
            }
        }
    }

    public List<String> letterCasePermutation_dfs(String s) {
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

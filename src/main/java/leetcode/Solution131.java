package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 分割回文串
 * https://leetcode-cn.com/problems/palindrome-partitioning/
 */
public class Solution131 {

    private List<List<String>> res;

    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        Deque<String> deque = new ArrayDeque<String>();
        dfs(s.toCharArray(), 0, deque);
        return res;
    }

    private void dfs(char[] template, int index, Deque<String> deque) {
        if (index == template.length) {
            res.add(new ArrayList<String>(deque));
            return;
        }
        for (int i = index; i < template.length; ++i) {
            if (!isPlalindrome(template, index, i)) {
                continue;
            }
            deque.add(new String(template, index, i + 1 - index));
            dfs(template, i + 1, deque);
            deque.removeLast();
        }
    }

    private boolean isPlalindrome(char[] template, int left, int right) {
        // aba 也是回文
        while (left < right) {
            if (template[left] != template[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}

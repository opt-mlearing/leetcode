package leetcode.base;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 去除重复字母
 * https://leetcode-cn.com/problems/remove-duplicate-letters/
 */
public class Solution316 {

    public String removeDuplicateLetters(String s) {
        // 题目明确小写字母
        int[] lastIndex = new int[26];
        char[] chars = s.toCharArray();
        int size = chars.length;
        // 每个字母最后出现的索引位置.
        for (int i = 0; i < size; ++i) {
            lastIndex[chars[i] - 'a'] = i;
        }
        Deque<Character> stack = new LinkedList<Character>();
        boolean[] isVisit = new boolean[26];
        for (int i = 0; i < size; ++i) {
            int index = chars[i] - 'a';
            if (isVisit[index]) {
                continue;
            }
            // 字典序排前字符已经存在栈中，且后面存在相同的字符.
            while (!stack.isEmpty() && (stack.peek() - 'a' > index) && (lastIndex[stack.peek() - 'a'] > i)) {
                isVisit[stack.pop() - 'a'] = false;
            }
            stack.push(chars[i]);
            isVisit[chars[i] - 'a'] = true;
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            // 注意栈是先进后出，所以需要反过来取
            builder.append(stack.pollLast());
        }
        return builder.toString();
    }

}

package leetcode.base;

/**
 * 151. 颠倒字符串中的单词
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 */
public class Solution151 {

    public String reverseWords(String s) {
        s = removeExtralSpaces(s);
        s = reverse(s, 0, s.length() - 1);
        int left = -1;
        int right = -1;
        boolean entryWord = false;
        for (int i = 0; i < s.length(); ++i) {
            if (!entryWord || (s.charAt(i) != ' ' && s.charAt(i - 1) == ' ')) {
                left = i;
                entryWord = true;
            }
            if (entryWord && s.charAt(i) == ' ' && s.charAt(i - 1) != ' ') {
                right = i - 1;
                entryWord = false;
                s = reverse(s, left, right);
            }
            // 特殊处理组后一个单词
            if (entryWord && s.charAt(i) != ' ' && i == s.length() - 1) {
                right = i;
                entryWord = false;
                s = reverse(s, left, right);
            }
        }
        return s;

    }

    // 反转整个字符串
    private String reverse(String s, int left, int right) {
        char[] chars = s.toCharArray();
        while (left < right) {
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            left++;
            right--;
        }
        return new String(chars);
    }

    // 去除多余空格
    private String removeExtralSpaces(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int slow = 0;
        int fast = 0;
        // 删除字符串前面的空格
        while (len > 0 && fast < len && chars[fast] == ' ') {
            fast++;
        }
        // 删除字符串间的空格
        for (; fast < len; ++fast) {
            if (fast > 0 && chars[fast] == chars[fast - 1] && chars[fast] == ' ') {
                continue;
            } else {
                chars[slow++] = chars[fast];
            }
        }
        // 删除字符串后的空格
        if (slow > 0 && chars[slow - 1] == ' ') {
            return new String(chars, 0, slow - 1);
        } else {
            return new String(chars, 0, slow);
        }
    }

}

package leetcode;

/**
 * 反转字符串中的单词 III
 * https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 */
public class Solution557 {

    public String reverseWords(String s) {
        String[] strArray = s.split(" ");
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < strArray.length; ++i) {
            buffer.append(reverse(strArray[i]));
            if (i != strArray.length - 1) {
                buffer.append(" ");
            }
        }
        return buffer.toString();
    }

    private String reverse(String str) {
        char[] charArray = str.toCharArray();
        int left = 0;
        int right = charArray.length - 1;
        while (left <= right) {
            char tmp = charArray[left];
            charArray[left++] = charArray[right];
            charArray[right--] = tmp;
        }
        return new String(charArray);
    }

}

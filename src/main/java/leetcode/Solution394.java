package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 394. 字符串解码
 * https://leetcode-cn.com/problems/decode-string/submissions/
 */
public class Solution394 {

    private int index;

    public String decodeString(String s) {
        char[] chars = s.toCharArray();
        int size = chars.length;
        Deque<PreInfo> repeat = new LinkedList<>();
        String preString = "";
        int num = 0;
        index = 0;
        while (index < size) {
            if (Character.isDigit(chars[index])) {
                num = findCount(chars);
            } else if (Character.isLetter(chars[index])) {
                preString += findStr(chars);
            } else if (chars[index] == '[') {
                repeat.push(new PreInfo(num, preString));
                preString = "";
                index++;
            } else if (chars[index] == ']') {
                PreInfo info = repeat.pop();
                String str = info.preStr;
                for (int i = 0; i < info.count; ++i) {
                    str += preString;
                }
                preString = str;
                index++;
            }
        }
        return preString;
    }

    private int findCount(char[] chars) {
        int num = 0;
        while (index < chars.length && Character.isDigit(chars[index])) {
            num = num * 10 + (chars[index++] - '0');
        }
        return num;
    }

    private String findStr(char[] chars) {
        StringBuilder builder = new StringBuilder();
        while (index < chars.length && Character.isLetter(chars[index])) {
            builder.append(chars[index++]);
        }
        return builder.toString();
    }

    private static class PreInfo {
        private String preStr;
        private int count;

        public PreInfo(int count, String pre) {
            this.preStr = pre;
            this.count = count;
        }
    }

}

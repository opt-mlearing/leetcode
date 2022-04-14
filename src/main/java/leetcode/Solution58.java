package leetcode;

/**
 * 58. 最后一个单词的长度
 * https://leetcode-cn.com/problems/length-of-last-word/
 */
public class Solution58 {

    public int lengthOfLastWord(String s) {
        String[] strs = s.split(" ");
        for (int i = strs.length - 1; i >= 0; --i) {
            if (!strs[i].equals(" ")) {
                return strs[i].length();
            }
        }
        return 0;
    }

}

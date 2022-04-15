package leetcode.base;

import java.util.HashSet;
import java.util.Set;

/**
 * 804. 唯一摩尔斯密码词
 * https://leetcode-cn.com/problems/unique-morse-code-words/
 */
public class Solution804 {

    private static final String[] MORSE_WORDS =
            {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
                    "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
    private Set<String> set = new HashSet<String>();

    public int uniqueMorseRepresentations(String[] words) {
        for (String str : words) {
            char[] chars = str.toCharArray();
            StringBuilder builder = new StringBuilder();
            for (char item : chars) {
                builder.append(MORSE_WORDS[item - 'a']);
            }
            set.add(builder.toString());
        }
        return set.size();
    }

}

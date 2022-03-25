package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 01.04. 回文排列
 * https://leetcode-cn.com/problems/palindrome-permutation-lcci/
 */
public class Solution01_04 {

    // 位运算
    public boolean canPermutePalindrome(String s) {
        char[] chars = s.toCharArray();
        Long highBit = 0l;
        Long lowBit = 0l;
        for (int i = 0; i < chars.length; ++i) {
            if (chars[i] >= 64) {
                highBit ^= 1L << chars[i] - 64;
            } else {
                lowBit ^= 1L << chars[i];
            }
        }
        return Long.bitCount(highBit) + Long.bitCount(lowBit) <= 1;
    }

    // hash方式
    public boolean canPermutePalindrome_hash(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < chars.length; ++i) {
            Character key = chars[i];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        int count = 0;
        for (Integer num : map.values()) {
            if (num % 2 != 0) {
                ++count;
            }
        }
        return count == 0 || count == 1;
    }

}

package leetcode.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 187. 重复的DNA序列
 * https://leetcode-cn.com/problems/repeated-dna-sequences/submissions/
 */
public class Solution187 {

    // 最大长度.
    private static final int LEN = 10;
    // 初始化字符对照表.
    private static final Map<Character, Integer> binMap = new HashMap<Character, Integer>() {
        {
            put('A', 0);
            put('C', 1);
            put('G', 2);
            put('T', 3);
        }
    };

    // hash + bit+ 滑动窗口
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<String>();
        if (s == null || s.length() <= LEN) {
            return res;
        }
        int num = 0;
        // 注意，这里暂时截取前9个字符.
        for (int i = 0; i < LEN - 1; ++i) {
            num = ((num << 2) | binMap.get(s.charAt(i)));
        }
        Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        for (int i = 0; i <= s.length() - LEN; ++i) {
            num = ((num << 2) | binMap.get(s.charAt(i + LEN - 1))) & ((1 << (LEN * 2)) - 1);
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            if (countMap.get(num) == 2) {
                res.add(s.substring(i, i + LEN));
            }
        }
        return res;
    }

    // hash朴素循环方法.
    public List<String> findRepeatedDnaSequences_1(String s) {
        List<String> res = new ArrayList<String>();
        // 长度为10的子串出现次数需要大于1.
        if (s == null && s.length() <= LEN) {
            return res;
        }
        Map<String, Integer> map = new HashMap<String, Integer>();
        // 注意，这里for循环上限制取值 i<= s.length()- LEN, 因为 s.substring(start, end), end是不截取的.
        for (int i = 0; i <= s.length() - LEN; ++i) {
            String tmp = s.substring(i, i + LEN);
            if (map.keySet().contains(tmp)) {
                if (map.get(tmp) == 1) {
                    res.add(tmp);
                }
                map.put(tmp, map.get(tmp) + 1);
            } else {
                map.put(tmp, 1);
            }
        }
        return res;
    }

}

package leetcode.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1408. 数组中的字符串匹配
 * https://leetcode.cn/problems/string-matching-in-an-array/
 *
 * @author: caogl
 * @date: 2022/6/14, 21:11
 **/
public class Solution1408 {

    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();
        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
        int size = words.length;
        for (int i = 0; i < size; ++i) {
            for (int j = i + 1; j < size; ++j) {
                if (words[j].indexOf(words[i]) >= 0) {
                    res.add(words[i]);
                    // 注意，要加break.
                    break;
                }
            }
        }
        return res;
    }

}

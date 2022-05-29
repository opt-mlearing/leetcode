package leetcode.offer;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 剑指 Offer II 033. 变位词组
 * https://leetcode.cn/problems/sfvd7V/
 */
public class SolutionOffer_II_033 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String word : strs) {
            char[] item = word.toCharArray();
            Arrays.sort(item);
            String key = new String(item);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(word);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

}

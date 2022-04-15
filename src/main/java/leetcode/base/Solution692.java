package leetcode.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 前K个高频单词
 * https://leetcode-cn.com/problems/top-k-frequent-words/
 */
public class Solution692 {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        List<String> keyList = new ArrayList<String>();
        for (int i = 0; i < words.length; ++i) {
            String word = words[i];
            if (!keyList.contains(word)) {
                keyList.add(word);
            }
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        keyList.sort((word1, word2) -> {
            if (map.get(word1) == map.get(word2)) {
                return word1.compareTo(word2);
            } else {
                return map.get(word2) - map.get(word1);
            }
        });
        return keyList.subList(0, k);
    }

}

package leetcode.base;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 269. 火星词典 (同：剑指 Offer II 114. 外星文字典)
 * https://leetcode.cn/problems/Jf1JuT/
 */
public class Solution269 {

    private Map<Character, List<Character>> adjacentEdges;
    private int[] inDegree;

    public String alienOrder(String[] words) {
        adjacentEdges = new HashMap<>();
        inDegree = new int[26];
        for (int i = 0; i < words.length; ++i) {
            for (int j = 0; j < words[i].length(); ++j) {
                adjacentEdges.putIfAbsent(words[i].charAt(j), new ArrayList<Character>());
            }
        }
        inDegree = new int[26];
        for (int i = 0; i < words.length - 1; ++i) {
            boolean state = graph(words[i], words[i + 1]);
            if (!state) {
                return "";
            }
        }
        Deque<Character> stack = new LinkedList<Character>();
        // words中出现的资字母个数.
        int size = adjacentEdges.size();
        boolean[] isVisit = new boolean[26];
        for (int i = 0; i < 26; ++i) {
            if (!isVisit[i] && (inDegree[i] == 0) && adjacentEdges.containsKey((char) (i + 'a'))) {
                stack.push((char) (i + 'a'));
                isVisit[i] = true;
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            int len = stack.size();
            for (int i = 0; i < len; ++i) {
                char item = stack.poll();
                builder.append(item);
                List<Character> subList = adjacentEdges.get(item);
                for (int j = 0; j < subList.size(); ++j) {
                    char element = subList.get(j);
                    int index = element - 'a';
                    inDegree[index]--;
                    if (inDegree[index] == 0 && !isVisit[index]) {
                        stack.offer(element);
                    }
                }
            }
        }
        return builder.length() < size ? "" : builder.toString();
    }

    private boolean graph(String pre, String next) {
        int size = Math.min(pre.length(), next.length());
        for (int i = 0; i < size; ++i) {
            char char1 = pre.charAt(i);
            char char2 = next.charAt(i);
            if (char1 != char2) {
                adjacentEdges.get(char1).add(char2);
                inDegree[(int) (char2 - 'a')]++;
                return true;
            }
        }
        return pre.length() < next.length();
    }

}

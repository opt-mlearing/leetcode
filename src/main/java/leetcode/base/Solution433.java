package leetcode.base;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 433. 最小基因变化
 * https://leetcode.cn/problems/minimum-genetic-mutation/
 *
 * @author: caogl
 * @date: 2022/6/18, 11:35
 **/
public class Solution433 {

    private char[] change = {'A', 'C', 'G', 'T'};

    public int minMutation_bfs_2(String start, String end, String[] bank) {
        if (start.equals(end)) {
            return 0;
        }
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < bank.length; ++i) {
            set.add(bank[i]);
        }
        if (!set.contains(end)) {
            return -1;
        }
        Deque<String> stack = new LinkedList<String>();
        stack.offer(start);
        // 避免走回头路.
        Set<String> isVisit = new HashSet<String>();
        isVisit.add(start);
        int res = 0;
        while (!stack.isEmpty()) {
            int size = stack.size();
            for (int i = 0; i < size; ++i) {
                String tmp = stack.poll();
                if (tmp.equals(end)) {
                    return res;
                }
                char[] tmpArray = tmp.toCharArray();
                for (int j = 0; j < tmpArray.length; ++j) {
                    for (int k = 0; k < change.length; ++k) {
                        if (tmp.charAt(j) != change[k]) {
                            char tmpChar = tmpArray[j];
                            tmpArray[j] = change[k];
                            String newStr = new String(tmpArray);
                            if (set.contains(newStr) && !isVisit.contains(newStr)) {
                                stack.offer(newStr);
                                isVisit.add(newStr);
                            }
                            tmpArray[j] = tmpChar;
                        }
                    }
                }
            }
            res++;
        }
        return -1;
    }

    public int minMutation(String start, String end, String[] bank) {
        int res = 0;
        Deque<String> stack = new LinkedList<String>();
        stack.offer(start);
        int bankSize = bank.length;
        // 避免走回头路.
        Set<String> isVisit = new HashSet<String>();
        isVisit.add(start);
        while (!stack.isEmpty()) {
            int size = stack.size();
            for (int i = 0; i < size; ++i) {
                String tmp = stack.poll();
                if (tmp.equals(end)) {
                    return res;
                }
                // 每次只找变换一个位置的字符.
                for (int j = 0; j < bankSize; ++j) {
                    if (!isVisit.contains(bank[j]) && distanceOneStep(tmp, bank[j])) {
                        stack.offer(bank[j]);
                        isVisit.add(bank[j]);
                    }
                }
            }
            res++;
        }
        return -1;
    }

    private boolean distanceOneStep(String tmp, String compare) {
        int distance = 0;
        for (int i = 0; i < tmp.length(); ++i) {
            if (tmp.charAt(i) != compare.charAt(i)) {
                distance++;
            }
        }
        return distance == 1;
    }

}

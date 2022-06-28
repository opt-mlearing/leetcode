package leetcode.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 838. 推多米诺
 * https://leetcode.cn/problems/push-dominoes/
 *
 * @author: caogl
 * @date: 2022/6/28, 23:55
 **/
public class Solution838 {

    public String pushDominoes(String dominoes) {
        int size = dominoes.length();
        int[] times = new int[size];
        Arrays.fill(times, -1);
        List<Character>[] force = new List[size];
        for (int i = 0; i < size; ++i) {
            force[i] = new ArrayList<Character>();
        }
        // 初始化.
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < size; ++i) {
            if (dominoes.charAt(i) != '.') {
                times[i] = 0;
                force[i].add(dominoes.charAt(i));
                stack.offer(i);
            }
        }
        char[] res = new char[size];
        Arrays.fill(res, '.');
        while (!stack.isEmpty()) {
            int index = stack.poll();
            if (force[index].size() == 1) {
                char dir = force[index].get(0);
                res[index] = dir;
                int next = dir == 'L' ? index - 1 : index + 1;
                if (next >= 0 && next < size) {
                    int time = times[index];
                    if (times[next] == -1) {
                        times[next] = time + 1;
                        stack.offer(next);
                        force[next].add(dir);
                    } else if (times[next] == time + 1) {
                        force[next].add(dir);
                    }
                }
            }
        }
        return new String(res);
    }

}

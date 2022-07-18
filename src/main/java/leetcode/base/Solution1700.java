package leetcode.base;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1700. 无法吃午餐的学生数量
 * https://leetcode.cn/problems/number-of-students-unable-to-eat-lunch/
 *
 * @author: caogl
 * @date: 2022/7/19, 1:35
 **/
public class Solution1700 {

    public int countStudents(int[] students, int[] sandwiches) {
        int size = students.length;
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < size; ++i) {
            stack.offer(students[i]);
        }
        Deque<Integer> tmp = new LinkedList<Integer>();
        for (int i = 0; i < size; ++i) {
            while (!stack.isEmpty() && sandwiches[i] != stack.peek()) {
                tmp.offer(stack.poll());
            }
            if (stack.isEmpty()) {
                return tmp.size();
            }
            stack.poll();
            while (!tmp.isEmpty()) {
                stack.offer(tmp.poll());
            }
        }
        return 0;
    }

}

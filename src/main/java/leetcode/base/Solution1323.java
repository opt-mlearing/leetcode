package leetcode.base;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1323. 6 和 9 组成的最大数字
 * https://leetcode.cn/problems/maximum-69-number/
 *
 * @author caogaoli
 * @date 2022/7/14 11:17
 */
public class Solution1323 {

    // 0ms/38.3mb
    public int maximum69Number(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        int size = chars.length;
        int index = 0;
        while (index < size) {
            if (chars[index] == '6') {
                chars[index] = '9';
                break;
            }
            index++;
        }
        return Integer.parseInt(new String(chars));
    }

    // 1ms/38.1mb
    public int maximum69Number_1(int num) {
        Deque<Integer> stack = new LinkedList<Integer>();
        while (num != 0) {
            int tmp = num % 10;
            stack.push(tmp);
            num = num / 10;
        }
        int res = 0;
        int count = 0;
        while (!stack.isEmpty()) {
            int tmp = stack.pop();
            if (count == 0 && tmp == 6) {
                tmp = 9;
                count++;
            }
            res = res * 10 + tmp;
        }
        return res;
    }

}

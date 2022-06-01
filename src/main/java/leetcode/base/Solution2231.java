package leetcode.base;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 2231. 按奇偶性交换后的最大数字
 * https://leetcode.cn/problems/largest-number-after-digit-swaps-by-parity/submissions/
 */
public class Solution2231 {

    // 选择排序.
    public int largestInteger(int num) {
        String numStr = Integer.toString(num);
        int[] nums = new int[numStr.length()];
        for (int i = 0; i < nums.length; ++i) {
            nums[i] = numStr.charAt(i) - '0';
        }
        for (int i = 0; i < nums.length - 1; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if ((nums[i] - nums[j]) % 2 == 0 && nums[i] < nums[j]) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            res = res * 10 + nums[i];
        }
        return res;
    }

    private Deque<Integer> odd;
    private Deque<Integer> even;
    private Deque<Integer> stack;

    public int largestInteger_stack(int num) {
        odd = new LinkedList<Integer>();
        even = new LinkedList<Integer>();
        stack = new LinkedList<Integer>();
        List<Boolean> isEven = new ArrayList<Boolean>();
        while (num != 0) {
            int tmp = num % 10;
            if (tmp % 2 == 0) {
                isEven.add(true);
                putNumber(even, tmp, stack);
            } else {
                isEven.add(false);
                putNumber(odd, tmp, stack);
            }
            num = num / 10;
        }
        int res = 0;
        for (int i = isEven.size() - 1; i >= 0; --i) {
            if (isEven.get(i)) {
                res = res * 10 + even.poll();
            } else {
                res = res * 10 + odd.poll();
            }
        }
        return res;
    }

    private void putNumber(Deque<Integer> stack, int num, Deque<Integer> tmp) {
        tmp.clear();
        while (!stack.isEmpty() && stack.peek() > num) {
            tmp.push(stack.poll());
        }
        stack.push(num);
        while (!tmp.isEmpty()) {
            stack.push(tmp.poll());
        }
    }

}

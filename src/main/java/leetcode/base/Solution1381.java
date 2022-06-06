package leetcode.base;

/**
 * 1381. 设计一个支持增量操作的栈
 * https://leetcode.cn/problems/design-a-stack-with-increment-operation/
 */
public class Solution1381 {

    private int top;
    private int[] nums;
    private int size;

    public Solution1381(int maxSize) {
        nums = new int[maxSize];
        top = -1;
        size = maxSize;
    }

    public void push(int x) {
        if (top == size - 1) {
            return;
        }
        nums[++top] = x;
    }

    public int pop() {
        if (top == -1) {
            return -1;
        }
        return nums[top--];
    }

    public void increment(int k, int val) {
        // 注意，这里栈顶 top在遍历的时候一定要+ 1.
        for (int i = 0; i < Math.min(k, top + 1); ++i) {
            nums[i] += val;
        }
    }

}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */

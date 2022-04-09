package leetcode.office;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer II 039. 直方图最大矩形面积
 * https://leetcode-cn.com/problems/0ynMMM/
 */
public class SolutionOffice2_039 {

    public int largestRectangleArea(int[] heights) {
        int size= heights.length;
        Deque<Integer> stack= new LinkedList<Integer>();
        int[] pre= new int[size];
        for(int i= 0; i< size; ++i){
            while(!stack.isEmpty() && heights[i]<= heights[stack.peek()]){
                stack.pop();
            }
            pre[i]= stack.isEmpty()? -1: stack.peek();
            stack.push(i);
        }
        stack.clear();
        int[] post= new int[size];
        for(int i= size- 1; i>= 0; --i){
            while(!stack.isEmpty() && heights[i]< heights[stack.peek()]){
                stack.pop();
            }
            post[i]= stack.isEmpty()? size: stack.peek();
            stack.push(i);
        }
        int res= 0;
        for(int i= 0; i< size; ++i){
            res= Math.max(res, heights[i]* (post[i]- pre[i]- 1));
        }
        return res;
    }

}

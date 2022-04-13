package leetcode.typical;

import java.util.List;

/**
 * 面试题 08.06. 汉诺塔问题
 * https://leetcode-cn.com/problems/hanota-lcci/
 */
public class Solution08_06 {

    // doHanota(n, A, B, C)= doHanota(n- 1, A, C, B)+ doHanota(1, A, B, C)+ doHanota(n- 1, B, A, C);
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        doHanota(A.size(), A, B, C);
    }

    private void doHanota(int size, List<Integer> first, List<Integer> second, List<Integer> third) {
        if (size == 1) {
            third.add(first.remove(first.size() - 1));
            return;
        }
        doHanota(size - 1, first, third, second);
        third.add(first.remove(first.size() - 1));
        doHanota(size - 1, second, first, third);
    }

}

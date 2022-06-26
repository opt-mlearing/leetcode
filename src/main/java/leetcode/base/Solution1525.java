package leetcode.base;

/**
 * 1525. 字符串的好分割数目
 * https://leetcode.cn/problems/number-of-good-ways-to-split-a-string/
 *
 * @author: caogl
 * @date: 2022/6/27, 1:15
 **/
public class Solution1525 {

    public int numSplits(String s) {
        int size = s.length();
        boolean[] isleft = new boolean[26];
        int[] left = new int[size + 2];
        for (int i = 1; i <= size; ++i) {
            int index = s.charAt(i - 1) - 'a';
            if (isleft[index]) {
                left[i] = left[i - 1];
            } else {
                isleft[index] = true;
                left[i] = left[i - 1] + 1;
            }
        }
        boolean[] isRight = new boolean[26];
        int[] right = new int[size + 2];
        for (int i = size; i > 0; --i) {
            int index = s.charAt(i - 1) - 'a';
            if (isRight[index]) {
                right[i] = right[i + 1];
            } else {
                isRight[index] = true;
                right[i] = right[i + 1] + 1;
            }
        }
        int res = 0;
        for (int i = 1; i < size; ++i) {
            if (left[i] == right[i + 1]) {
                res++;
            }
        }
        return res;
    }
    
}

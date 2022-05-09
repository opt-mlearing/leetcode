package leetcode.base;

/**
 * 942. 增减字符串匹配
 * https://leetcode.cn/problems/di-string-match/
 */
public class Solution942 {

    public int[] diStringMatch(String s) {
        int size = s.length();
        int left = 0;
        int right = size;
        int[] res = new int[size + 1];
        for (int i = 0; i < size; ++i) {
            if (s.charAt(i) == 'I') {
                res[i] = left++;
            } else if (s.charAt(i) == 'D') {
                res[i] = right--;
            }
        }
        assert left == right;
        res[size] = right;
        return res;
    }

}

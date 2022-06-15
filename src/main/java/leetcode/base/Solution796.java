package leetcode.base;

/**
 * 796. 旋转字符串
 * https://leetcode.cn/problems/rotate-string/
 *
 * @author: caogl
 * @date: 2022/6/15, 12:12
 **/
public class Solution796 {

    public boolean rotateString(String s, String goal) {
        int m = s.length();
        int n = goal.length();
        if (m != n) {
            return false;
        }
        for (int i = 0; i < m; ++i) {
            boolean flag = true;
            for (int j = 0; j < m; ++j) {
                if (goal.charAt(j) != s.charAt((i + j) % m)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }

    public boolean rotateString_api(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        return (s + s).indexOf(goal) >= 0;
    }

}

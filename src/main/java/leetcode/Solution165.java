package leetcode;

/**
 * 比较版本号
 * https://leetcode-cn.com/problems/compare-version-numbers/
 */
public class Solution165 {

    public int compareVersion(String version1, String version2) {
        int l1 = 0;
        int l2 = 0;
        while (l1 < version1.length() || l2 < version2.length()) {
            int v1 = 0;
            for (; l1 < version1.length() && version1.charAt(l1) != '.'; ++l1) {
                v1 = v1 * 10 + version1.charAt(l1) - '0';
            }
            ++l1;
            int v2 = 0;
            for (; l2 < version2.length() && version2.charAt(l2) != '.'; ++l2) {
                v2 = v2 * 10 + version2.charAt(l2) - '0';
            }
            ++l2;
            if (v1 > v2) {
                return 1;
            } else if (v1 < v2) {
                return -1;
            }
        }
        return 0;
    }

}

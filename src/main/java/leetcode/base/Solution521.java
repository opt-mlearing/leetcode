package leetcode.base;

public class Solution521 {

    public int findLUSlength(String a, String b) {
        if (!a.equals(b)) {
            return Math.max(a.length(), b.length());
        }
        return -1;
    }

}

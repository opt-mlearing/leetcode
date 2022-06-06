package algorithm4;

import java.util.Arrays;
import java.util.List;

class StringMatchSolution {

    /* 暴力匹配字符串 */
    public int match1(String pat, String txt) {
        int m = pat.length();
        int n = txt.length();
        for (int i = 0; i <= n - m; ++i) {
            int j = 0;
            for (j = 0; j < m; ++j) {
                if (pat.charAt(j) != txt.charAt(i + j)) {
                    break;
                }
            }
            // 找到匹配.
            if (j == m) {
                return i;
            }
        }
        // 未找到匹配.
        return -1;
    }

    /* 暴力匹配，显示回推指针 */
    public int match2(String pat, String txt) {
        int m = pat.length();
        int n = txt.length();
        int i = 0;
        int j = 0;
        for (i = 0, j = 0; i < m && j < n; ++i) {
            if (pat.charAt(j) == txt.charAt(i)) {
                ++j;
            } else {
                i -= j;
                j = 0;
            }
        }
        if (j == m) {
            return i - m;
        }
        return -1;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        StringMatchSolution matchSolution = new StringMatchSolution();
        List<Integer> sOrder = Arrays.asList(2, 2, 3, 2, 2, 3);
        List<Integer> tOrder = Arrays.asList(2, 2, 2, 2, 2, 2, 3, 2, 2, 3, 5);
        boolean kmp = matchSolution.kmp(sOrder, tOrder);
        assert kmp == true;
    }


    public boolean kmp(List<Integer> sOrder, List<Integer> tOrder) {
        int sLen = sOrder.size();
        int tLen = tOrder.size();
        int[] fail = new int[sOrder.size()];
        Arrays.fill(fail, -1);
        for (int i = 1, j = -1; i < sLen; ++i) {
            while (j != -1 && !sOrder.get(i).equals(sOrder.get(j + 1))) {
                j = fail[j];
            }
            if (sOrder.get(i).equals(sOrder.get(j + 1))) {
                ++j;
            }
            fail[i] = j;
        }
        for (int i = 0, j = -1; i < tLen; ++i) {
            while (j != -1 && !tOrder.get(i).equals(sOrder.get(j + 1))) {
                j = fail[j];
            }
            if (tOrder.get(i).equals(sOrder.get(j + 1))) {
                ++j;
            }
            if (j == sLen - 1) {
                return true;
            }
        }
        return false;
    }

}
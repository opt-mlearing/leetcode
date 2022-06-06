package leetcode.base;

/**
 * 1684. 统计一致字符串的数目
 * https://leetcode.cn/problems/count-the-number-of-consistent-strings/submissions/
 */
public class Solution1648 {

    public int countConsistentStrings(String allowed, String[] words) {
        int size1 = allowed.length();
        int[] nums = new int[26];
        for (int i = 0; i < allowed.length(); ++i) {
            int index = allowed.charAt(i) - 'a';
            nums[index]++;
        }
        int res = 0;
        for (int i = 0; i < words.length; ++i) {
            String word = words[i];
            boolean flag = true;
            for (int j = 0; j < word.length(); ++j) {
                int index = word.charAt(j) - 'a';
                if (nums[index] == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res++;
            }
        }
        return res;
    }

}

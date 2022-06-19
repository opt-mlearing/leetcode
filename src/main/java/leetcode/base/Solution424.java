package leetcode.base;

/**
 * 424. 替换后的最长重复字符
 * https://leetcode.cn/problems/longest-repeating-character-replacement/
 *
 * @author: caogl
 * @date: 2022/6/20, 0:13
 **/
public class Solution424 {

    public int characterReplacement(String s, int k) {
        int size = s.length();
        int[] count = new int[size];
        int left = 0;
        int right = 0;
        int res = 0;
        int maxFrequent = 0;
        while (right < size) {
            int index = s.charAt(right) - 'A';
            count[index]++;
            maxFrequent = Math.max(maxFrequent, count[index]);
            // 出现频率最多的字符不变化，其他字符变化.
            if (right - left + 1 - maxFrequent > k) {
                index = s.charAt(left) - 'A';
                count[index]--;
                maxFrequent = Math.max(maxFrequent, count[index]);
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }

}

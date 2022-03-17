package leetcode;

/**
 * 反转字符串中的元音字母
 * https://leetcode-cn.com/problems/reverse-vowels-of-a-string/
 */
public class Solution345 {

    public String reverseVowels(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] array = s.toCharArray();
        while (left < right) {
            while (left < right && !isVowel(s.charAt(left))) {
                left++;
            }
            while (right > left && !isVowel(s.charAt(right))) {
                right--;
            }
            // 注意，这里一定需要判断下left< right
            if (left < right) {
                swap(array, left, right);
                ++left;
                --right;
            }
        }
        return new String(array);
    }

    private void swap(char[] array, int left, int right) {
        char tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }

    private boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) >= 0;
    }

}

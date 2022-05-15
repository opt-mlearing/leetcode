package leetcode.offer;

/**
 * 剑指 Offer 11. 旋转数组的最小数字
 * https://leetcode.cn/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 */
public class SolutionOffer_11 {

    public int minArray(int[] numbers) {
        int left = 0;
        int size = numbers.length;
        int right = size - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] < numbers[right]) {
                right = mid;
            } else if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if (numbers[mid] == numbers[right]) {
                right--;
            }
        }
        return numbers[right];
    }

}

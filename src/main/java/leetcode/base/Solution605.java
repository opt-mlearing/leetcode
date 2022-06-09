package leetcode.base;

/**
 * 605. 种花问题
 * https://leetcode.cn/problems/can-place-flowers/
 */
public class Solution605 {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int size = flowerbed.length;
        int i = 0;
        while (i < size) {
            if (flowerbed[i] == 0) {
                if (i == size - 1) {
                    n--;
                    break;
                }
                if (flowerbed[i + 1] == 0) {  // 00 种花
                    n--;
                    i += 2;
                } else if (flowerbed[i + 1] == 1) {  // 010 不种花
                    i += 3;
                }
            } else if (flowerbed[i] == 1) {  // 10 不种花
                i += 2;
            }
        }
        return n <= 0;
    }

}

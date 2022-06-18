package leetcode.base;

/**
 * 299. 猜数字游戏
 * https://leetcode.cn/problems/bulls-and-cows/
 *
 * @author: caogl
 * @date: 2022/6/18, 10:42
 **/
public class Solution299 {

    public String getHint(String secret, String guess) {
        int[] sCount = new int[10];
        int[] gCount = new int[10];
        int bulls = 0;
        for (int i = 0; i < secret.length(); ++i) {
            int index1 = secret.charAt(i) - '0';
            int index2 = guess.charAt(i) - '0';
            if (index1 == index2) {
                bulls++;
            } else {
                // 只用cows数字.
                sCount[index1]++;
                gCount[index2]++;
            }
        }
        int cows = 0;
        for (int i = 0; i < 10; ++i) {
            cows += Math.min(sCount[i], gCount[i]);
        }
        return String.valueOf(bulls) + "A" + String.valueOf(cows) + "B";
    }

}

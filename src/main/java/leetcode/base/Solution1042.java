package leetcode.base;

import java.util.ArrayList;
import java.util.List;

/**
 * 1042. 不邻接植花
 * https://leetcode.cn/problems/flower-planting-with-no-adjacent/
 */
public class Solution1042 {

    public int[] gardenNoAdj(int n, int[][] paths) {
        List<List<Integer>> adjacent = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            adjacent.add(new ArrayList<Integer>());
        }
        for (int[] path : paths) {
            int x = path[0] - 1;
            int y = path[1] - 1;
            adjacent.get(x).add(y);
            adjacent.get(y).add(x);
        }
        int[] flowers = {1, 2, 3, 4};
        int[] res = new int[n];
        for (int i = 0; i < n; ++i) {
            boolean[] isFlowers = new boolean[5];
            isFlowers[0] = true;
            for (int j : adjacent.get(i)) {
                if (res[j] != 0) {
                    isFlowers[res[j]] = true;
                }
            }
            for (int j = 1; j <= 4; ++j) {
                if (isFlowers[j] == false) {
                    res[i] = j;
                    break;
                }
            }
        }
        return res;
    }

}

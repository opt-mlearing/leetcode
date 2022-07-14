package leetcode.base;

/**
 * 997. 找到小镇的法官
 * https://leetcode.cn/problems/find-the-town-judge/
 *
 * @author caogaoli
 * @date 2022/7/14 10:28
 */
public class Solution997 {

    public int findJudge(int n, int[][] trust) {
        // 法官出度为0，入度为n-1.
        int[] inDegree = new int[n + 1];
        int[] ouDegree = new int[n + 1];
        int size = trust.length;
        for (int i = 0; i < size; ++i) {
            ouDegree[trust[i][0]]++;
            inDegree[trust[i][1]]++;
        }
        for (int i = 1; i <= n; ++i) {
            if (inDegree[i] == n - 1 && ouDegree[i] == 0) {
                return i;
            }
        }
        return -1;
    }

}

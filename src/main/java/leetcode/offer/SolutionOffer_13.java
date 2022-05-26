package leetcode.offer;

/**
 * 剑指 Offer 13. 机器人的运动范围
 * https://leetcode.cn/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 */
public class SolutionOffer_13 {

    private boolean[][] isVisit;

    public int movingCount(int m, int n, int k) {
        isVisit = new boolean[m][n];
        return dfs(m, n, k, 0, 0);
    }

    private boolean isOverStep(int left, int right, int k) {
        int tmp = getNum(left) + getNum(right);
        return tmp <= k ? false : true;
    }

    private int getNum(int num) {
        int sum = 0;
        while (num / 10 != 0) {
            sum += num % 10;
            num /= 10;
        }
        sum += num;
        return sum;
    }

    private int dfs(int m, int n, int k, int left, int right) {
        if (left < 0 || left >= m || right < 0 || right >= n || isOverStep(left, right, k)) {
            return 0;
        }
        if (isVisit[left][right]) {
            return 0;
        }
        isVisit[left][right] = true;
        return 1 + dfs(m, n, k, left + 1, right)
                + dfs(m, n, k, left - 1, right)
                + dfs(m, n, k, left, right + 1)
                + dfs(m, n, k, left, right - 1);
    }

}

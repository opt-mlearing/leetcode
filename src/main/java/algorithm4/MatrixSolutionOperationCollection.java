package algorithm4;

public class MatrixSolutionOperationCollection {

    /**
     * 数组反转.
     *
     * @param nums
     * @return
     */
    public int[] arrayReversal(int[] nums) {
        for (int i = 0; i < nums.length / 2; ++i) {
            int tmp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = tmp;
        }
        return nums;
    }

    /**
     * 矩阵点乘.
     *
     * @param a 二唯数组
     * @param b 二维数组
     * @return 二维数组
     */
    private int[][] matrixMultiple(int[][] a, int[][] b) {
        int[][] c = new int[a.length][b[0].length];
        assert a[0].length == b[0].length;
        for (int i = 0; i < a.length; ++i) {
            for (int j = 0; j < b[0].length; ++j) {
                for (int k = 0; k < b.length; ++k) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }

}

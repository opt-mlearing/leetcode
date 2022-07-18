package leetcode.base;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1710. 卡车上的最大单元数
 * https://leetcode.cn/problems/maximum-units-on-a-truck/
 *
 * @author: caogl
 * @date: 2022/7/19, 0:34
 **/
public class Solution1710 {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, new Comparator<int[]>() {
            public int compare(int[] boxType1, int[] boxType2) {
                return boxType2[1] - boxType1[1];
            }
        });
        int count = 0;
        for (int[] box : boxTypes) {
            if (truckSize >= box[0]) {
                count += box[0] * box[1];
                truckSize -= box[0];
            } else {
                count += truckSize * box[1];
                return count;
            }
        }
        return count;
    }

}

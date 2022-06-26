package leetcode.base;

import java.util.ArrayList;
import java.util.List;

/**
 * 179. 最大数
 * https://leetcode.cn/problems/largest-number/submissions/
 *
 * @author: caogl
 * @date: 2022/6/26, 18:39
 **/
public class Solution179 {

    public String largestNumber(int[] nums) {
        int size = nums.length;
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < size; ++i) {
            list.add(String.valueOf(nums[i]));
        }
        list.sort((o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < size; ++i) {
            builder.append(list.get(i));
        }
        if (builder.charAt(0) == '0') {
            return "0";
        } else {
            return builder.toString();
        }
    }


}

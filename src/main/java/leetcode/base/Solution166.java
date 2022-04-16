package leetcode.base;

import java.util.HashMap;
import java.util.Map;

/**
 * 166. 分数到小数
 * https://leetcode-cn.com/problems/fraction-to-recurring-decimal/submissions/
 */
public class Solution166 {

    public String fractionToDecimal(int numerator, int denominator) {
        long numeratorLong = (long) numerator;
        long denominatorLong = (long) denominator;
        if (numeratorLong % denominatorLong == 0) {
            return String.valueOf(numeratorLong / denominatorLong);
        }
        StringBuilder builder = new StringBuilder();
        if ((numerator < 0) ^ (denominator < 0)) {
            builder.append('-');
        }
        numeratorLong = Math.abs(numeratorLong);
        denominatorLong = Math.abs(denominatorLong);
        long integerPart = numeratorLong / denominatorLong;
        builder.append(String.valueOf(integerPart));
        builder.append('.');
        Map<Long, Integer> fractionalMap = new HashMap<Long, Integer>();
        long fractionalNum = numeratorLong % denominatorLong;
        int fromIndex = builder.length();
        while (fractionalNum != 0 && !fractionalMap.containsKey(fractionalNum)) {
            fractionalMap.put(fractionalNum, fromIndex++);
            // 注意，这里需要* 10.
            fractionalNum *= 10;
            builder.append(String.valueOf(fractionalNum / denominatorLong));
            fractionalNum = fractionalNum % denominatorLong;
        }
        if (fractionalNum != 0) {
            int inserIndex = fractionalMap.get(fractionalNum);
            builder.insert(inserIndex, '(');
            builder.append(')');
        }
        return builder.toString();
    }

}

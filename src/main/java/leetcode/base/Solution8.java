package leetcode.base;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/string-to-integer-atoi/
 * 字符串转换整数 (atoi)
 */
public class Solution8 {

    // 还是用自动机好，其他方法if else写的很乱.
    public int myAtoi(String s) {
        Automaton automaton = new Automaton();
        int index = 0;
        while (index < s.length()) {
            automaton.next(s.charAt(index));
            index++;
        }
        return automaton.flag * (int) automaton.value;
    }

    private static class Automaton {
        private int flag;
        private long value;
        private Map<String, String[]> mapping = null;
        private String state;

        public Automaton() {
            flag = 1;
            value = 0;
            state = "start";
            mapping = new HashMap<String, String[]>();
            mapping.put("start", new String[]{"start", "single", "number", "end"});
            mapping.put("single", new String[]{"end", "end", "number", "end"});
            mapping.put("number", new String[]{"end", "end", "number", "end"});
            mapping.put("end", new String[]{"end", "end", "end", "end"});
        }

        public void next(char item) {
            state = mapping.get(state)[getIndex(item)];
            if (state.equals("single")) {
                flag = (item == '+' ? 1 : -1);
            } else if (state.equals("number")) {
                int lastValue = item - '0';
                value = value * 10 + lastValue;
                // 这里value永远是大于等于0，不带符号的.
                value = (flag == 1 ? Math.min(value, (long) Integer.MAX_VALUE) : Math.min(value, -(long) Integer.MIN_VALUE));
            }
        }

        private int getIndex(char item) {
            if (item == ' ') {
                return 0;
            } else if (item == '+' || item == '-') {
                return 1;
            } else if (item >= '0' && item <= '9') {
                return 2;
            } else {
                return 3;
            }
        }
    }

}

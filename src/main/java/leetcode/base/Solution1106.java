package leetcode.base;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1106. 解析布尔表达式
 * https://leetcode.cn/problems/parsing-a-boolean-expression/
 */
public class Solution1106 {

    public boolean parseBoolExpr(String expression) {
        Deque<Character> operStack = new LinkedList<Character>();
        Deque<Character> valueStack = new LinkedList<Character>();
        int size = expression.length();
        for (int i = 0; i < size; ++i) {
            char item = expression.charAt(i);
            if (item == '!' || item == '|' || item == '&') {
                operStack.push(item);
            } else if (item == '(' || item == 'f' || item == 't') {
                valueStack.push(item);
            } else if (item == ',') {
                continue;
            } else if (item == ')') {
                int trueCount = 0;
                int falseCount = 0;
                while (!valueStack.isEmpty()) {
                    int tmp = valueStack.poll();
                    if (tmp == 't') {
                        trueCount++;
                    } else if (tmp == 'f') {
                        falseCount++;
                    } else if (tmp == '(') {
                        break;
                    }
                }
                char oper = operStack.poll();
                if (oper == '!') {
                    valueStack.push(trueCount > 0 ? 'f' : 't');
                } else if (oper == '|') {
                    valueStack.push(trueCount > 0 ? 't' : 'f');
                } else if (oper == '&') {
                    valueStack.push(falseCount > 0 ? 'f' : 't');
                }
            }
        }
        return valueStack.peek() == 't' ? true : false;
    }

}
package leetcode.base;

import java.util.ArrayList;
import java.util.List;

/**
 * 为运算表达式设计优先级
 * https://leetcode-cn.com/problems/different-ways-to-add-parentheses/
 */
public class Solution241 {

    public List<Integer> diffWaysToCompute_by_recursion(String expression) {
        List<Integer> res = new ArrayList<Integer>();
        if (expression == null && expression.length() == 0) {
            return res;
        }
        int num = 0;
        int index = 0;
        while (index < expression.length() && !isOperation(expression.charAt(index))) {
            num = num * 10 + (expression.charAt(index++) - '0');
        }
        if (index == expression.length()) {
            res.add(num);
            return res;
        }
        for (int i = 0; i < expression.length(); ++i) {
            if (isOperation(expression.charAt(i))) {
                List<Integer> preList = diffWaysToCompute_by_recursion(expression.substring(0, i));
                List<Integer> postList = diffWaysToCompute_by_recursion(expression.substring(i + 1));
                for (int m = 0; m < preList.size(); ++m) {
                    for (int n = 0; n < postList.size(); ++n) {
                        int num1 = preList.get(m);
                        int num2 = postList.get(n);
                        res.add(operation(expression.charAt(i), num1, num2));
                    }
                }
            }
        }
        return res;
    }

    // 运算操作. 实际不应该存在除，避免 0/除数 .
    private int operation(char operSymbol, int first, int second) {
        switch (operSymbol) {
            case '+':
                return first + second;
            case '-':
                return first - second;
            case '*':
                return first * second;
            case '/':
                return first * second;
        }
        return -1;
    }

    // 是否是运算符.
    private boolean isOperation(char oper) {
        return (oper == '+' || oper == '-' || oper == '*' || oper == '/');
    }

}

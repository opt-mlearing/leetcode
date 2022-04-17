package leetcode.base;

import java.util.ArrayList;
import java.util.List;

/**
 * 386. 字典序排数
 * https://leetcode-cn.com/problems/lexicographical-numbers/
 */
public class Solution386 {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<Integer>();
        int num = 1;
        for (int i = 0; i < n; ++i) {
            res.add(num);
            if (num * 10 <= n) {
                num *= 10;
            } else {
                // 一直回退到最低位(个位).
                while (num + 1 > n || num % 10 == 9) {
                    num /= 10;
                }
                num++;
            }
        }
        return res;
    }

}

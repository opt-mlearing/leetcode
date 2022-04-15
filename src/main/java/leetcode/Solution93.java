package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 93. 复原 IP 地址
 * https://leetcode-cn.com/problems/restore-ip-addresses/
 */
public class Solution93 {

    private List<String> res = null;
    private static final int MAX_LIMIT = 4;

    // origin come from:
    // https://leetcode-cn.com/problems/restore-ip-addresses/solution/hui-su-suan-fa-hua-tu-fen-xi-jian-zhi-tiao-jian-by/
    // 参考上述博主做了一定程度上的代码优化.
    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<String>();
        if (s == null || s.length() < MAX_LIMIT || s.length() > 16) {
            return res;
        }
        Deque<String> deque = new ArrayDeque<String>();
        backTrack(0, s, deque);
        return res;
    }

    // 因为求全部方案，需要完全搜索，采用回溯，且考虑西下可以减枝的提前停止递归条件.
    private void backTrack(int index, String str, Deque<String> deque) {
        if (index == str.length()) {
            if (deque.size() == MAX_LIMIT) {
                // 正好到达str末尾, 且正好分为4段.
                res.add(String.join(".", deque));
            }
            return;
        }
        // 由于IP地址本质，地址从前往后必须一直有效且合法
        // 若当前位置已经可以预判不合法，那么就可以提前终止继续迭代下去（即可以减枝）.
        // 这里，着重强调下，基于当前位置可选择的行走方案，最多选后续的第1、第2、第3，理论上最多只有这三个方案. 回溯就是回这里.
        for (int i = index; i < index + 3 && i < str.length() && deque.size() < MAX_LIMIT; ++i) {
            String tmp = str.substring(index, i + 1);
            if (isValid(tmp)) {
                deque.offer(tmp);
                backTrack(i + 1, str, deque);
                deque.pollLast();
            }
        }
    }

    // 较验截断字符子串是否合法.
    private boolean isValid(String str) {
        if (str == null || str.length() == 0 || (str.length() > 1 && str.charAt(0) == '0')) {
            return false;
        }
        // 数据合法性检验.
        int num = 0;
        for (int i = 0; i < str.length(); ++i) {
            num = num * 10 + (str.charAt(i) - '0');
        }
        return num >= 0 && num <= 255;
    }

}

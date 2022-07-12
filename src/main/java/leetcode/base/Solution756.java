package leetcode.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 756. 金字塔转换矩阵
 * https://leetcode.cn/problems/pyramid-transition-matrix/
 *
 * @author caogaoli
 * @date 2022/7/12 16:22
 */
public class Solution756 {

    private Map<String, List<Character>> map;

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        map = new HashMap<String, List<Character>>();
        for (int i = 0; i < allowed.size(); ++i) {
            String key = allowed.get(i).substring(0, 2);
            List<Character> values = map.getOrDefault(key, new ArrayList<Character>());
            values.add(allowed.get(i).charAt(2));
            map.put(key, values);
        }
        return backTracking(bottom, new StringBuffer());
    }

    private boolean backTracking(String bottom, StringBuffer path) {
        if (bottom.length() == 1) {
            return true;
        }
        if (bottom.length() == path.length() + 1) {
            return backTracking(path.toString(), new StringBuffer());
        }
        int size = path.length();
        String base = bottom.substring(size, size + 2);
        for (Character item : map.getOrDefault(base, new ArrayList<Character>())) {
            path.append(item);
            if (backTracking(bottom, path)) {
                return true;
            }
            path.deleteCharAt(path.length() - 1);
        }
        return false;
    }

}

package leetcode.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 380. O(1) 时间插入、删除和获取随机元素
 * https://leetcode.cn/problems/insert-delete-getrandom-o1/submissions/
 */
public class Solution380 {

    private Map<Integer, Integer> map;
    private List<Integer> list;
    private Random random;

    public Solution380() {
        this.map = new HashMap<Integer, Integer>();
        this.list = new ArrayList<Integer>();
        this.random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int removeIndex = map.get(val);
        int lastVal = list.get(list.size() - 1);
        list.set(removeIndex, lastVal);
        list.remove(list.size() - 1);
        map.put(lastVal, removeIndex);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        // random.nextInt(num),[0, num),前闭后开.
        return list.get(random.nextInt(list.size()));
    }

}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

package leetcode.offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 剑指 Offer II 030. 插入、删除和随机访问都是 O(1) 的容器
 * https://leetcode.cn/problems/FortPu/
 */
public class SolutionOffer_II_30 {

    private Random random;
    private List<Integer> list;
    private Map<Integer, Integer> map;

    /**
     * Initialize your data structure here.
     */
    public SolutionOffer_II_30() {
        random = new Random();
        list = new ArrayList<Integer>();
        map = new HashMap<Integer, Integer>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        int size = list.size();
        map.put(val, size);
        list.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int valIndex = map.get(val);
        int lastValue = list.get(list.size() - 1);
        map.put(lastValue, valIndex);
        map.remove(val);
        list.set(valIndex, lastValue);
        list.remove(list.size() - 1);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
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

package leetcode.base;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 706. 设计哈希映射
 * https://leetcode-cn.com/problems/design-hashmap/
 */
public class Solution706 {

    private static final int NUM = 769;
    private LinkedList[] datas;

    public Solution706() {
        this.datas = new LinkedList[NUM];
        for (int i = 0; i < NUM; ++i) {
            datas[i] = new LinkedList<Pair>();
        }
    }

    // 分桶取模
    private int bucketId(int key) {
        return key % NUM;
    }

    public void put(int key, int value) {
        int id = bucketId(key);
        Iterator<Pair> iter = datas[id].iterator();
        while (iter.hasNext()) {
            Pair pair = iter.next();
            if (pair.getKey() == key) {
                pair.setValue(value);
                return;
            }
        }
        datas[id].offer(new Pair(key, value));
    }

    public int get(int key) {
        int id = bucketId(key);
        // 注意，一定要加上<Pair> 的通配符.
        Iterator<Pair> iter = datas[id].iterator();
        while (iter.hasNext()) {
            Pair pair = iter.next();
            if (pair.getKey() == key) {
                return pair.getValue();
            }
        }
        return -1;
    }

    public void remove(int key) {
        int id = bucketId(key);
        Iterator<Pair> iter = datas[id].iterator();
        while (iter.hasNext()) {
            Pair pair = iter.next();
            if (pair.getKey() == key) {
                datas[id].remove(pair);
                return;
            }
        }
    }

    private static class Pair {
        private int key;
        private int value;

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

}

package leetcode.base;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 705. 设计哈希集合
 * https://leetcode-cn.com/problems/design-hashset/
 */
public class Solution705 {

    private static final int N = 769;
    private LinkedList[] data;

    public Solution705() {
        data = new LinkedList[N];
        for (int i = 0; i < N; ++i) {
            data[i] = new LinkedList<Integer>();
        }
    }

    public void add(int key) {
        int index = hash(key);
        Iterator<Integer> iterator = data[index].iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            if (element == key) {
                return;
            }
        }
        data[index].offerLast(key);
    }

    public void remove(int key) {
        int index = hash(key);
        Iterator<Integer> iterator = data[index].iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            if (element == key) {
                data[index].remove(element);
                return;
            }
        }
    }

    public boolean contains(int key) {
        int index = hash(key);
        Iterator<Integer> iterator = data[index].iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            if (element == key) {
                return true;
            }
        }
        return false;
    }

    private static int hash(int key) {
        return key % N;
    }

}

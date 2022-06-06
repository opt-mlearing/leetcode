package leetcode.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 341. 扁平化嵌套列表迭代器
 * https://leetcode-cn.com/problems/flatten-nested-list-iterator/
 */
public class Solution341 implements Iterator<Integer> {

    private List<Integer> values;
    private Iterator<Integer> iter;

    public Solution341(List<NestedInteger> nestedList) {
        values = new ArrayList<Integer>();
        dfs(nestedList);
        iter = values.iterator();
    }

    private void dfs(List<NestedInteger> nestedList) {
        for (NestedInteger nested : nestedList) {
            if (nested.isInteger()) {
                values.add(nested.getInteger());
            } else {
                dfs(nested.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return iter.next();
    }

    @Override
    public boolean hasNext() {
        return iter.hasNext();
    }

    private interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

}
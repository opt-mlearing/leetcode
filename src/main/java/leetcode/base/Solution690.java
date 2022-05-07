package leetcode.base;

import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;

/**
 * 690. 员工的重要性
 * https://leetcode-cn.com/problems/employee-importance/
 */
public class Solution690 {

    private int res;

    // 深度优先.
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<Integer, Employee>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        res = 0;
        dfs(map, id);
        return res;
    }

    private void dfs(Map<Integer, Employee> map, int id) {
        Employee employee = map.get(id);
        res += employee.importance;
        for (int employeeId : employee.subordinates) {
            dfs(map, employeeId);
        }
    }

    // 宽度优先.
    public int getImportance_bfs(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<Integer, Employee>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        Deque<Employee> stack = new LinkedList<Employee>();
        stack.offer(map.get(id));
        int res = 0;
        // 多个领导的小属看起来并不会交叉，可以简单点.
        while (!stack.isEmpty()) {
            Employee employee = stack.poll();
            res += employee.importance;
            for (int employeeId : employee.subordinates) {
                stack.offer(map.get(employeeId));
            }
        }
        return res;
    }

    private static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

}

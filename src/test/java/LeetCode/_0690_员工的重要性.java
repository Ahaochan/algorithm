package LeetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/two-sum/
 * 题目描述:
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 解题思路
 * 语法题, 递归比用队列迭代快
 */
public class _0690_员工的重要性 {
    @Test
    public void test1() {
        List<Employee> list = Arrays.asList(
                new Employee(1, 5, 2, 3),
                new Employee(2, 3),
                new Employee(3, 3)
        );
        Assert.assertEquals(11, getImportance(list, 1));
        Assert.assertEquals(3, getImportance(list, 2));
        Assert.assertEquals(3, getImportance(list, 3));
    }

    @Test
    public void test2() {
        List<Employee> list = Arrays.asList(
                new Employee(1, 15, 2),
                new Employee(2, 10, 3),
                new Employee(3, 5)
        );
        Assert.assertEquals(30, getImportance(list, 1));
        Assert.assertEquals(15, getImportance(list, 2));
        Assert.assertEquals(5, getImportance(list, 3));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/23025969/
     * 执行用时 :9 ms, 在所有 Java 提交中击败了99.38%的用户
     * 内存消耗 :41.3 MB, 在所有 Java 提交中击败了100.00%的用户
     */
    public int getImportance(List<Employee> employees, int id) {
        map = new HashMap<>(employees.size());
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        return dfs(id);
    }
    private Map<Integer, Employee> map;
    public int dfs(int id) {
        Employee employee = map.get(id);
        int importance = employee.importance;
        for (Integer subordinate : employee.subordinates) {
            importance += dfs(subordinate);
        }
        return importance;
    }

    /**
     * https://leetcode-cn.com/submissions/detail/23011262/
     * 执行用时 :14 ms, 在所有 Java 提交中击败了77.05%的用户
     * 内存消耗 :59 MB, 在所有 Java 提交中击败了53.04%的用户
     */
    public int getImportance_queue(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>(employees.size());
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }

        Queue<Employee> queue = new ArrayDeque<>();
        queue.add(map.get(id));
        int importance = 0;
        while (queue.size() > 0) {
            Employee employee = queue.poll();
            importance += employee.importance;
            for (Integer subordinate : employee.subordinates) {
                queue.add(map.get(subordinate));
            }
        }
        return importance;
    }

    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;

        public Employee(int id, int importance, Integer... subordinates) {
            this.id = id;
            this.importance = importance;
            this.subordinates = Arrays.asList(subordinates);
        }
    };
}

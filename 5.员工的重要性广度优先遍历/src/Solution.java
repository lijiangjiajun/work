import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};


class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>();
        for (int i = 0; i < employees.size(); i++) {
            map.put(employees.get(i).id, employees.get(i));
        }
        int count = 0;
        Queue<Employee> queue = new LinkedList<>();
        queue.add(map.get(id));
        while (!queue.isEmpty()) {
            Employee employee = queue.poll();
            count += employee.importance;
            for (Integer i : employee.subordinates) {
                queue.add(map.get(i));
            }
        }
        return count;
    }
}
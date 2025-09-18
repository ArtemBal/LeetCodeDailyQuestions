package Problems;

import Problems.Entities.Pair;

import java.util.*;

public class Q3408 {
    private Comparator<Pair<Integer, Integer>> priorityComparator = (a, b) -> {
        if(!a.getKey().equals(b.getKey())) {
            return a.getKey().compareTo(b.getKey());
        }
        return a.getValue().compareTo(b.getValue());
    };
    private Map<Integer, Pair<Integer, Integer>> taskUserPriorityMap = new HashMap<>();
    private TreeSet<Pair<Integer, Integer>> priorityTaskSet = new TreeSet<>(priorityComparator);

    public Q3408(List<List<Integer>> tasks) {
        for(List<Integer> list : tasks) {
            int userId = list.get(0);
            int taskId = list.get(1);
            int priority = list.get(2);
            add(userId, taskId, priority);
        }
    }

    public void add(int userId, int taskId, int priority) {
        taskUserPriorityMap.put(taskId, new Pair<>(userId, priority));
        priorityTaskSet.add(new Pair<>(priority, taskId));
    }

    public void edit(int taskId, int newPriority) {
        Pair<Integer, Integer> curr = taskUserPriorityMap.get(taskId);
        int oldPriority = curr.getValue();
        int userId = curr.getKey();
        taskUserPriorityMap.put(taskId, new Pair<>(userId, newPriority));
        priorityTaskSet.remove(new Pair<>(oldPriority, taskId));
        priorityTaskSet.add(new Pair<>(newPriority, taskId));
    }

    public void rmv(int taskId) {
        Pair<Integer, Integer> temp = taskUserPriorityMap.remove(taskId);
        priorityTaskSet.remove(new Pair<>(temp.getValue(), taskId));
    }

    public int execTop() {
        Pair<Integer, Integer> curr = priorityTaskSet.pollLast();
        if(curr == null) {
            return -1;
        }
        int taskId = curr.getValue();
        curr = taskUserPriorityMap.remove(taskId);
        return curr.getKey();
    }
}

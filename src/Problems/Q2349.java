package Problems;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Q2349 {
    private Map<Integer, Integer> indexNum;
    private Map<Integer, TreeSet<Integer>> numIndexes;

    public Q2349() {
        indexNum = new HashMap<>();
        numIndexes = new HashMap<>();
    }

    public void change(int index, int number) {
        if(indexNum.containsKey(index)) {
            int oldNum = indexNum.get(index);
            TreeSet<Integer> temp = numIndexes.get(oldNum);
            temp.remove(index);
            if(temp.isEmpty()) {
                numIndexes.remove(oldNum);
            }
        }
        indexNum.put(index, number);
        numIndexes.computeIfAbsent(number, k -> new TreeSet<>()).add(index);
    }

    public int find(int number) {
        return numIndexes.containsKey(number) ? numIndexes.get(number).first() : -1;
    }
}

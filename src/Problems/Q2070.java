package Problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class Q2070 {
    public int[] maximumBeauty(int[][] items, int[] queries) {

        Arrays.sort(items, Comparator.comparingInt(a -> a[0]));
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 0);

        for(int[] i: items) {
            if(map.containsKey(i[0])) {
                map.put(i[0], Math.max(i[1], map.get(i[0])));
            } else {
                map.put(i[0], Math.max(i[1], map.lowerEntry(i[0]).getValue()));
            }
        }
        for(int i = 0; i < queries.length; i++) {
            if(map.containsKey(queries[i])) {
                queries[i] = map.get(queries[i]);
            } else {
                queries[i] = map.lowerEntry(queries[i]).getValue();
            }

        }

        return queries;
    }
}

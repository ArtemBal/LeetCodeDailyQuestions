package Problems;

import java.util.ArrayList;
import java.util.List;

public class Q118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>(numRows);
        ArrayList<Integer> prev = new ArrayList<>(1);
        prev.add(1);
        ans.add(prev);
        numRows--;
        while(numRows-- > 0) {
            ArrayList<Integer> next = new ArrayList<>(prev.size() + 1);
            int last = 0;
            for(int i = 0; i < prev.size(); i++) {
                int temp = prev.get(i);
                next.add(last + temp);
                last = temp;
            }
            next.add(last);
            ans.add(next);
            prev = next;
        }
        return ans;
    }
}

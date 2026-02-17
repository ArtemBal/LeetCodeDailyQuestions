package Problems;

import java.util.ArrayList;
import java.util.List;

public class Q401 {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<>();
        if(turnedOn > 8) {
            return ans;
        }
        for(int h = 0; h < 12; h++) {
            for(int m = 0; m < 60; m++) {
                if(Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(h).append(":").append(m < 10 ? "0" : "").append(m);
                    ans.add(sb.toString());
                }
            }
        }
        return ans;
    }

}

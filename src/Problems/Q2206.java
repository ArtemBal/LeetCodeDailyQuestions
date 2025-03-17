package Problems;

import java.util.BitSet;

public class Q2206 {
    public boolean divideArray(int[] nums) {
        BitSet bitSet = new BitSet(501);
        for(int i: nums) {
            bitSet.flip(i);
        }
        return bitSet.cardinality() == 0;
    }
}

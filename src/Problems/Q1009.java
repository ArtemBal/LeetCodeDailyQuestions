package Problems;

public class Q1009 {
    public int bitwiseComplement(int n) {
        int complementMask = 1;
        while (complementMask < n) {
            complementMask *= 2;
            complementMask++;
        }
        return n ^ complementMask;
    }
}

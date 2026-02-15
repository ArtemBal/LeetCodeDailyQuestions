package Problems;

public class Q67 {
    public String addBinary(String a, String b) {
        int n = a.length();
        int m = b.length();
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for(int i = 0; i < Math.max(n, m); i++) {
            int sum = carry;
            sum += n - 1 - i >= 0 ? (a.charAt(n - 1 - i) - '0') : 0;
            sum += m - 1 - i >= 0 ? (b.charAt(m - 1 - i) - '0') : 0;
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if(carry == 1) {
            sb.append('1');
        }
        return sb.reverse().toString();
    }
}

package Problems;

import java.util.HashMap;
import java.util.Map;

public class Q166 {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) {
            return "0";
        }

        Map<Long, Integer> reminders = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        boolean isNegative = (numerator > 0) ^ (denominator > 0);
        if (isNegative) {
            sb.append("-");
        }
        long dividend = Math.abs((long) numerator);
        long divisor = Math.abs((long) denominator);
        sb.append(dividend / divisor);
        if(dividend % divisor == 0) {
            return sb.toString();
        }
        sb.append(".");
        long rem = (long) dividend % divisor;
        while(rem != 0) {
            reminders.put(rem, sb.length());
            long temp = rem * 10;
            sb.append(temp / divisor);
            rem = temp % divisor;
            if(reminders.containsKey(rem)) {
                int start = reminders.get(rem);
                sb.insert(start, "(");
                sb.append(")");
                break;
            }
        }
        return sb.toString();
    }
}

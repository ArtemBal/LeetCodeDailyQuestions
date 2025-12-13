package Problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Q3606 {
    public enum Business {
        electronics, grocery, pharmacy, restaurant
    }

    public record Coupon(String code, Business business) {

        @Override
            public String toString() {
                return code + " (" + business + ")";
            }
        }
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<Coupon> coupons = new ArrayList<>();
        for(int i = 0; i < code.length; i++) {
            if(checkBusiness(businessLine[i]) && checkId(code[i]) && isActive[i]) {
                coupons.add(new Coupon(code[i], Business.valueOf(businessLine[i])));
            }
        }
        coupons.sort(Comparator.comparing(Coupon::business).thenComparing(Coupon::code));
        return coupons.stream().map(Coupon::code).collect(Collectors.toList());
    }

    public static boolean checkBusiness(String v) {
        for (Business b : Business.values()) {
            if (b.name().equals(v)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkId(String val) {
        for(var c : val.toCharArray())
        {
            if(!Character.isDigit(c) && !Character.isLetter(c) && c != '_')
                return false;
        }
        return !val.isEmpty();
    }
}

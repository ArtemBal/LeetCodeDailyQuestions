package Problems;

import java.util.ArrayList;
import java.util.List;

public class Q1352 {
    ArrayList<Integer> product;

    public Q1352() {
        product = new ArrayList<>();
        product.add(1);
    }

    public void add(int num) {
        if(num == 0) {
            product.clear();
            product.add(1);
        } else {
            product.add(product.get(product.size() - 1) * num);
        }
    }

    public int getProduct(int k) {
        int n = product.size();
        if(n <= k) {
            return 0;
        } else {
            return product.get(n - 1) / product.get(n - k - 1);
        }
    }
}

package Problems;

import java.util.*;

public class Q1912 {
    //movie -> price shop
    private Map<Integer, TreeSet<int[]>> unrented;
    //price shop movie
    private TreeSet<int[]> rented;
    private Map<String, Integer> shopMovieToPrice;

    public Q1912(int n, int[][] entries) {
        unrented = new HashMap<>(entries.length);
        shopMovieToPrice = new HashMap<>(entries.length);

        Comparator<int[]> unrentedComparator = (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        };
        Comparator<int[]> rentedComparator = (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[2], b[2]);
        };
        rented = new TreeSet<>(rentedComparator);
        for(int[] arr: entries) {
            int shop = arr[0];
            int movie = arr[1];
            int price = arr[2];
            unrented.computeIfAbsent(movie, k -> new TreeSet<>(unrentedComparator)).add(new int[]{price, shop});
            shopMovieToPrice.put(shop + "," + movie, price);
        }
    }

    public List<Integer> search(int movie) {
        List<Integer> result = new ArrayList<>();

        if (!unrented.containsKey(movie)) {
            return result;
        }

        int count = 0;
        for (int[] entry : unrented.get(movie)) {
            if (count >= 5) break;
            result.add(entry[1]);
            count++;
        }

        return result;

    }

    public void rent(int shop, int movie) {
        int price = shopMovieToPrice.get(shop + "," + movie);
        unrented.get(movie).remove(new int[]{price, shop});
        rented.add(new int[]{price, shop, movie});
    }

    public void drop(int shop, int movie) {
        int price = shopMovieToPrice.get(shop + "," + movie);
        unrented.get(movie).add(new int[]{price, shop});
        rented.remove(new int[]{price, shop, movie});
    }

    public List<List<Integer>> report() {
        List<List<Integer>> result = new ArrayList<>();

        for (int[] entry : rented) {
            if (result.size() >= 5) break;
            result.add(Arrays.asList(entry[1], entry[2]));
        }
        return result;
    }
}

package Problems;


import Problems.Entities.Pair;

import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeSet;

public class Q2353 {
    private final HashMap<String, Pair<Integer, String>> foodCuisineMap = new HashMap<>();
    private final HashMap<String, TreeSet<Pair<Integer, String>>> highestRateMap = new HashMap<>();

    private final Comparator<Pair<Integer, String>> foodComparator = (a, b) -> {
        if(!a.getKey().equals(b.getKey())) {
            return a.getKey().compareTo(b.getKey());
        }
        return b.getValue().compareTo(a.getValue());
    };

    public Q2353(String[] foods, String[] cuisines, int[] ratings) {
        for(int i = 0; i < foods.length; i++) {
            foodCuisineMap.put(foods[i], new Pair<>(ratings[i], cuisines[i]));
            highestRateMap.computeIfAbsent(cuisines[i], v -> new TreeSet<>(foodComparator))
                    .add(new Pair<>(ratings[i], foods[i]));
        }
    }

    public void changeRating(String food, int newRating) {
        Pair<Integer, String> curr = foodCuisineMap.get(food);
        String cuisine = curr.getValue();
        int oldRate = curr.getKey();
        foodCuisineMap.put(food, new Pair<>(newRating, cuisine));
        highestRateMap.get(cuisine).remove(new Pair<>(oldRate, food));
        highestRateMap.get(cuisine).add(new Pair<>(newRating, food));
    }

    public String highestRated(String cuisine) {
        return highestRateMap.get(cuisine).last().getValue();
    }
}

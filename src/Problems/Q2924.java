package Problems;

public class Q2924 {
    public int findChampion(int n, int[][] edges) {
        int[] count = new int[n];
        for(int[] arr: edges) {
            count[arr[1]]++;
        }
        int zeroCount = 0;
        int zeroTeam = -1;
        for(int i = 0; i < count.length; i++) {
            if(count[i] == 0) {
                zeroCount++;
                zeroTeam = i;
            }
        }
        return zeroCount == 1 ? zeroTeam : -1;
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FruitBaskets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ct = 0;
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
            if (weights[i] >= 200) ct += weights[i];
        }
        System.out.println(Arrays.toString(weights));

        // Since each kind of fruit weighs at least 50 grams,
        // for combinations of 4 or more fruits, we just count them all

    }

    private static ArrayList<int[]> combinations(int start, int end, int n, int k) {
        ArrayList<int[]> arr = new ArrayList<>();
        if (k == 1) {
            for (int i = start; i < end; i++) {
                arr.add(new int[]{i});
            }
            return arr;
        }
        for (int[] comb: combinations(start+1, end, n-1, k-1)) {

        }
        return arr;
    }

}

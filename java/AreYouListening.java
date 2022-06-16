import java.util.Arrays;
import java.util.Scanner;

public class AreYouListening {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cx = sc.nextInt();
        int cy = sc.nextInt();
        int n = sc.nextInt();
        double[] dists = new double[n];

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int r = sc.nextInt();
            double distance = dist(cx, cy, x, y) - r;
            dists[i] = distance;
        }

        Arrays.sort(dists);

        System.out.println(Math.max(0, (int)dists[2]));
    }

    private static double dist(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
    }
}

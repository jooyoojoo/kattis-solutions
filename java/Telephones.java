import java.util.Scanner;

public class Telephones {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String[] nums = sc.nextLine().split(" ");
            int n = Integer.parseInt(nums[0]);
            int m = Integer.parseInt(nums[1]);
            if (n == 0 && m == 0) break;

            int[][] calls = new int[n][2];

            // enter phone calls
            for (int i = 0; i < n; i++) {
                String[] ints = sc.nextLine().split(" ");
                calls[i][0] = Integer.parseInt(ints[2]);
                calls[i][1] = Integer.parseInt(ints[3]) + calls[i][0];
            }

            for (int i = 0; i < m; i++) {
                // enter intervals to check
                String[] ints = sc.nextLine().split(" ");
                int s = Integer.parseInt(ints[0]);
                int e = Integer.parseInt(ints[1]) + s;

                // for each call, check if it intersects with that interval
                int ct = 0;
                for (int j = 0; j < n; j++) {
                    if (intersects(calls[j][0], calls[j][1], s, e)) {
                        ct++;
                    }
                }

                System.out.println(ct);
            }
        }
        sc.close();
    }

    private static boolean intersects(int s1, int e1, int s2, int e2) {
        return s1 < e2 && s2 < e1;
    }
}

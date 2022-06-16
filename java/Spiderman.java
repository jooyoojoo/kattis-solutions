import java.util.Arrays;
import java.util.Scanner;

public class Spiderman {
    private static int[] ds;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ct = sc.nextInt();
        for (int i = 0; i < ct; i++) {
            int num = sc.nextInt();
            ds = new int[num];
            for (int j = 0; j < num; j++) {
                ds[j] = sc.nextInt();
            }
            int max = max(ds);
            int index = 0;
            int height = 0;

            while (index < ds.length) {

            }

        }
    }

    private static int max(int[] a) {
        int m = a[0];
        for (int i = 1; i < a.length; i++) {
            if (m < a[i]) {
                m = a[i];
            }
        }
        return m;
    }

    private static boolean works(int height) {
        return true;
    }
}

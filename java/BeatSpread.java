import java.util.Scanner;

public class BeatSpread {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ct = sc.nextInt();

        for (int i = 0; i < ct; i++) {
            int s = sc.nextInt();
            int d = sc.nextInt();

            if (isEven(s) != isEven(d) || s < d) {
                System.out.println("impossible");
            } else {
                int bigger = (s+d)/2;
                int smaller = s - bigger;
                System.out.println(bigger + " " + smaller);
            }
        }
    }

    private static boolean isEven(int x) {
        return x % 2 == 0;
    }
}

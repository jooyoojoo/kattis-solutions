import java.util.Scanner;

public class EuclidsGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a == 0 && b == 0) break;

            boolean stanWins = true;
            while (true) {
                // set a to be the larger number, b the smaller number
                int c = a;
                a = Math.max(a,b);
                b = Math.min(c,b);

                // 1. if a % b == 0, Stan can go to 0 directly
                // 2. if a - b > b, there is leeway to make himself win at the final stage
                if (a % b == 0 || a - b > b) {
                    break;
                }
                // subtract and N- and P- positions take turns
                a -= b;
                stanWins = !stanWins;
            }

            if (stanWins) {
                System.out.println("Stan wins");
            } else {
                System.out.println("Ollie wins");
            }
        }


    }
}

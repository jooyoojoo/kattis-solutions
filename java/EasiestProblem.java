import java.util.Scanner;

public class EasiestProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int n = sc.nextInt();
            if (n == 0) break;

            int p = 11;
            int sumN = sumOfDigits(n);

            while (true) {
                if (sumN == sumOfDigits(n * p)) {
                    System.out.println(p);
                    break;
                }
                p++;
            }
        }
    }

    private static int sumOfDigits(int n) {
        String[] digits = String.valueOf(n).split("");
        int sum = 0;
        for (String digit: digits) {
            sum += Integer.parseInt(digit);
        }
        return sum;
    }
}

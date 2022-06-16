import java.util.Scanner;

public class PeriodicStrings {
    private static String s;
    private static int len;

    public static void main(String[] args) {
        // takes in the string
        Scanner sc = new Scanner(System.in);
        s = sc.nextLine();
        len = s.length();
        // for each possible k value, check if k-periodic property holds
        for (int k = 1; k < len; k++) {
            if (isPeriodic(k)) {
                System.out.println(k);
                System.exit(0);
            }
        }
        System.out.println(len);
    }

    private static boolean isPeriodic(int k) {
        if (len % k != 0) return false;
        // for each of the k-substring, check if it is the same as the previous one except
        // with its last char moved to the front
        for (int j = k; j < len; j += k) {
            String sub = s.substring(j, j+k);
            String should_be = s.charAt(j-1) + s.substring(j-k, j);
            should_be = should_be.substring(0, k);
            if (!sub.equals(should_be)) return false;
        }
        return true;
    }
}

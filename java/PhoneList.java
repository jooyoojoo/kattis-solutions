import java.util.Arrays;
import java.util.Scanner;

public class PhoneList {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < cases; i++) {
            int n = Integer.parseInt(sc.nextLine());
            String[] numbers = new String[n];
            for (int j = 0; j < n; j++) {
                numbers[j] = sc.nextLine();
            }
            // We sort the numbers because the strings will then be ordered by their prefix.
            // If a phone number does not start with the previous one, the next phone number
            // would not start with that one either, so we only need to compare every two
            // neighboring numbers.
            // e.g. in {911, 9120, 91200}, since 9120 already starts with something greater
            // than 911, the next one 91200, which has a bigger prefix, will not start with 911 either.
            Arrays.sort(numbers);

            if (isConsistent(n, numbers)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean isConsistent(int n, String[] numbers) {
        // determine if the numbers are consistent according to the definition
        for (int k = 0; k < n-1; k++) {
            if (numbers[k+1].startsWith(numbers[k])) {
                return false;
            }
        }
        return true;
    }
}

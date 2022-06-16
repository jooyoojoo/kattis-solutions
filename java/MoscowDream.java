import java.util.Scanner;

public class MoscowDream {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] problems = new int[3];
        int sum = 0;

        for (int i = 0; i < 3; i++) {
            problems[i] = sc.nextInt();
            sum += problems[i];
        }
        int n = sc.nextInt();

        if (sum < n || n < 3) {
            System.out.println("NO");
            System.exit(0);
        }

        for (int i=0; i<problems.length; i++) {
            if (problems[i] == 0) {
                System.out.println("NO");
                System.exit(0);
            }
        }

        System.out.println("YES");
    }
}

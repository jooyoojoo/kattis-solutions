import java.util.Scanner;

public class Guess {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int low = 1;
        int high = 1000;
        int num = 500;
        System.out.println(num);
        while (true) {
            String r = sc.nextLine();
            if (r.equals("correct")) {
                break;
            } else if (r.equals("higher")) {
                low = num;
                num = (low + high + 1) / 2;
                System.out.println(num);
            } else {
                high = num;
                num = (high + low) / 2;
                System.out.println(num);
            }
        }
    }
}

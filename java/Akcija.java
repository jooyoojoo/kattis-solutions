import java.util.Arrays;
import java.util.Scanner;

public class Akcija {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ct = sc.nextInt();
        int sum = 0;
        int[] books = new int[ct];
        for (int i = 0; i < ct; i++) {
            books[i] = sc.nextInt();
            sum += books[i];
        }

        Arrays.sort(books);

        for (int i = books.length-3; i >= 0; i -= 3) {
            sum -= books[i];
        }

        System.out.println(sum);
    }
}

import java.util.Scanner;

public class SodaSlurper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int bottles = sc.nextInt() + sc.nextInt();
        int cost = sc.nextInt();
        int soda = 0;

        while (bottles >= cost) {
            soda += bottles / cost;
            bottles = bottles % cost + bottles / cost;
        }
        System.out.println(soda);
    }
}

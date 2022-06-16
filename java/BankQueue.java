import java.util.*;

public class BankQueue {
    private static class Person {
        int amt;
        int time;

        Person(int pAmt, int pTime) {
            amt = pAmt;
            time = pTime;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        ArrayList<Person> people = new ArrayList<>();
        int[] serving = new int[t];

        // record all people
        for (int i = 0; i < n; i++) {
            people.add(new Person(sc.nextInt(), sc.nextInt()));
        }

        // sort people based on amount of money in descending order
        Collections.sort(people, Comparator.comparingInt(o -> o.amt));
        Collections.reverse(people);

        // serve the person with by far the largest amount of money on the latest possible time slot
        for (Person p: people) {
            int ddl = p.time;
            while (ddl >= 0) {
                if (serving[ddl] == 0) {
                    serving[ddl] = p.amt;
                    break;
                }
                ddl--;
            }
        }

        // add up the amount of money
        int sum = 0;
        for (int i = 0; i < t; i++) {
            sum += serving[i];
        }
        System.out.println(sum);
    }
}

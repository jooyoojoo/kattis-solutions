import java.util.Scanner;

public class IRepeatMyself {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ct = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < ct; i++) {
            String s = sc.nextLine();
            int len = s.length();

            for (int j = 1; j <= len; j++) {
                if (s.equals(s.substring(0, j).repeat(len / j + 1).substring(0, len))) {
                    System.out.println(j);
                    break;
                }
            }
        }
        sc.close();
    }
}

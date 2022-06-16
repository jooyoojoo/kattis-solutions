import java.util.HashMap;
import java.util.Scanner;

public class Peragrams {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.replace(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        int ct = 0;
        for (int k: map.values()) {
            if (k % 2 != 0) {
                ct++;
            }
        }

        if (ct == 0) {
            System.out.println(ct);
        } else {
            System.out.println(--ct);
        }
    }
}

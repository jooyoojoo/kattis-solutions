import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class ColoringSocks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int c = sc.nextInt();
        int k = sc.nextInt();
        int num = 1;

        LinkedList<Integer> colors = new LinkedList<>();
        for (int i = 0; i < s; i++) {
            colors.add(sc.nextInt());
        }

        Collections.sort(colors);

        int ct = 1;
        int min = colors.get(0);
        colors.remove(0);
        for (int color: colors) {
            if (ct >= c) {
                ct = 0;
                min = color;
                num++;
            }
            if (color - min > k) {
                ct = 0;
                min = color;
                num++;
            }
            ct++;
        }

        System.out.println(num);
    }
}

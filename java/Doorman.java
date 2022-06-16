import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Doorman {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ct = sc.nextInt();
        sc.nextLine();
        String[] input = sc.nextLine().split("");
        LinkedList<String> ppl = new LinkedList<>(Arrays.asList(input));

        // MAN+1, WOMAN-1
        int diff = 0;
        int in = 0;

        while (!ppl.isEmpty() && diff <= ct) {
            String cur = ppl.getFirst();

            if (diff == 0) {
                // anyone is okay
                in++;
                ppl.removeFirst();
                if (cur.equals("M")) {
                    diff++;
                } else {
                    diff--;
                }
            } else if (diff < 0) {
                // have more woman, need man
                int nextM = ppl.indexOf("M");
                if (nextM == -1) {
                    in += Math.min(ct + diff, ppl.size());
                    break;
                } else if (nextM <= ct){
                    diff++;
                    in++;
                    ppl.remove(nextM);
                } else {
                    in += ct + diff;
                    break;
                }
            } else {
                // have more man, need woman
                int nextW = ppl.indexOf("W");
                if (nextW == -1) {
                    // no more woman
                    in += Math.min(ct - diff, ppl.size());
                    break;
                } else if (nextW <= ct) {
                    diff--;
                    in++;
                    ppl.remove(nextW);
                } else {
                    in += ct - diff;
                    break;
                }
            }
        }

        System.out.println(in);
    }
}

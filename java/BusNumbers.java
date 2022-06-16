import java.util.Arrays;
import java.util.Scanner;

public class BusNumbers {
    public static void main(String[] args) {
        // take in inputs and get the int array of bus numbers
        Scanner sc = new Scanner(System.in);
        int ct = sc.nextInt();
        int[] busNumbers = new int[ct];
        for (int i = 0; i < ct; i++) {
            busNumbers[i] = sc.nextInt();
        }

        Arrays.sort(busNumbers);
        String output = "";

        // go through array of bus numbers
        for (int i = 0; i < ct; i++) {
            // specify a start and end among a series of numbers
            int start = busNumbers[i];
            int end = busNumbers[i];
            i++;

            // find a set of continuous numbers
            while (i < ct) {
                if (busNumbers[i] != busNumbers[i-1] + 1) break;
                end = busNumbers[i];
                i++;
            }
            i--;

            if (end - start == 1) {
                output += " " + start + " " + end; // two consecutive numbers are not shortened
            } else if (end - start > 1) {
                output += " " + start + "-" + end; // three or more consecutive numbers are represented using hyphen
            } else {
                output += " " + start; // one independent number appears by itself
            }
        }
        System.out.println(output.substring(1));
    }
}

import java.util.Scanner;

public class DVDs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ct = sc.nextInt();
        for (int i=0;i<ct;i++) {
            int n = sc.nextInt();
            sc.nextLine();
            String[] nums = sc.nextLine().split(" ");


            int unordered = 0;
            int num = 1;
            for (int j=0;j<n;j++) {
                if (Integer.valueOf(nums[j]) == num) {
                    num++;
                } else {
                    unordered++;
                }
            }
            System.out.println(unordered);
        }
    }
}

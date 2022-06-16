import java.util.*;

public class BasicProgramming2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] next = sc.nextLine().split(" ");
        int n = Integer.parseInt(next[0]);
        int t = Integer.parseInt(next[1]);
        next = sc.nextLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0 ; i < n; i++) {
            arr[i] = Integer.parseInt(next[i]);
        }

        if (t == 1) {
            for (int i = 0 ; i < n; i++) {
                if (arr[i] < 7777) {
                    for (int j = 0; j < n; j++) {
                        if (arr[i] != arr[j] && arr[i] + arr[j] == 7777) {
                            System.out.println("Yes");
                            System.exit(0);
                        }
                    }
                }
            }
            System.out.println("No");
        } else if (t == 2) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0 ; i < n; i++) {
                if (map.containsKey(arr[i])) {
                    System.out.println("Contains duplicate");
                    System.exit(0);
                } else {
                    map.put(arr[i], 1);
                }
            }
            System.out.println("Unique");
        } else if (t == 3) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i: arr) {
                map.put(i, map.getOrDefault(i, 0) + 1);
                if (map.get(i) > n/2) {
                    System.out.println(i);
                    System.exit(0);
                }
            }
            System.out.println(-1);
        } else if (t == 4) {
            Arrays.sort(arr);
            if (n % 2 == 1) {
                System.out.println(arr[n/2]);
            } else {
                System.out.println(arr[n/2-1] + " " + arr[n/2]);
            }
        } else if (t == 5) {
            ArrayList<String> newArr = new ArrayList<>();
            for (int i = 0 ; i < n; i++) {
                if (arr[i] >= 100 && arr[i] <= 999) {
                    newArr.add(String.valueOf(arr[i]));
                }
            }
            Collections.sort(newArr);
            System.out.println(String.join(" ", newArr));
        }
    }
}

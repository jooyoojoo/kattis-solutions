import java.util.HashMap;
import java.util.Scanner;

public class DeduplicatingFiles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int num = Integer.parseInt(sc.nextLine());
            if (num == 0) break;

            // create a hashmap to count the number of each unique file
            HashMap<String, Integer> countTable = new HashMap<>();
            // create a hashmap to count the number of each hash code
            HashMap<Character, Integer> hashNums = new HashMap<>();
            int unique = 0;
            int collision = 0;
            for (int i = 0; i < num; i++) {
                String file = sc.nextLine();
                char hash = hashFunction(file);
                // case 1: unique file, unique hash code
                if (hashNums.get(hash) == null) {
                    countTable.put(file, 1);
                    hashNums.put(hash, 1);
                    unique++;
                } else {
                    // case 2: unique file, duplicate hash code - must have a collision
                    if (countTable.get(file) == null) {
                        collision += hashNums.get(hash);
                        countTable.put(file, 1);
                        unique++;
                    } else {
                        // case 3: duplicate file, duplicate hash code - might have a collision
                        collision += hashNums.get(hash) - countTable.get(file);
                        countTable.replace(file, countTable.get(file) + 1);
                    }
                    hashNums.replace(hash, hashNums.get(hash) + 1);
                }
            }

            System.out.println(unique + " " + collision);
        }
    }

    private static char hashFunction(String file) {
        char result = '0';
        for (int i = 0; i < file.length(); i++) {
            result ^= file.charAt(i);
        }
        return result;
    }
}

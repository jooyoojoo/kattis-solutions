import java.util.Scanner;

public class NarrowArtGallery {
    // I will use a top-down approach
    static int[][] rooms;
    static int[][][] M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int N = sc.nextInt();
            int k = sc.nextInt();
            if (N == 0 && k == 0) break;
            rooms = new int[N][2];
            int total = 0;

            // fill memoization table with -1's (to indicate "not computed")
            M = new int[k+1][N][2];
            for (int i = 0; i <= k; i++){
                for (int j = 0; j < N; j++){
                    M[i][j][0] = -1;
                    M[i][j][1] = -1;
                }
            }

            // build the values for each gallery room
            for (int i = 0; i < N; i++) {
                rooms[i][0] = sc.nextInt();
                rooms[i][1] = sc.nextInt();
                total += rooms[i][0] + rooms[i][1];
            }

            // get the value of closed rooms
            int closed = Math.min(rec(k, N-1, 0), rec(k, N-1, 1));
            System.out.println(total - closed);
        }
    }

    private static int rec(int k, int row, int col) {
        if (k == 0) {
            return 0; // If there is no door we need to close, the removed value will be zero
        } else if (row == -1) {
            // Since the max value is 100, we can treat 101 as infinity
            // For some reason, Kattis test cases does not seem to obey this rule, so I will instead use 999999
            return 999999;
        } else if (M[k][row][col] != -1){
            return M[k][row][col]; // If the value is already memoized, retrieve it
        } else {
            // There are three cases, we will choose the minimum of the removed values:
            // 1. Close a door in the current row. Close the door on the same side for the next row.
            // 2. Close no door in the current row. For the next row:
            //      1) Try (because we may not eventually choose so) closing the left door.
            //      2) Try closing the right door.
            M[k][row][col] = Math.min(Math.min(
                    rec(k-1, row-1, col) + rooms[row][col],
                    rec(k, row-1, col)), rec(k, row-1, col^1));
        }
        return M[k][row][col];
    }
}



public class Template {
    public static void main(String[] args) {
        String a = "aabaa";
        int[] cost = {1,2,3,4,5};

        System.out.println(minCost(a, cost));


    }

    public static int minCost(String s, int[] cost) {
        int ct = 0;
        int max = 0;
        for (int i = 1; i < cost.length; i++) {
            if (s.charAt(max) == s.charAt(i)) {
                ct += Math.min(cost[max], cost[i]);
                if (cost[max] < cost[i]) max = i;
            } else {
                max = i;
            }
        }
        return ct;
    }


}

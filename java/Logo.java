import java.util.Scanner;

public class Logo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < cases; i++) {
            int ct = Integer.parseInt(sc.nextLine());
            double x = 0;
            double y = 0;
            int angle = 0;

            for (int j = 0; j < ct; j++) {
                String[] line = sc.nextLine().split(" ");
                int magnitude = Integer.parseInt(line[1]);
                if (line[0].equals("fd")) {
                    // calculate new x and y coordinates
                    x += magnitude * Math.cos(Math.toRadians(angle));
                    y += magnitude * Math.sin(Math.toRadians(angle));
                } else if (line[0].equals("bk")) {
                    x -= magnitude * Math.cos(Math.toRadians(angle));
                    y -= magnitude * Math.sin(Math.toRadians(angle));
                } else if (line[0].equals("lt")) {
                    // update current angle
                    angle += magnitude;
                } else if (line[0].equals("rt")) {
                    angle -= magnitude;
                }
            }

            // calculate distance to the origin
            System.out.println(Math.round(Math.sqrt(x*x + y*y)));
        }


    }
}

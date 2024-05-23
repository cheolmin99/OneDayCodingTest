import java.util.*;

public class test9366_fail {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();

        String[] results = new String[T];

        for(int i = 0; i < T; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            if (a + b <= c || a + c <= b || b + c <= a) {
                results[i] = "invalid!";
            } else if (a == b && b == c) {
                results[i] = "equilateral";
            } else if (a == b || b == c || a == c) {
                results[i] = "isosceles";
            } else {
                results[i] = "scalene";
            }
        }
        sc.close();

        for (String result : results) {
            System.out.println(result);
        }
    }
}

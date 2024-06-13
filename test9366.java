import java.util.Scanner;

public class test9366 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();  // 테스트 케이스의 수

        int[][] triangles = new int[t][3];
        for (int i = 0; i < t; i++) {
            triangles[i][0] = sc.nextInt();
            triangles[i][1] = sc.nextInt();
            triangles[i][2] = sc.nextInt();
        }

        for (int i = 0; i < t; i++) {
            System.out.println("Case #" + (i + 1) + ": " + classifyTriangle(triangles[i][0], triangles[i][1], triangles[i][2]));
        }

        sc.close();
    }

    public static String classifyTriangle(int a, int b, int c) {
        if (a + b <= c || a + c <= b || b + c <= a) {
            return "invalid!";
        } else if (a == b && b == c) {
            return "equilateral";
        } else if (a == b || b == c || a == c) {
            return "isosceles";
        } else {
            return "scalene";
        }
    }
}
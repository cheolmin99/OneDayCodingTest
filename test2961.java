import java.util.Scanner;

public class test2961 {
    static int n;
    static int[][] taste;
    static int min = Integer.MAX_VALUE;
    private static void backtrack(int index, int sour, int bitter, int count) {
        if (index == n) {
            if (count > 0) {
                min = Math.min(min, Math.abs(sour - bitter));
            }
            return;
        }

        backtrack(index + 1, sour, bitter, count);

        backtrack(index + 1, sour * taste[index][0], bitter + taste[index][1], count + 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        taste = new int[n][2];

        for (int i = 0; i < n; i++) {
            taste[i][0] = sc.nextInt(); // 신맛
            taste[i][1] = sc.nextInt(); // 쓴맛
        }

        backtrack(0, 1, 0, 0);
        System.out.println(min);
    }
}

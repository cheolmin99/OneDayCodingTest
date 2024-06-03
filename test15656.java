import java.util.*;

public class test15656 {
    static int n, m;
    static int[] input, select;
    static StringBuilder sb = new StringBuilder();

    public static void permutations(int next) {
        if (next == m) {
            for (int i : select) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
                select[next] = input[i]; 
                permutations(next + 1); 
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        input = new int[n];
        select = new int[m];

        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }

        Arrays.sort(input);

        permutations(0);

        System.out.println(sb.toString());
    }
}
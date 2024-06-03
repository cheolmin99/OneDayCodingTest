import java.util.*;

public class test15663 {
    static int n, m;
    static int[] input, select, used;
    static StringBuilder sb = new StringBuilder();

    public static void permutation(int next) {
        if (next == m) {
            for (int i : select) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        int prevent = -1;
        for (int i = 0; i < n; i++) {
            if(used[i] == 0 && input[i] != prevent) {
                select[next] = input[i]; 
                used[i] = 1;
                prevent = input[i];
                permutation(next + 1);
                used[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        input = new int[n];
        select = new int[m];
        used = new int[n];

        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }

        Arrays.sort(input);

        permutation(0);

        System.out.println(sb.toString());
    }
}

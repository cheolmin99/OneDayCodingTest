import java.util.*;

public class test15664 {
    static int n, m;
    static int[] input, select, used;
    static StringBuilder sb = new StringBuilder();

    public static void combination(int dep, int idx) {
        if (dep == m) {
            for (int i : select) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        int prevent = -1;
        for (int i = idx + 1; i < n; i++) {
            if(used[i] == 0 && input[i] != prevent) {
                select[dep] = input[i]; 
                used[i] = 1;
                prevent = input[i];
                combination(dep + 1, i);
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

        combination(0, -1);

        System.out.println(sb.toString());
    }
}

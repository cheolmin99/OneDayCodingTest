import java.util.*;

public class test15657 {
    static int n, m;
    static int[] input, select;
    static StringBuilder sb = new StringBuilder();

    public static void combination(int next, int idx) {
        if (next == m) {
            for (int i : select) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = idx; i < n; i++) {
                select[next] = input[i]; 
                combination(next + 1, i); 
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

        combination(0, 0);

        System.out.println(sb.toString());
    }
}
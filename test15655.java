import java.util.*;

public class test15655 {
    static int n, m;
    static int[] input, select, used;
    static StringBuilder sb = new StringBuilder();

    public static void combination(int next, int idx) {
        if (next == m) {
            for (int i : select) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = idx + 1; i < n; i++) {
            if (used[i] == 0) { 
                select[next] = input[i]; 
                used[i] = 1; 
                combination(next + 1, i); 
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
        //사전순 => (요소들이 정렬이 되면 나열할 수 있는 모든 경우의 수대로 출력)
        Arrays.sort(input);

        combination(0, -1);

        System.out.println(sb.toString());
    }
}
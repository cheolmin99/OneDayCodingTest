import java.util.*;

public class test15652 {
    static int n,m;
    static int[] ans;
    static StringBuilder sb = new StringBuilder();

    //조합은 앞의 수를 선택한 뒤 앞의 수 보다 큰 수를 선택해야 한다.
    public static void combination(int idx, int len) {
        if(len == m) {
            for(int i:ans) sb.append(i + " ");
            sb.append("\n");
            return;
        }
        for(int i = idx; i <= n; i++) {
            ans[len] = i;
            combination(i, len + 1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        ans = new int[m];

        combination(1, 0);
        System.out.println(sb.toString());
    }
}

import java.util.*;

public class test15651 {
    static int n,m;
    static int[] ans;
    static StringBuilder sb = new StringBuilder();
    public static void permutations(int len) {
        if(len == m) {
            for(int i:ans) sb.append(i + " ");
            sb.append("\n");
            return;
        }
        for(int i = 1; i <= n; i++) {
                ans[len] = i;
                permutations(len + 1); //그 다음 숫자를 선택
            }
        }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        ans = new int[m];

        permutations(0);
        //모든 수열의 문자열을 출력
        System.out.println(sb.toString());
    }
}

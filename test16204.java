import java.util.*;

public class test16204 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] strs = sc.nextLine().split(" ");

        int N = Integer.parseInt(strs[0]);
        int M = Integer.parseInt(strs[1]);
        int K = Integer.parseInt(strs[2]);

        int maxO = Math.min(M, K);
        int maxX = Math.min(N - M, N - K);

        int result = maxO + maxX;
        System.out.println(result);

    }
}
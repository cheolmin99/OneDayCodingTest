import java.util.*;

public class test10819 {
    static int n, m;
    static int[] input, select, used;
    static int ans = Integer.MIN_VALUE;

    public static int cal(){
        //|A[0] - A[1]| + |A[1] - A[2]| + ... + |A[N-2] - A[N-1]|
        int total = 0;
        for(int i=1; i<n; i++){
            total += Math.abs(select[i-1] - select[i]);
        }
        return total;
    }

    public static void permutation(int next) {
        if (next == n) {
            //select: 15 1 20 8 10 4
            //모든 순열에 대해서 식을 계산한 결과값 중 최대값을 계산
            ans = Math.max(ans, cal());
            return;
        }
        for (int i = 0; i < n; i++) {
            if (used[i] == 0) {
                select[next] = input[i];
                used[i] = 1;
                permutation(next + 1);
                used[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        input = new int[n];
        select = new int[n]; //나열한 순서
        used = new int[n]; //숫자를 사용한 여부

        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt(); //20 1 15 8 4 10
        }
        permutation(0);
                System.out.println(ans);
    }
}
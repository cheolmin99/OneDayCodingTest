import java.util.*;

public class test14501 {
    public static int N;
    public static int[] T;
    public static int[] P;
    public static int maxReslut = 0;

    public static void advice(int time, int pay) {
        if(time == N) {
            maxReslut = Math.max(maxReslut, pay);
            return;
        }
        if(time + T[time] <= N) {
            advice(time + T[time], pay + P[time]);
        }
        advice(time + 1, pay);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        T = new int[N];
        P = new int[N];

        for(int i = 0; i < N; i++) {
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }
        advice(0, 0);
        
        System.out.println(maxReslut);
    }
    
}
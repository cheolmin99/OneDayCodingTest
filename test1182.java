import java.util.*;

public class test1182 {
    public static int S;
    public static int N;
    public static int I[];
    static int result; 
    public static void pl(int total, int index) {
        if(index == N) {
            if(total == S) {
                result++;
            }
            return;
        }
        pl(total + I[index], index + 1);
        //모든 원소를 선택하지 않는 경우의 수는 제외시켜야 한다.
        pl(total, index + 1);
    }
    public static void main(String[] args) {
    //예외 함수 다 짜고 고려
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        I = new int[N];
        for(int i = 0; i < N; i++) {
            I[i] = sc.nextInt();
        }

        pl(0, 0);
        
        if(S == 0) {
            result--;
        }
        
        System.out.println(result);
    }
}

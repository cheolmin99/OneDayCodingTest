import java.util.*;

public class test5532 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int L = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int D = sc.nextInt();
        sc.close();

        int kor = 0;
        int math = 0;

        if(A % C == 0) {
            kor = L - (A / C);
        } else {
            kor = L - (A / C + 1);
        }

        if(B % D == 0) {
            math = L - (B / D);
        }else {
            math = L - (B / D + 1);
        }
        
        System.out.println(Math.min(kor, math));
    }
}

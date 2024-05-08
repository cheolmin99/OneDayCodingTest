import java.util.Scanner;

public class test14697 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] strs = sc.nextLine().split(" ");

        int A = Integer.parseInt(strs[0]); 
        int B = Integer.parseInt(strs[1]);
        int C = Integer.parseInt(strs[2]);
        int N = Integer.parseInt(strs[3]);

        int result = 0;
        for (int i = 0; i <= (N / A); i++) {
            for (int j = 0; j <= (N / B); j++) {
                for (int k = 0; k <= (N / C); k++) {
                    if ((A * i) + (B * j) + (C * k) == N) {
                        result = 1;
                        break;
                    }
                }
                if (result == 1) {
                    break;
                }
            }
            if (result == 1) {
                break;
            }
        }

        System.out.println(result);

    }
}
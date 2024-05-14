import java.util.Scanner;

public class test1075{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int F = sc.nextInt();;
        int start = N - N%100;
        int end = start + 99;

        for(int i=start; i<=end; i++) {
            if(i % F == 0) {
                int result = i % 100;
                System.out.format("%02d", result);
                break;
            }
        }
    }
    
}
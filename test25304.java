import java.util.Scanner;

public class test25304 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = Integer.parseInt(sc.nextLine()); //영수증에 적힌 금액
        int n = Integer.parseInt(sc.nextLine()); //산 물건의 총 개수

        int total = 0; //구매한 총 금액

        for(int i=0; i<n; i++) {
            String[] strings = sc.nextLine().split(" ");

            int a = Integer.parseInt(strings[0]);
            int b = Integer.parseInt(strings[1]);

            total = total + a*b; //구매한 물건의 금액을 누적합

        }
        if(x == total)
        System.out.println("Yes");
        else System.out.println("No");
    }
}
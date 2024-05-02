import java.util.Scanner;

public class test2480 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] strings = sc.nextLine().split(" ");

        int a = Integer.parseInt(strings[0]);
        int b = Integer.parseInt(strings[1]);
        int c = Integer.parseInt(strings[2]);

        int same = 0;
        int result = 0;

        if((a == b) && (b == c)) {
            same = a;
            result = 10000 + same * 1000;
        }else if((a == b) || (b == c) || (c == a)) {
            if(a == b) {
                same = a;
            }else if(b == c) {
                same = b;
            }else {
                same = c;
            }
            result = 1000 + same * 100;
        }else {
            result = Math.max(a, Math.max(b, c)) * 100;
        }
        System.out.println(result);
    }
}

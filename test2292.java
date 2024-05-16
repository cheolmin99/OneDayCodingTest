import java.util.Scanner;

public class test2292 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int layer = 1;
        int end = 1;

        while (N > end) {
            end += 6 * layer;
            layer++;
        }
        System.out.println(layer);
    }
}

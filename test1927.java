import java.util.Scanner;
import java.util.PriorityQueue;

public class test1927 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        PriorityQueue<Integer> min = new PriorityQueue<>();

        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();

            if(x == 0) {
                if(min.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(min.poll());
                }
            } else {
                min.offer(x);
            }
        }
        sc.close();
    }
}

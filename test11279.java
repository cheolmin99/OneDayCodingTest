import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Collections;

public class test11279 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            
            if(x == 0) {
                if(max.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(max.poll());
                }
            } else {
                max.offer(x);
            }
        }
        sc.close();
    }
}

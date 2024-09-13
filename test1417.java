import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class test1417 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int me = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 1; i < n; i++) {
            pq.add(sc.nextInt());
        }

        int buying = 0;

        while (!pq.isEmpty() && pq.peek() >= me) {
            int maxTicket = pq.poll();
            pq.add(maxTicket - 1);
            me++;
            buying++;
        }

        System.out.println(buying);

        sc.close();
    }
}

import java.util.Scanner;
import java.util.PriorityQueue;

public class test1715 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue();

        for(int i = 0; i < n; i++) {
            pq.offer(sc.nextInt());
        }

        int total = 0;

        while (pq.size() > 1) {
            int one = pq.poll();
            int two = pq.poll();
            int sum = one + two;
            total += sum;
            pq.offer(sum);
        }

        System.out.println(total);
        sc.close();
    }
}

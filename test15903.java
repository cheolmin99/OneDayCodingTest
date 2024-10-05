import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class test15903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");

        int n = Integer.parseInt(strs[0]);
        int m = Integer.parseInt(strs[1]);

        PriorityQueue<Long> pq = new PriorityQueue<>();

        String[] cards = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            pq.offer(Long.parseLong(cards[i]));
        }

        for(int i = 0; i < m; i++) {
            long one = pq.poll();
            long two = pq.poll();

            long newCard = one + two;
            pq.offer(newCard);

            long newCard2 = one + two;
            pq.offer(newCard2);
        }

        long sum = 0;
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }

        System.out.println(sum);
    }
}

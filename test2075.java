import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class test2075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        //최소 힙
        //PriorityQueue<Integer> pq = new PriorityQueue<>();
        //최대 힙
        PriorityQueue<Integer> maxpq = new PriorityQueue<>(Collections.reverseOrder());
        // 람다식 comperator
        //PriorityQueue<Integer> maxpq2 = new PriorityQueue<>((x, y) -> y - x);

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                maxpq.offer(Integer.parseInt(st.nextToken()));
            }
        }
        
        for(int i = 0; i < n - 1; i++) {
            maxpq.poll();
        }

        wr.write(String.valueOf(maxpq.peek()));
        wr.flush();
        wr.close();        
    }
}
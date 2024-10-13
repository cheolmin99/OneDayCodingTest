import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class java1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            if(maxHeap.isEmpty()) {
                maxHeap.offer(num);
                bw.write(maxHeap.peek() + "\n");
                continue;
            } else if(maxHeap.size() == minHeap.size()) {
                if(minHeap.peek() >= num && num >= maxHeap.peek()) maxHeap.offer(num);
                else if(num <= maxHeap.peek()) {
                    maxHeap.offer(num);
                }
                else {
                    maxHeap.offer(minHeap.poll());
                    minHeap.offer(num);
                }
            } else {
                if(maxHeap.peek() <= num) {
                    minHeap.offer(num);
                } else {
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(num);
                }
            }
            //maxHeap 의 첫번째 값이 바로 중간값
            bw.write(maxHeap.peek() + "\n");
        }
        bw.flush();
    }
}

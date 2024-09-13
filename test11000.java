import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class test11000 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] lectures = new int[n][2];

        for(int i = 0; i < n; i++) {
            lectures[i][0] = sc.nextInt();
            lectures[i][1] = sc.nextInt();
        }

        Arrays.sort(lectures, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(lectures[0][1]);

        for(int i = 1; i < n; i++) {
            if(lectures[i][0] >= pq.peek()) {
                pq.poll();
            }
            pq.add(lectures[i][1]);
        }

        System.out.println(pq.size());

        sc.close();
    }
}

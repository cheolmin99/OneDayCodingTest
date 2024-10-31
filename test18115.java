import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class test18115 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 역순으로 파싱
        StringTokenizer st = new StringTokenizer(new StringBuilder(br.readLine()).reverse().toString());

        Deque<Integer> deque = new LinkedList<>(); // 바닥이라 생각하면 될듯

        for (int i = 1; i <= n; i++) {
            int a = Integer.parseInt(st.nextToken());
            
            if (a == 1) { // 카드를 n만큼 1씩 증가하며 덱에 넣어줌(카드를 바닥에 버림)
                deque.addFirst(i);
            } else if (a == 2) { // a에 숫자가 2개이상 들어오면 맨 위의 카드를 바닥에 내림(덱에 추가 ㅇㅇ)
                int top = deque.removeFirst();
                deque.addFirst(i);
                deque.addFirst(top);
            } else { 
                deque.addLast(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (deque.size() != 0) {
            sb.append(deque.removeFirst() + " ");
        }

        System.out.println(sb);
    }
}

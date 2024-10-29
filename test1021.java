import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class test1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());  // 큐의 크기
        int m = Integer.parseInt(st.nextToken());  // 뽑아낼 원소의 개수
        
        Deque<Integer> deque = new LinkedList<>(); //덱 : 양방향으로 삽입과 삭제를 지원하는 큐 offer, poll 의 first와 last를 통해 양쪽에서 삽입과 삭제가 가능
        for (int i = 1; i <= n; i++) {
            deque.offer(i);  // 1부터 N까지의 원소를 덱에 추가
        }
        
        st = new StringTokenizer(br.readLine());
        int[] targets = new int[m];
        for (int i = 0; i < m; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }
        
        int totalRotation = 0;  // 총 회전 횟수
        
        for (int target : targets) {
            int leftRotation = 0;
            
            // 왼쪽 회전 횟수 계산
            for (int num : deque) {
                if (num == target) break;
                leftRotation++;
            }
            
            int rightRotation = deque.size() - leftRotation;
            
            // 최소 회전 횟수를 선택
            if (leftRotation <= rightRotation) {
                totalRotation += leftRotation;
                
                // 왼쪽으로 회전
                while (leftRotation-- > 0) {
                    deque.offerLast(deque.pollFirst());
                }
            } else {
                totalRotation += rightRotation;
                
                // 오른쪽으로 회전
                while (rightRotation-- > 0) {
                    deque.offerFirst(deque.pollLast());
                }
            }
            
            // 원하는 원소를 큐에서 제거
            deque.pollFirst();
        }
        
        System.out.println(totalRotation);
    }
}

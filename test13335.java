import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class test13335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());  // 트럭 수
        int w = Integer.parseInt(st.nextToken());  // 다리 길이
        int L = Integer.parseInt(st.nextToken());  // 다리의 최대 하중
        
        int[] trucks = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trucks[i] = Integer.parseInt(st.nextToken());  // 각 트럭의 무게
        }
        
        Queue<Integer> bridge = new LinkedList<>();  // 다리를 나타내는 큐
        int bridgeWeight = 0;  // 현재 다리 위 트럭의 총 무게
        int time = 0;  // 총 경과 시간
        int index = 0;  // 다리를 건너려고 대기 중인 트럭의 인덱스
        
        while (index < n || bridgeWeight > 0) {
            time++; //와일문 한번씩 돌때다마 시간 1 씩 추가
            
            // 다리 위에서 트럭 한 칸씩 이동
            if (bridge.size() == w) {
                bridgeWeight -= bridge.poll();
            }
            
            // 새로운 트럭이 다리에 올라갈 수 있는지 확인
            if (index < n && bridgeWeight + trucks[index] <= L) {
                bridge.offer(trucks[index]);
                bridgeWeight += trucks[index];
                index++;
            } else {
                // 무게 초과로 트럭을 올릴 수 없으면 0을 넣어 빈 공간을 유지
                bridge.offer(0);
            }
        }
        
        System.out.println(time);
    }
}

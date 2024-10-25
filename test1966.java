import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class test1966 {
    static class Document {
        int index;
        int priority;
        
        //인덱스와 우선순위를 저장하기 위한 클래스
        public Document(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine());
        
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());  // 문서의 개수
            int m = Integer.parseInt(st.nextToken());  // 확인할 문서의 위치
            
            Queue<Document> queue = new LinkedList<>(); //순서와 우선순위 관리
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a); //compare 람다식 표현 우선순위만 관리
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int priority = Integer.parseInt(st.nextToken());
                queue.offer(new Document(i, priority)); 
                priorityQueue.offer(priority);
            }
            
            int printOrder = 0;
            
            while (!queue.isEmpty()) {
                Document currentDoc = queue.poll();
                
                // 현재 문서가 가장 높은 우선순위인 경우
                if (currentDoc.priority == priorityQueue.peek()) {
                    priorityQueue.poll();
                    printOrder++;
                    
                    // 확인할 문서인 경우 결과 추가
                    if (currentDoc.index == m) {
                        sb.append(printOrder).append("\n");
                        break;
                    }
                } else {
                    // 우선순위가 낮아 큐의 뒤로 이동
                    queue.offer(currentDoc);
                }
            }
        }
        
        System.out.println(sb);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class test10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new LinkedList<>();
        
        int n = Integer.parseInt(br.readLine()); 
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            
            switch (command) {
                case "push_front":
                    int x1 = Integer.parseInt(st.nextToken());
                    deque.addFirst(x1);
                    break;
                    
                case "push_back":
                    int x2 = Integer.parseInt(st.nextToken());
                    deque.addLast(x2);
                    break;
                    
                case "pop_front":
                    if (deque.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(deque.pollFirst()).append("\n");
                    }
                    break;
                    
                case "pop_back":
                    if (deque.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(deque.pollLast()).append("\n");
                    }
                    break;
                    
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;
                    
                case "empty":
                    sb.append(deque.isEmpty() ? "1\n" : "0\n");
                    break;
                    
                case "front":
                    if (deque.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(deque.peekFirst()).append("\n");
                    }
                    break;
                    
                case "back":
                    if (deque.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(deque.peekLast()).append("\n");
                    }
                    break;
            }
        }
        
        System.out.print(sb);
    }
}

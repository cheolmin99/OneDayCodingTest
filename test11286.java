import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class test11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        //maxpq -> 우선순위 (1. 절대값이 가장 작은 값, 2. 절대값이 같은 경우 두 수중에 작은 수 선택)
        PriorityQueue<Integer> maxpq = new PriorityQueue<Integer>((x, y) -> {
            int absX = Math.abs(x);
            int absY = Math.abs(y);

            if(absX == absY) {
                //오름차순
                return x - y; //만약 내림차순? 뒷 빼기 앞
            }
            //절대값이 다를때(오름차순)
            return absX - absY;
        });

        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            
            if(num == 0) {
                if(maxpq.isEmpty()) {
                    bw.write("0\n");
                } else {
                    bw.write(maxpq.poll() + "\n");
                }
            } else {
                maxpq.offer(num);
            }
        }

        bw.flush();
        bw.close();
    }
}

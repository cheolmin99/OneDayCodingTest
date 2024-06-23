import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class test11724 {

    public static ArrayList<Integer> graph[];
    public static boolean visited[];
    public static int N,M; 


    public static void dfs(int node) {

        visited[node]=true; 

        for(int i=0; i<graph[node].size(); i++){
            int v = graph[node].get(i); 
            if(!visited[v]) {
                dfs(v);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];

        graph = new ArrayList[N+1]; 
        for(int i=0; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);

        }
        int count = 0; // 연결 요소의 개수를 세는 변수
        for(int i=1; i<=N; i++){
            //방문하지 않은 정점에 대해서 dfs를 돈다(방문하지 않았다 = 새로운 요소를 찾았다.)
            if(!visited[i]) {
                dfs(i);
                count++;
            }
        }
        //int + 문자열 = 문자열
        //bufferwriter에서 int를 출력하면 아스키코드 값이 출력 됨으로 문자열로 변환해서 출력.

        bw.write(String.valueOf(count));

        bw.flush();
        bf.close();
        bw.close();
    }
}
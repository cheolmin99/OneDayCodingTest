import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class test24480 {

    //인접리스트 => ArrayList

    //인접리스트로 그래프 구현
    //public static ArrayList<ArrayList<Integer>> temp;
    public static ArrayList<Integer> graph[];
    //노드를 방문했는지 확인하는 배열
    public static boolean visited[];
    //방문 순서를 저장하는 배열
    public static int order[];

    //방문 순서를 계산하기 위한 변수
    public static int count = 1;
    public static int N,M, start; //정점, 간선, 시작노드


    public static void dfs(int node) {

        visited[node]=true; //방문체크
        order[node] = count++; //방문 순서 계산하고 저장하기

        //그 다음 정점으로 dfs 호출
        for(int i=0; i<graph[node].size(); i++){
            int v = graph[node].get(i); //i번째에 있는 정점
            if(!visited[v]) {
                dfs(v);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        //Scanner sc= new Scanner(System.in);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        order = new int[N+1];

        graph = new ArrayList[N+1]; //배열을 초기화 => ArrayList 초기화
        for(int i=0; i<=N; i++) {
            //i는 정점 //new ArrayList의 역할?? i 정점과 연결된 정점들을 저장하는 리스트
            //ArrayList는 배열과 다르게 크기가 동적이다. (넣는 만큼 크기가 결정된다)
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            //정점들을 연결
            graph[u].add(v);
            graph[v].add(u);

        }

        //여기서 주의할 점 반드시 정점별로 오름차순 정렬을 해줘야한다.
        //방문 순서를 오름차순 정렬로 할 수 있도록
        for(int i=0; i<=N ; i++) {
            //Collections.sort(graph[i]);
            Collections.sort(graph[i], Collections.reverseOrder());
        }

        //DFS
        dfs(start);

        for(int i=1; i<=N; i++) {
            bw.write(order[i] + "\n");

        }
        bw.flush();
        bf.close();
        bw.close();

    }
}
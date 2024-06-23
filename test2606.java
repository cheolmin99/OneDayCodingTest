import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class test2606 {
    public static ArrayList<Integer>[] graph;
    public static boolean[] visited;
    public static int[] order;
    public static int count = 1;
    public static int N, M, start;

    public static void dfs(int node) {
        visited[node] = true;
        order[node] = count++;

        for (int i = 0; i < graph[node].size(); i++) {
            int v = graph[node].get(i);
            if (!visited[v]) {
                dfs(v);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bf.readLine().trim());
        M = Integer.parseInt(bf.readLine().trim());
        start = 1;

        visited = new boolean[N + 1];
        order = new int[N + 1];

        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        // 각 노드의 인접 노드를 오름차순으로 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        // DFS 수행
        dfs(start);

        int count = 0; // 바이러스에 감염된 수
        for (int i = 1; i <= N; i++) {
            if (visited[i]) {
                count++;
            }
        }

        bw.write(String.valueOf(count - 1)); // 시작 노드를 제외하고 감염된 수
        bw.flush();
        bf.close();
        bw.close();
    }
}

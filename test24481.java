import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class test24481 {
    public static int N, M, start;
    public static boolean[] visited;
    public static int[] depth;
    public static ArrayList<Integer>[] graph;

    public static void dfs(int node, int d) {
        visited[node] = true;
        depth[node] = d;

        for (int v : graph[node]) {
            if (!visited[v]) {
                dfs(v, d + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        depth = new int[N + 1];
        Arrays.fill(depth, -1); // 방문하지 않은 노드의 깊이는 -1로 초기화
        graph = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        dfs(start, 0);

        for (int i = 1; i <= N; i++) {
            bw.write(depth[i] + "\n");
        }

        bw.flush();
        bf.close();
        bw.close();
    }
}

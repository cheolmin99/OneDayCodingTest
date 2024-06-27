import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class test24483 {
    public static int N, M, start;
    public static boolean[] visited;
    public static int[] depth;
    public static int[] visitOrder;
    public static int orderCount = 0;
    public static ArrayList<Integer>[] graph;

    public static void dfs(int node, int d) {
        visited[node] = true;
        depth[node] = d;
        visitOrder[node] = ++orderCount;

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
        visitOrder = new int[N + 1];
        Arrays.fill(depth, -1);
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

        long result = 0;
        for (int i = 1; i <= N; i++) {
            if (depth[i] != -1) {
                result += (long) depth[i] * visitOrder[i];
            }
        }

        bw.write(result + "\n");
        bw.flush();
        bf.close();
        bw.close();
    }
}

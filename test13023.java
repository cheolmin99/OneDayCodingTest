import java.io.*;
import java.util.*;

public class test13023 {
    static int n, m;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static boolean found;
    public static void dfs(int node, int depth) {
        if (depth == 4) {
            found = true;
            return;
        }

        visited[node] = true;

        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                dfs(neighbor, depth + 1);
                if (found) return; 
            }
        }

        visited[node] = false; 
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        visited = new boolean[n];
        found = false;

        for (int i = 0; i < n; i++) {
            if (!found) {
                dfs(i, 0);
            }
        }

        bw.write(found ? "1\n" : "0\n");
        bw.flush();
        bw.close();
        br.close();
    }

}

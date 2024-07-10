import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class test24446 {
    static int n, m, start;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] depth;

    public static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        visited[start] = true;
        depth[start] = 0;
        que.offer(start);

        while (!que.isEmpty()) {
            int node = que.poll();
            for(int i = 0; i < graph[node].size(); i++) {
                int v = graph[node].get(i);
                if(!visited[v]) {
                    visited[v] = true;
                    depth[v] = depth[node] + 1;
                    que.offer(v); 
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] strs = br.readLine().split(" ");
        n = Integer.parseInt(strs[0]);
        m = Integer.parseInt(strs[1]);
        start = Integer.parseInt(strs[2]);

        visited = new boolean[n + 1];
        depth = new int[n + 1];
        graph = new ArrayList[n + 1];

        for(int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
            depth[i] = -1;
        }

        for(int i = 0; i < m; i++) {
            String[] str = br.readLine().split(" ");
            int u = Integer.parseInt(str[0]);
            int v = Integer.parseInt(str[1]);
            graph[u].add(v);
            graph[v].add(u);
        }

        for(int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }

        bfs(start);
        
        for(int i = 1; i <= n; i++) {
            sb.append(depth[i]).append("\n");
        }

        System.out.println(sb.toString());
    }
}
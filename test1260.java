import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class test1260 {
    static int n, m, v;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void dfs(int start) {
        visited[start] = true;
        sb.append(start + " "); //dfs는 재귀함수를 돌때마다 노드를 방문 하므로

        for(int i = 0; i < graph[start].size(); i++) {
            int v = graph[start].get(i);
            if(!visited[v]) {
                dfs(v);
            }
        }
    }
    public static void bfs(int start) {
        visited[start] = true;
        //큐에 노드를 저장해야함(해당 자식 노드를 방문하기 위해)
        Queue<Integer> que = new LinkedList<>();
        que.offer(start); //크기가 꽉 차있는 상태에서 추가가 되려 한다면 알려줌
        //큐 안에 있는 노드가 모두 없을 때 까지
        //부모 노드를 큐에서 거내고, 해당 부모노드의 자식 노드들을 모두 큐에 넣는다.
        //자식 노드가 없는 노드는 그냥 삭제됨.
        while (!que.isEmpty()) {
            //부모 노드를 큐에서 꺼낸다.(꺼낸 순서 -> 경로 순서)
            int node = que.poll(); //큐에서 값을 반환한뒤 삭제
            //que.peek(); //맨 앞(head)의 값만 반환
            sb.append(node + " "); //방문한 순서를 출력
            for(int i = 0; i < graph[node].size(); i++) {
                int v = graph[node].get(i);
                if(!visited[v]) {
                    visited[v] = true;
                    que.offer(v); //큐에 노드 추가
                }
            }
        }
        
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        v = Integer.parseInt(str[2]);

        visited = new boolean[n + 1];
        graph = new ArrayList[n + 1];

        for(int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            graph[a].add(b);
            graph[b].add(a);
        }

        for(int i = 0; i < n + 1; i++) {
            Collections.sort(graph[i]);
        }

        dfs(v);
        sb.append("\n");

        Arrays.fill(visited, false);

        bfs(v);
        System.out.println(sb.toString());
    }
}

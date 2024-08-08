import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class test17086 {
    static int[][] map;
    static int n, m;
    static boolean[][] visited;
    static int ans = 0;
    static int[][] dist; //상어까지의 안전 거리 (i, j)
    static int[][] dir ={{0, 1}, {0, -1}, {-1, 0}, {1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    static class Pair {
        int x, y, dist;
        public Pair(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    //bfs는 i,j 위치에 있는 안전거리를 반환
    public static int bfs(int i, int j) {
        Queue<Pair> que = new LinkedList<>();
        que.offer(new Pair(i, j, 0));
        visited[i][j] = true;
        while (!que.isEmpty()) {
            Pair p = que.poll();
            for(int d = 0; d < 8; d++) {
                int nx = p.x + dir[d][0]; //x,y 위치에서 갈 수 있는 8방향을 모두 탐색
                int ny = p.y + dir[d][1]; 
                //범위를 벗어났거나 방문했던 곳이면 넘어간다.
                if(nx < 0 || ny < 0 || nx >=n || ny >= m || visited[nx][ny]) {
                    continue;
                }
                if(map[nx][ny] == 1) { //상어를 만났다(먼저 만난 상어가 하나라도 있으면 가장 가까운 안전거리)
                    //dist[nx][ny] = p.dist + 1; 각 상어마다 안전거리를 저장(모든 상어들의 안전거리를 찾은 뒤, 그 중에서 최소값을 구한다.)
                    //que.offer(new Pair(nx, ny, map[nx][ny]))
                    //visited[nx][ny]
                    return p.dist + 1;
                }
                visited[nx][ny] = true;
                que.offer(new Pair(nx, ny, p.dist + 1));
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();

        map = new int[n][m];
        for(int i = 0; i < n; i++) {
            String[] temp = sc.nextLine().split(" ");
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 0) {
                    visited = new boolean[n][m];
                    ans = Math.max(ans, bfs(i, j));
                }
            }
        }
        System.out.println(ans);
    }
    
}

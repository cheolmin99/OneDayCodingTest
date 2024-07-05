import java.util.*;

public class test2178 {
    static int n, m;
    static int[][] map;
    static int[][] visited;

    static class Pair {
        int r, c;
        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
        public int getR() {
            return r;
        }
        public int getC() {
            return c;
        }
    }
    public static void bfs(int r, int c) {
        int[][] di = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        visited[r][c] = 1; //0이면 방문 x 0이 아니면 방문
        Queue<Pair> que = new LinkedList<>();
        que.offer(new Pair(r, c));

        while (!que.isEmpty()) {
            Pair p = que.poll();
            r = p.r;
            c = p.c;

            for(int i = 0; i < 4; i++) {
                int nr = r + di[i][0];
                int nc = c + di[i][1];

                if(nr < 0 || nc < 0 || nr >= n || nc >= m || map[nr][c] == 0) {
                    continue;
                }
                if(visited[nr][nc] == 0 && map[nr][nc] == 1) {
                    //부모노드의 깊이 + 1 (상하좌우중 하나로 부터 이동했기 때문)
                    visited[nr][nc] = visited[r][c] + 1;
                    que.offer(new Pair(nr, nc));
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        n = Integer.parseInt(str[0]); //행
        m = Integer.parseInt(str[1]); //열

        for(int i = 0; i < n; i++) {
            map = new int[n][m];
            visited = new int[n][m];
        }

        for(int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for(int j = 0; j < s.length(); j++) {
                map[i][j] = s.charAt(j) - '0'; //char형을 int형으로
            }
        }
        bfs(0, 0);
        System.out.println(visited[n - 1][m - 1]);
    }
}

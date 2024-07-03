import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class kakaoFriendColoringBook {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[][] di = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int areaSize;
    public static void dfs(int x, int y, int color) {
        visited[x][y] = true;
        areaSize++;
        
        for (int i = 0; i < 4; i++) {
            int nx = x + di[i][0];
            int ny = y + di[i][1];
            
            if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && map[nx][ny] == color) {
                dfs(nx, ny, color);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int numberOfAreas = 0;
        int maxSizeOfOneArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] > 0 && !visited[i][j]) {
                    areaSize = 0;
                    dfs(i, j, map[i][j]);
                    numberOfAreas++;
                    if (areaSize > maxSizeOfOneArea) {
                        maxSizeOfOneArea = areaSize;
                    }
                }
            }
        }

        bw.write(numberOfAreas + "\n" + maxSizeOfOneArea + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

}

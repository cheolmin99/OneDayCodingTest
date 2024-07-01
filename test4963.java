import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class test4963 {
    public static int l, s;
    public static int[][] map;
    public static boolean[][] visited;
    public static int[][] di = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    
    public static void dfs(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 8; i++) {
            int nx = x + di[i][0];
            int ny = y + di[i][1];
            if (nx >= 0 && ny >= 0 && nx < s && ny < l && !visited[nx][ny] && map[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            
            if (l == 0 && s == 0) break;
            
            map = new int[s][l];
            visited = new boolean[s][l];
            
            for (int i = 0; i < s; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < l; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            int count = 0;
            for (int i = 0; i < s; i++) {
                for (int j = 0; j < l; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        count++;
                    }
                }
            }
            
            sb.append(count).append("\n");
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

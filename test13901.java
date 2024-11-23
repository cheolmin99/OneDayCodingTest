import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test13901 {
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; //방향
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[][] map = new int[R][C];

        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r][c] = -1; //장애물
        }

        st = new StringTokenizer(br.readLine());
        int sr = Integer.parseInt(st.nextToken());
        int sc = Integer.parseInt(st.nextToken());
        map[sr][sc] = 2; //로봇

        st = new StringTokenizer(br.readLine());
        int[] dorder = new int[4];
        for(int i = 0; i < 4; i++) {
            dorder[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        int dirIdx = 0; // dorder의 인덱스를 의미(현재 로봇이 가야할 방향의 인덱스)
        
        int limit = 0; // 연속적으로 방향을 바꾸는 횟수

        while (true) {
            int currDir = dorder[dirIdx]; // 현재 가리키고 있는 방향을 계산하기 위한 값
            int nr = sr + dir[currDir][0];
            int nc = sc + dir[currDir][1];

            //이동 중 벽이나, 방문한 지역, 장애물을 만나ㅡㄴ 경우인지를 확인
            //벽 : 범위를 벗어난 상태
            //방문상태 : 값이 2인 상태
            //장애물 : 값이 -1인 상태

            if(nr < 0 || nc < 0 || nr >= R || nc >= C || map[nr][nc] == 2 || map[nr][nc] == -1) {
                dirIdx = (dirIdx + 1) % 4;
                limit++;
                if(limit >= 4) break; //더 이상 네 방향으로 갈 수 있는 곳이 없다.
                continue;
            }
            //갈 수 있는 상태
            if(map[nr][nc] == 0) {
                //해당 방향으로 이동
                map[nr][nc] = 2;
                sr = nr;
                sc = nc;
                limit = 0;
            }
        }
        System.out.println(sr + " " + sc);
    }    
}

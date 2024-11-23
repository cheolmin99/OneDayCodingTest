import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class test3190 {
    static class Pos {
        int x;
        int y;
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    //우,하,좌,상
    static int[][] dir = {{0, 1},{1, 0},{0, -1},{-1, 0}};

    // public static void printMap(int[][] map) {
    //     for(int i=0; i<map.length; i++) {
    //         for(int j=0; j<map.length; j++) {
    //             if(map[i][j] == -1) System.out.print("X");
    //             else System.out.print(map[i][j]);
    //         }
    //         System.out.println();
    //     }
    // }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[][] map = new int[N + 2][N + 2];

        for(int i = 0; i < N + 2; i++) {
            map[i][0] = map[i][N+1] = -1; //맨 오른쪽, 왼쪽 벽
            map[0][i] = map[N+1][i] = -1; //맨 위, 아래 벽
        }

        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r][c] = 1; //사과가 있다.
        }

        st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        //키: 시간, 값: 방향 (hash -> 검색하는 시간이 O(1), 선형 검색 => O(N))
        Map<Integer, String> commands = new HashMap<>();
        for(int i = 0; i < L; i++){
            st = new StringTokenizer(br.readLine());
            int sec = Integer.parseInt(st.nextToken());
            String d = st.nextToken();
            commands.put(sec,d);
        }

        //시뮬레이션 시작전
        //데크? 뱀은 머리와 꼬리가 있기 때문. 머리는 위치가 계속 새롭게 업데이트가 되어야 하므로 맨 앞에 새로운 위치 추가,
        // 꼬리는 기존에 머리(몸통)이 있던 자리로 옮겨야 하므로 원래 있던 꼬리의 위치를 삭제
        ArrayDeque<Pos> deque = new ArrayDeque<>();
        deque.offer(new Pos(1,1));
        int time = 0;
        int currDir = 0; //방향을 가리키는 인덱스 (우쪽 방향)
        map[1][1] = 2; //뱀이 있다.
        //시뮬레이션 시작
        while(true) {
             time++;
            //현 재 머리의 위치
            Pos curr = deque.getFirst();
            //그 다음으로 갈 수 있는 머리의 위치
            int nr = curr.x + dir[currDir][0];
            int nc = curr.y + dir[currDir][1];

            //벽이거나 자기자신과 몸이 부딪치면 게임이 끝난다.
            if(nr < 1 || nc < 1 || nr >= N+1 || nc >= N+1 || map[nr][nc]==-1 || map[nr][nc]==2){
                break;
            }

            //사과가 없는 경우(머리와 꼬리의 위치가 이동 되어야한다, 단 몸의 길이는 일정하다)
            if(map[nr][nc] == 0) {
                //뱀의 머리 위치 추가
                deque.addFirst(new Pos(nr,nc));
                map[nr][nc] = 2;
                //뱀의 꼬리 위치 삭제
                Pos tail = deque.pollLast();
                map[tail.x][tail.y] = 0;
            }


            //사과가 있는 경우
            if(map[nr][nc] == 1) {
                //뱀의 머리 위치 추가
                deque.addFirst(new Pos(nr,nc));
                map[nr][nc] = 2;
            }

            //방향 틀기
            if(commands.containsKey(time)) {
                //해당 시간에 방향을 트는 명령어가 있다면
                if(commands.get(time).equals("D")) {
                    //오른쪽 방향으로 틀기
                    currDir = (currDir + 1) % 4;
                }else {
                    //왼쪽 방향으로 틀기
                    currDir = (currDir - 1) < 0 ? 3 : currDir - 1;
                }
            }
            // System.out.println(time+"sec // "+currDir);
            // printMap(map);
            // System.out.println("====================");

        }

        System.out.println(time);

    }
}

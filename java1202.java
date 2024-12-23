import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class java1202 {
    static class Gem {
        int m;
        int v;
        Gem(int m, int v) {
            this.m = m;
            this.v = v;
        }
    }
    public static void main(String[] args) throws IOException {
        //그리디 + 우선순위큐 => 그리디(가방과 보석의 무게를 오름차순으로 넣었을때 이득) + 우선순위 큐(보석의 가치가 높은 순으로 계산)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Gem[] gems = new Gem[n];
        int[] bags = new int[k];
        long ans = 0;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken()); //보석의 무게
            int v = Integer.parseInt(st.nextToken()); //보석의 가치
            gems[i] = new Gem(m, v);
        }

        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken()); //가방의 최대 무게
            bags[i] = c;
        }

        Arrays.sort(gems, new Comparator<Gem>() {
            @Override
            public int compare(Gem o1, Gem o2) {
                return o1.m - o2.m;
            } // 무게를 기준으로 오름차순
        });

        //가방의 무게가 작을수록 작은 무게의 보석을 넣어야함
        //무게가 작은 보석은 큰 무게의 가방에 굳이 넣을 필요가 없음(공간 낭비)
        Arrays.sort(bags); //가방 또한 오름차순으로 정렬 (무게가 작은 보석을 넣을 수 있기 때문)

        //우선순위 큐 => 넣을 때는 같은 무게라도 가격이 높은 보석을 선택한다.
        PriorityQueue<Gem> pqGem = new PriorityQueue<>((o1, o2) -> o2.v - o1.v);
        int idx = 0; //보석의 위치
        for(int i = 0; i < k; i++) {
            //가방의 개수만큼 보석을 넣어보자
            //가방의 무게 보다 작거나 같은 보석들을 넣자(오름차순 이니깐)
            //이때 가방의 무게보다 작거나 같은 모든 보석들 중에서 우선순위 큐가 알아서 가격이 높은
            //보석이 맨 앞에 위치하게 된다.
            while(idx < n && gems[idx].m <= bags[i]) {
                pqGem.offer(gems[idx]);
                idx++;
            }
            //우선순위 큐의 맨 앞의 값이 가방의 무게보다 작거나 같으면서 가치가 가장 큰 값이다.
            if(!pqGem.isEmpty()) {
                ans += pqGem.poll().v; 
            }
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}

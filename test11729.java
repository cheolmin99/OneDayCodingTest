import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test11729 {
    static StringBuilder sb = new StringBuilder();
    //n: 원판의 개수 start: 도달 전(1), mid 거쳐가는 곳(2), end 도달 후(3)
    public static void hanoi(int N, int start, int mid, int end) {
        if(N == 1) {
            sb.append(start + " " + end + "\n");
            return;
        }
        //어떤 기둥이던 A -> B -> C로 이동 한다
        //3개 이후부터는 A -> B로 이동할 때 C를 거쳐서 간다.
        //B -> C로 이동할때 A를 거쳐서 간다.

        //1번기둥 3번 기둥을 거쳐 2번기둥으로 도달
        hanoi(N - 1, start, end, mid); 
        sb.append(start + " " + end + "\n");
        //2번 기둥에서 1번기둥을 거쳐서 3번기둥으로 도달
        hanoi(N - 1, mid, start, end);

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println((int)(Math.pow(2,n)-1));
        hanoi(n, 1, 2, 3);
        System.out.println(sb.toString());
    }
}

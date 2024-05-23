import java.util.*;

public class test15649 {

    //N과 M(1)
    //경우의 수: 순열, 조합, 중복순열, 중복조합
    //브루트포스 => 무식하게 모든 경우의 수를 다 찾기 => 시간이 오래걸림
    //불필요하고 중복되는 경우의 수를 어떻게 하면 줄일 수 있을까?

    //순열 => 줄 세우는 경우의 수(순서가 중요)
    static int n,m;
    static int[] used, ans;

    public static void permutations(int len) {
        if(len == m) {
            for(int i:ans) System.out.print(i + " ");
            System.out.println();
            return;
        }

        for(int i = 1; i <= n; i++) {
            if(used[i] == 0) { //사용하지 않는 숫자 사용(중복 x)
                ans[len] = i;
                used[i] = 1; //사용했다.
                permutations(len + 1); //그 다음 숫자를 선택
                used[i] = 0; //사용 안 했다.
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //?전체 수
        m = sc.nextInt(); //?전체 길이

        //?숫자를 하나 선택했다(중복을 뽑지 않기 위해서)
        used = new int[n + 1]; //? 0~n까지 사용한 숫자를 표시
        //? 출력할 수열(순열)
        ans = new int[m];

        permutations(0);
    }
}

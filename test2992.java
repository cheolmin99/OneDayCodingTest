import java.util.Scanner;

public class test2992 {

    static String num;
    static int inum;
    static boolean visited[];
    static char used[]; //만들 수 있는 순열 배열 ['1','5','6'],['1','6','5']
    static int len;
    static int ans = Integer.MAX_VALUE;


    public static void solve(int dep){
        if(len == dep){
            int temp = Integer.parseInt(String.valueOf(used));
            if(temp > inum) ans = Math.min(ans, temp);
            return;
        }

        for(int i = 0; i<len; i++){
            if(!visited[i]) {
                visited[i] = true;
                used[dep] = num.charAt(i);
                solve(dep+1);
                visited[i] = false;
            }
        }
    }


    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        num = sc.next(); //"156"
        inum = Integer.parseInt(num); // 156
        len = num.length();

        visited = new boolean[len];
        used = new char[len];

        solve(0);
        System.out.println((ans == Integer.MAX_VALUE)? 0 : ans);

    }
}

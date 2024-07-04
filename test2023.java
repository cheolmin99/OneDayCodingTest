import java.util.*;

public class test2023 {
    static int n;
    public static boolean isPrime(int n) {
        if(n < 2) return false;
        for(int i = 2; i <= Math.ceil(Math.sqrt(n)); i++) {
            if(n % i == 0) return false;
        }
        return true;
    }

    public static void dfs(int num, int len) {
        if(len == n) {
            System.out.println(num);
            return;
        }
        for(int i = 1; i <= 9; i += 2) {
            int nextNum = num * 10 + i;
            if(isPrime(nextNum)) {
                dfs(nextNum, len + 1);
            }
        }
    }   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());

        int[] start = {2, 3, 5, 7};

        for(int i = 0; i < 4; i++){
            dfs(start[i],1);
        }
    }
}

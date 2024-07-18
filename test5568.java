import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class test5568 {
    static int n,k;
    static int[] cards, select;
    static boolean[] used;
    static HashSet<String> set = new HashSet<>();
    public static void permu(int len) {
        if(len == k) {
            //선택한 숫자들을 합쳐서 새로운 정수
            String s = "";
            for(int i = 0; i < k; i++) {
                s+= Integer.toString(select[i]);
            }
            set.add(s);
            return;
        }
        for(int i = 0; i < n; i++) {
            if(!used[i]) {
                select[len] = cards[i];
                used[i] = true;
                permu(len + 1);
                used[i] = false;
            }
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        cards = new int[n];
        used = new boolean[n];
        select = new int[k];
        for(int i=0; i<n; i++){
            cards[i] = sc.nextInt();
        }

        permu(0);
        System.out.println(set.size());
    }
}

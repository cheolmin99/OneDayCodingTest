import java.util.*;

public class test2529 {
    static int k;
    static char[] signs;
    static boolean[] used = new boolean[10];
    static StringBuilder min = new StringBuilder();
    static StringBuilder max = new StringBuilder();
    static boolean foundMin = false;
    static boolean foundMax = false;

    public static void dep(String num, int idx) {
        if(idx == k + 1) {
            if(!foundMin) {
                min.append(num);
                foundMin = true;
            }
            max.setLength(0);
            max.append(num);
            foundMax = true;
            return;
        }

        for(int i = 0; i <= 9; i++) {
            if(!used[i]) {
                if(idx == 0 || valid(num.charAt(idx - 1) - '0', i, signs[idx - 1])) {
                    used[i] = true;
                    dep(num + i, idx + 1);
                    used[i] = false;
                }
            }
        }
    }

    public static boolean valid(int a, int b, char sign) {
        return sign == '<' ? a < b : a > b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        signs = new char[k];
        for(int i = 0; i < k; i++) {
            signs[i] = sc.next().charAt(0);
        }

        dep("", 0);

        System.out.println(max.toString());
        System.out.println(min.toString());
    }
}

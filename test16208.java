import java.util.*;

public class test16208 {
    public static int n;
    public static int[] mak;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        mak = new int[n];
        for(int i = 0; i < n; i++) {
            mak[i] = sc.nextInt();
        }

        Arrays.sort(mak);

        Long total = (long) 0;
        for(int length : mak) {
            total += length;
        }
        
        Long result = (long) 0;
        for(int length : mak) {
            total -= length;
            result += (long)length * total;
        }

        System.out.println(result);
    }
}

import java.util.*;

public class test10871 {
    static int n,x;
    static int[] array;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        x = sc.nextInt();
        array = new int[n];

        for(int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            if(array[i] < x) {
                sb.append(array[i]).append(" ");
            }
        }
        System.out.println(sb.toString().trim());
    }
}

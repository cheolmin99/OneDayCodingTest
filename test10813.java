import java.util.*;

public class test10813 {
    static int n,m,a,b;
    static int[] array;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        array = new int[n];

        for(int i = 0; i < n; i++) {
            array[i] = i + 1;
        }

        for(int i = 0; i < m; i++) {
            a = sc.nextInt() - 1;
            b = sc.nextInt() - 1;

            int temp = array[a];
            array[a] = array[b];
            array[b] = temp;
        }

        for(int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
    }
}

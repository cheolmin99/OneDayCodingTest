import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test10773 {
    static int n, m, top, sum;
    static int[] stack;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        stack = new int[n];
        top = 0;

        for(int i = 0; i < n; i++) {
            m = Integer.parseInt(br.readLine());

            if(m == 0) {
                if(top > 0) {
                    top--;
                }
            } else {
                stack[top++] = m;
            }
        }
        sum = 0;
        for(int i = 0; i < top; i++) {
            sum += stack[i];
        }
        System.out.println(sum);
    }
}

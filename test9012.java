import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            int count = 0;
            boolean isValid = true;

            for(int j = 0; j < input.length(); j++) {
                char c = input.charAt(j);
                if(c == '(') {
                    count++;
                } else if(c == ')') {
                    count--;
                    if(count < 0) {
                        isValid = false;
                        break;
                    }
                }
            }
            if(isValid && count == 0) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        System.out.print(sb);
    }
}

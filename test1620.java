import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class test1620 {
    static int n, m;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        HashMap<String, String> poketmon = new HashMap();

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String number = Integer.toString(i);

            poketmon.put(number, name);
            poketmon.put(name, number);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String result = st.nextToken();
            sb.append(poketmon.get(result) + "\n");
        }
        System.out.println(sb.toString());
    }
}

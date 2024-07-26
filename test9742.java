import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test9742{

    private static int totalCount, num;
    private static boolean[] visited;
    private static char[] chars; 
    private static String answer;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while((line=br.readLine())!=null){
            StringTokenizer st = new StringTokenizer(line);
            String str = st.nextToken();
            num = Integer.parseInt(st.nextToken());


            totalCount=0;
            chars=new char[str.length()];
            visited=new boolean[str.length()];

            dfs(str, 0);

            if(totalCount<num) answer="No permutation";
            System.out.println(str+" "+num+" = "+answer);
        }
    }

    private static void dfs(String str, int cnt){
        if(cnt==str.length()){
            totalCount++;
            if(totalCount==num) answer=new String(chars);

            return;
        }

        for(int i=0; i<str.length(); i++){
            if(!visited[i]){
                visited[i]=true;
                chars[cnt]=str.charAt(i);
                dfs(str, cnt+1);
                visited[i]=false;
            }
        }
    }
}
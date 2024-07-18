import java.util.ArrayList;
import java.util.Scanner;

public class test1337 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> nums = new ArrayList<>();
        int ans = 4;
        for(int i=0; i<n; i++){
            nums.add(sc.nextInt()); // 5,6,7
        }
        for(int i=0; i<n; i++){
            int cnt = 0;
            int a = nums.get(i);
            for(int j=0; j<5; j++){
                //a=5 => 5,6,7,8,9
                if(!nums.contains(a+j)){
                    cnt++;
                }
            }
            ans = Math.min(ans,cnt);
        }

        System.out.println(ans);
    }
}

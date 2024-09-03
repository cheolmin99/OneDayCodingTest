import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class test20301 {
    static int n, k, m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        k = sc.nextInt();
        m = sc.nextInt();

        List<Integer> list = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            list.add(i);
        }

        int index = 0;
        int direction = 1;
        int removeCount = 0;

        while (!list.isEmpty()) {
            index = (index + direction * (k - 1)) % list.size();

            if (index < 0) {
                index += list.size();
            }

            System.out.print(list.remove(index) + " ");
            removeCount++;

            if (removeCount % m == 0) {
                direction *= -1; 
            }

            if (direction == -1) {
                index--;  
            }
        }
    }
}

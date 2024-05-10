import java.util.Arrays;
import java.util.Scanner;

public class test2309 {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        // 아홉 난쟁이의 키 입력
        int[] heights = new int[9];
        for (int i = 0; i < 9; i++) {
            heights[i] = scanner.nextInt();
        }
        
        // 아홉 난쟁이 중에서 두 난쟁이를 선택하여 키의 합이 totalHeight - 100인 경우 찾기
        int totalHeight = Arrays.stream(heights).sum();
        boolean found = false;
        int[] result = new int[7];

        for (int i = 0; i < 9 && !found; i++) {
            for (int j = i + 1; j < 9 && !found; j++) {
                if (totalHeight - heights[i] - heights[j] == 100) {
                    // 찾은 두 난쟁이의 키를 제외하고 출력
                    int index = 0;
                    for (int k = 0; k < 9; k++) {
                        if (k != i && k != j) {
                            result[index++] = heights[k];
                        }
                    }
                    Arrays.sort(result);
                    found = true;
                }
            }
        }
        for (int i : result) {
            System.out.println(i);
        }

        scanner.close();
    }
}
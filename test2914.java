import java.util.Scanner;

public class test2914 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 앨범에 수록된 곡의 개수와 평균값 입력 받기
        int a = sc.nextInt();
        int i = sc.nextInt();

        // 최소 몇 곡이 저작권이 있는 멜로디인지 출력
        System.out.println(a * (i - 1) + 1);
        
    }
}
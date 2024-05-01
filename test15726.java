import java.util.Scanner;

public class test15726 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //1. 문장으로 입력받기
        String str = sc.nextLine();
        //2. 띄워쓰기 기준으로 데이터 쪼개기
        String[] strings = str.split(" "); //{"32", "16", "8"}
        //3. 데이터 자료형 변환
        double a = Integer.parseInt(strings[0]); //a = 32;
        double b = Integer.parseInt(strings[1]); //b = 16
        double c = Integer.parseInt(strings[2]); // 암묵적 형 변환 double 자료형에 int형
        //4.로직구현
        int result1 = (int)(a*b/c);
        int result2 = (int)(a/b*c);

        System.out.print(Math.max(result1, result2));

//        System.out.print((result1 > result2)? result1:result2);
//
//        if(result1 > result2) System.out.print(result1);
//        else System.out.print(result2);

    }
}
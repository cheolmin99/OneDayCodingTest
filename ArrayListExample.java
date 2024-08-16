import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(150); //? 차례로 추가
        list.add(200);
        list.add(0, 50); //? 맨 앞에 추가
        list.add(1, 100); //? 1번째 위치에 추가

        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 3));
        //? ArrayList끼리 합치려면?
        list2.addAll(0, list); //? 0번째 인덱스에 list를 모두 추가
        System.out.println(list.toString());
        System.out.println(list2.toString());

        //? contains 해당 값이 있는지 없는지?
        System.out.println(list2.contains(100));
        System.out.println(list2.contains(70));

        list2.add(150);
        //? index 가장 왼쪽에서 부터 위치를 찾아줌. -> lastIndexOf는 가장 오른쪽에서 부터
        System.out.println("index 150: " + list2.indexOf(150));
        System.out.println("last index 150: " + list2.lastIndexOf(150));
        System.out.println("index 300: " + list2.lastIndexOf(300)); //? 없으면 -1

        //? remove 삭제하기
        list2.remove(0); //? remove 50 (0번째 위치한 값 삭제)
        list2.remove(150); //? remove 150 (요소 150 삭제)

        //? get
        System.out.println("0번째 값: " + list2.get(0));
        System.out.println("1번째 값: " + list2.get(1));
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class HashSetExample {
    public static void main(String[] args) {
        //? 중복된 값을 제외하고 저장하는 자료형
        HashSet<String> set = new HashSet<>();
        set.add("사과");
        set.add("딸기");
        set.add("바나나");
        set.add("사과"); //? 저장 안된다.


        //? ArrayList 안에 있는 여러 요소들 중에 중복을 제거해서 사용해야할 경우
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,3,4,4,4,1,2));

        //? ArrayList 중복 제거
        HashSet<Integer> listSet = new HashSet<>(list);
        System.out.println(listSet);


        //? set 연산 (집한 연산 - 합집합, 차집합, 교집합)

        HashSet<Integer> set1 = new HashSet<>();
        set1.add(10);
        set1.add(20);
        set1.add(30);
        set1.add(40);

        HashSet<Integer> set2 = new HashSet<>();
        set2.add(10);
        set2.add(20);
        set2.add(60);
        set2.add(70);

        //? retainAll : 교집합
        HashSet<Integer> set3 = new HashSet<>(set1);

        set3.retainAll(set2);
        System.out.println("intersection : "+set3);

        //? addAll : 합집합
        HashSet<Integer> set4 = new HashSet<>(set1);

        set4.addAll(set2);
        System.out.println("union : "+set4);

        //? removeAll : 차집합
        HashSet<Integer> set5 = new HashSet<>(set1);

        set5.removeAll(set2);
        System.out.println("difference set1: "+set5);

        HashSet<Integer> set6 = new HashSet<>(set2);

        set6.removeAll(set1);
        System.out.println("difference set2: "+set6);
        
        //? contains :  요소가 포함되어 있는가?
        System.out.println(set1.contains(20)); //true
        System.out.println(set1.contains(100)); //false
        
        //? size : 크기/길이 요소의 개수 (hashset, hashmap, ArrayList, LinkedList ..)

    }
}

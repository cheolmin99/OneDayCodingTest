import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;

public class HashMapExample {

    // 1620 나는야 포켓몬 마스터 이다솜 문제
    public static void main(String[] args) {
        HashMap<Integer, String> students = new HashMap<>();
        
        //? 값을 추가하고 싶다. 키를 통해서 값을 접근하는 방법 값은 중복될 수 있다. 키는 중복 x
        students.put(20240801, "이철수");
        students.put(20240804, "이재향");
        students.put(20240803, "정홍찬");
        students.put(20240805, "이철수");
        students.put(20240802, "김민재");
        
        //? get(키) => 해당 키에 해당하는 값을 들고옴.
        System.out.println(students.get(20240802)); //민재
        System.out.println(students.get(20240803)); //홍찬
        System.out.println(students.get(20240809)); //null

        //? containsKey(키) -> 키가 있는지 없는지 boolean 값을 반환
        if(students.containsKey(20240801)) {
            System.out.println(students.get(20240801));
        } else {
            System.out.println("해당 키(번호)는 없습니다.");
        }

        Set<Integer> keyset = students.keySet(); 
        if(students.containsValue("정홍찬")) {
            //? 순회하기
            for(Integer key : keyset) {
                if(students.get(key).equals("정홍찬")) {
                    System.out.println("정홍찬님의 학번은 " + key);
                }
            }
        }

        //? remove(key) 삭제하기
        students.remove(20240804);
        //? 삭제가 된지 확인
        System.out.println(students.containsKey(20240804)); //false

        //? values() 모든 값을 확인하기, keySets() 모든 키를 확인하기
        //? hashmap은 순서를 보장하지 않는다. 값을 가져오는데 순서가 필요없기 때문
        System.out.println("all values: " + students.values());
        System.out.println("all keys: " + students.keySet());

        //? 키를 기준으로 오름차순 정렬 
        ArrayList<Integer> keyList = new ArrayList<>(students.keySet());
        Collections.sort(keyList);
        for(Integer key : keyList) {
            System.out.println("학번 : " + key + " / 이름 : " + students.get(key));
        }

        //? 값을 기준으로 오름차순 정렬
        ArrayList<Integer> keyList2 = new ArrayList<>(students.keySet());
        //? 값을 얻으려면 키를 통해만 접근이 가능하다.

        //? 값을 기준으로 오름차순 정렬하기
        keyList2.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return students.get(o1).compareTo(students.get(o2)); //오름차순
                //return students.get(o2).compareTo(students.get(o1)); 내림차순
            }
        });

        System.out.println();

        for(Integer key: keyList2) {
            System.out.println("학번 : " + key + " / 이름 : " + students.get(key));
        }

        //? 요소의 총 개수
        System.out.println("해시맵의 크기: " + students.size());

        //? clear() : 모두 삭제, isEmpty(): 비어있는지 확인
        students.clear();
        System.out.println("isEmpty : " + students.isEmpty()); //? 비워졌는지 확인 true
    }
}
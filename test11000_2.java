import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class test11000_2 {

    static class Lesson implements Comparable<Lesson> {
        int start;
        int end;
        public Lesson(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(test11000_2.Lesson o) {
           if(this.start == this.end) {
                return this.end = o.end;
           }
           return this.start - o.start;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Lesson> lessons = new ArrayList<>();
        int n = Integer.parseInt(st.nextToken()); //강의 수
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lessons.add(new Lesson(start, end));
        }
        //강의시간 순서로 정렬
        Collections.sort(lessons);
        //강의 배정(강의 끝시간 <= 다른 강의 시작시간 : 같은 강의실 배정)
        //(강의 끝시간 > 다른 강의 시작 시간 : 다른 강의실 배정)
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        //강의를 하나하나 탐색하면서 배정할 수 있는 강의실을 확인
        for(Lesson le: lessons) {
            int end = le.end;
            if(!pq.isEmpty() && (pq.peek() <= le.start)) {
                //현재 강의 종료시간 <= 새로운 강의 시작시간 --> 같은 가의실을 배정(현재 강의실은 새로운 강의로 바뀜)
                pq.poll();
            }
            pq.add(end);
        }
        //필요한 최소 강의실의 개수 = 큐의 크기
        System.out.println(pq.size());
    }
}

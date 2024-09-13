import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueExample {

    static class Student {
        int grade; //학년
        int number; //학번
        
        public Student(int grade, int number) {
            this.grade = grade;
            this.number = number;
        }
    }

    static class StudentComparator implements Comparator<Student> {

        @Override
        public int compare(PriorityQueueExample.Student o1, PriorityQueueExample.Student o2) {
            if(o1.grade == o2.grade) {
                return o1.number - o2.number;
            }
            return o2.grade - o1.grade;
        }
    }

    //객체를 비교하는 방시 1. Comparator(자기와 상관없는 두 객체를 비교) 2. comparable(자기 객체와 다른객체를 비교)
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue();

        pq.offer(4);
        pq.offer(6);
        pq.offer(1);
        
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }

        System.out.println("--------------------");

        //최대 힙을 따르는 우선순위 큐?
        PriorityQueue<Integer> reversePq = new PriorityQueue<>(Collections.reverseOrder());

        reversePq.offer(4);
        reversePq.offer(6);
        reversePq.offer(1);

        while (!reversePq.isEmpty()) {
            System.out.println(reversePq.poll());
        }

        PriorityQueue<Student> studentPq = new PriorityQueue<>(1, new StudentComparator()); 
        studentPq.offer(new Student(1,10)); 
        studentPq.offer(new Student(3,5)); 
        studentPq.offer(new Student(3,2)); 
        while(!studentPq.isEmpty()) {
            Student st = studentPq.poll(); 
            System.out.println(st.grade + "학년-"+st.number +"번"); 
        } 
    }
}

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DS_Queue {

    public static void main(String[] args) {
        Queue<Integer> queue_int = new LinkedList<Integer>();
        Queue<String> queue_str = new LinkedList<String>();

        queue_int.add(1);
        System.out.println(queue_int.offer(2));
        System.out.println("queue_int = " + queue_int);

        System.out.println(queue_int.poll()); // 첫번째 값 반환
        System.out.println(queue_int.remove());// 첫번째 값 반환


        //ArrayList를 사용해서 큐의 Enqueue, Dequeue를 구현해보자 ->ArrayList_Queue클래스에 구현함

        System.out.println("큐 실행");
        ArrayList_Queue<Integer> queue = new ArrayList_Queue<Integer>();
        queue.enqueue(1);
        queue.enqueue(2);
        System.out.println("queue = " + queue);

        queue.dequeue();
        System.out.println("queue = " + queue);
        System.out.println("큐 실행 끝");

    }
}


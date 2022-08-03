package V9_Queue_Deque;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  public static void main(String[] args) {
    /*
     * Standard queue.
     */
    Queue<Integer> queue = new LinkedList<>();

    // add
    queue.offer(1);

    // preview
    queue.peek();

    // remove
    queue.poll();

    /*
     * Double directional queue.
     */
    Deque<Integer> deque = new LinkedList<>();

    // add
    deque.offerFirst(1);
    deque.offerLast(99);

    // preview
    deque.peekFirst();
    deque.peekLast();

    // remove
    deque.pollFirst();
    deque.pollLast();
  }
}

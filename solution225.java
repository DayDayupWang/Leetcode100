import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class solution225 {
    public static void main(String[] args) {

    }

}

class MyStack {
    // 和栈中保持一样元素的队列
    Queue<Integer> queue1;
    // 辅助队列，用于存放元素，排好序后把输出的元素
    Queue<Integer> queue2;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue2.offer(x);
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        Queue<Integer> queueTemp;
        queueTemp = queue1;
        queue1 = queue2;
        queue2 = queueTemp;
    }

    public int pop() {
        return queue1.poll();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }

}
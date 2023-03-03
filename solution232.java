import java.util.Stack;

public class solution232 {
    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(x);
        int param_2 = obj.pop();
        int param_3 = obj.peek();
        boolean param_4 = obj.empty();

    }

}

class MyQueue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>(); // 负责进栈
        stack2 = new Stack<>(); // 负责出栈
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        dumpStack1();

        return stack2.pop();
    }

    public int peek() {
        dumpStack1();
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    // 如果stack2为空，那么将stack1中的元素全部放到stack2中
    // stack2不为空时，搬入会影响顺序，是不对的
    public void dumpStack1() {// 搬空入队栈到出队栈
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());// 装进出队栈
            }
        }

    }
}
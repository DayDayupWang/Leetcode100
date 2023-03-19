import java.util.Stack;

import javax.lang.model.element.Element;

public class solution739 {
    public static void main(String[] args) {

    }

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        int[] res = new int[temperatures.length];

        for (int i = 1; i < temperatures.length; i++) {
            // 当前遍历的元素大于栈顶的元素
            if (temperatures[i] > temperatures[stack.peek()]) {
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    Integer pop = stack.pop();
                    res[pop] = i - pop;
                }
                stack.push(i);
                // 当前遍历的元素小于等于栈顶的元素
            } else {
                stack.push(i);
            }
        }
        return res;
    }
}

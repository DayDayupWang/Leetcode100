import java.util.Stack;

/**
 * 接雨水
 * solution42
 */
public class solution42 {
    public int trap(int[] height) {

        Stack<Integer> stack = new Stack<Integer>();
        int sum = 0;
        stack.push(0);
        for (int i = 1; i < height.length; i++) {
            if (height[i] < height[stack.peek()]) {
                stack.push(i);
            } else if (height[i] == height[stack.peek()]) {
                // pop走相邻的等高墙体
                stack.pop();
                stack.push(i);
            } else {
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    int mid = stack.pop();
                    if (!stack.isEmpty()) {
                        int left = stack.peek();
                        int h = Math.min(height[left], height[i]) - height[mid];
                        int w = i - left - 1;
                        sum += h * w;
                    }

                }
                stack.push(i);
            }
        }
        return sum;
    }
}
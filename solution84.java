import java.util.Stack;

public class solution84 {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        int result = 0;
        // 数组扩容，在头和尾各加入一个元素
        int[] newHeights = new int[heights.length + 2];
        newHeights[0] = 0;
        newHeights[newHeights.length - 1] = 0;
        for (int index = 0; index < heights.length; index++) {
            newHeights[index + 1] = heights[index];
        }

        heights = newHeights;

        for (int i = 1; i < heights.length; i++) {

            if (heights[i] > heights[stack.peek()]) {
                stack.push(i);
            } else if (heights[i] == heights[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                    int mid = stack.peek();
                    stack.pop();
                    int left = stack.peek();
                    int right = i;
                    int w = right - left - 1;
                    int h = heights[mid];
                    result = Math.max(result, w * h);
                }
                stack.push(i);
            }
        }
        return result;
    }

}

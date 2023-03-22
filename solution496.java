import java.util.HashMap;
import java.util.Stack;

public class solution496 {
    public static void main(String[] args) {

    }

   
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < result.length; i++) {
            result[i] = -1;
            map.put(nums1[i], i);
        }
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(nums2[0]);
        for (int i = 1; i < nums2.length; i++) {
            if (nums2[i] < stack.peek()) {
                stack.push(nums2[i]);

            } else if (nums2[i] == stack.peek()) {
                stack.push(nums2[i]);

            } else if (nums2[i] > stack.peek()) {
                while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                    if (map.containsKey(stack.peek())) {
                        result[map.get(stack.peek())] = nums2[i];
                    }

                    stack.pop();
                }
                stack.push(nums2[i]);
            }
        }
        return result;
    }
}

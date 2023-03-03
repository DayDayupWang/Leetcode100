public class Solution11 {
    public static void main(String[] args) {
        // int[] arr = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        int[] arr = { 1, 1 };
        int Area = maxArea(arr);
        System.out.println(Area);
    }

    public static int maxArea(int[] height) {
        int len = height.length;
        if (len <= 1) {
            return 0;
        }
        int left = 0;
        int right = len - 1;
        int mutongHeight = Math.min(height[right], height[left]);// 初始木桶高
        int MaxArea = (mutongHeight * (right - left));// 初始水量

        while (left < right) {
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
            MaxArea = Math.max((mutongHeight * (right - left)), MaxArea);

        }

        return MaxArea;
    }

}

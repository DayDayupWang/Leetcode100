public class solution977 {
    public static void main(String[] args) {

        int[] nums = { -4, -1, 0, 3, 10 };

        int[] Sorted = sortedSquares(nums);
        for (int i = 0; i < Sorted.length; i++) {
            System.out.println(Sorted[i]);
        }

    }

    public static int[] sortedSquares(int[] nums) {
        int left = 0;
        int len = nums.length;
        int right = len - 1;
        int[] arr = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            if (nums[left]* nums[left]<= nums[right]*nums[right]) {
                arr[i] = nums[right]*nums[right];
                right--;
            } else {
                arr[i] =nums[left]* nums[left];
                left++;
            }

        }
        return arr;
    }
}

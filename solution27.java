public class solution27 {
    public static void main(String[] args) {

        int[] nums = { 3, 2, 2, 3 };

        int val = 3;
        int length = removeElement(nums, val);
        System.out.println(length);
    }

    public static int removeElement(int[] nums, int val) {
        int count = 0;
        int len = nums.length;
        for (int i = len - 1; i >= 0; i--) {// 从后往前

            if (nums[i] == val) {// 最后一个开始等于val则
                count++;
                // 把这一位移到最后去，其他位前移;
                for (int j = i; j < len-1; j++) {
                    nums[j] = nums[j + 1];
                }
            }
        }
        return len - count;

    }
}


public class solution209 {
    public static void main(String[] args) {
        // int[] nums = { -1, 0, 3, 5, 9, 12 };
        // int[] nums = { 2, 3, 1, 2, 4, 3 };
        // int[] nums = { 1, 1, 1, 1, 1, 1, 1, 1 };
        int[] nums = { 1, 4, 4 };

        int target = 4;
        int minlen = minSubArrayLen(target, nums);
        System.out.println(minlen);
    }

    public static int minSubArrayLen(int target, int[] nums) {
        if (nums == null) {
            return 0;
        }
        int minlen = Integer.MAX_VALUE;
        int left = 0;
        // int right = 0;
        int len = nums.length;// 找到最初的合
        int sum = 0;// 定义最初的
        for (int right = 0; right < len; right++) {
            sum = sum + nums[right];
            while (sum >= target) {
                minlen = Math.min(right - left + 1, minlen);
                sum = sum - nums[left];
                left++;
            }


        }
        return minlen == Integer.MAX_VALUE ? 0 : minlen;// 假如没变化就输出0
    }
}

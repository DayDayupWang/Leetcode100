/**
 * solution35
 */
public class solution35 {
    public static void main(String[] args) {
        int[] nums = new int[] { 1, 3, 5, 6 };
        System.out.println(searchInsert(nums, 7));

    }

    public static int searchInsert(int[] nums, int target) {
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        if (target < nums[0]) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) / 2;
        while (left < right) {

            if (nums[mid] > target) {
                right = mid;

            } else if (nums[mid] < target) {
                left = mid + 1;

            } else {
                break;
            }
            mid = (left + right) / 2;
        }
        System.out.println(left);
        System.out.println(right);
        return mid;
    }

}
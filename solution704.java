
public class solution704 {
    public static void main(String[] args) {
        // int[] nums = { -1, 0, 3, 5, 9, 12 };
        int[] nums = { 5};
        int target = 5;
        int Index = search(nums, target);
        System.out.println(Index);
    }

    public static int search(int[] nums, int target) {
        int Index = -1;
        if (nums == null) {
            return Index;
        }
        int left = 0;
        int right = nums.length - 1;
        // int mid = (left + right) / 2;
        while (left <= right) {
           int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid-1;

            } else if (nums[mid] < target) {
                left = mid+1;
            } else if (nums[mid] == target) {
                Index = mid;
                break;
            }

        }

        return Index;
    }
}

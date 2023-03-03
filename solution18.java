import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * solution18
 */
public class solution18 {

    public static void main(String[] args) {
        int[] nums = { -3, -1, 0, 2, 4, 5 };
        System.out.println(fourSum(nums, 0));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length < 4 || 4 * nums[0] > target || 4 * nums[nums.length - 1] < target) {
            return result;
        }

        int a = 0;
        // int b = 1;
        // int c = nums.length - 2;
        int d = nums.length - 1;

        while (a + 2 < d && 4 * nums[a] <= target && 4 * nums[d] >= target) {
            int b = a + 1;// 定义内部左指针
            int c = d - 1;// 定义内部右指针
            int sum = nums[a] + nums[b] + nums[c] + nums[d];

            while (b + 1 < c) {
                sum = nums[a] + nums[b] + nums[c] + nums[d];
                if (sum > target) {
                    c--;// c一直移动到
                } else if (sum < target) {
                    b++;
                } else if (sum == target) {
                    result.add(Arrays.asList(nums[a], nums[b], nums[c], nums[d]));
                    while (c > b + 1 && nums[c] == nums[c - 1])
                        c--;
                    while (c > b + 1 && nums[b] == nums[b + 1])
                        b++;

                    c--;
                    b++;
                }
            }

            if (sum > target) {
                d--;
            } else if (sum < target) {
                a++;
            } else {
                while (d > c && nums[d] == nums[d - 1]) {
                    d--;
                }
                while (b > a && nums[a] == nums[a + 1]) {
                    a++;
                }
                d--;
                a++;
            }

        }
        return result;

    }
}

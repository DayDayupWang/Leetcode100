import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class solution15_1 {
    public static void main(String[] args) {
        int[] arr = { -1, 0, 1, 2, -1 };
        List<List<Integer>> sanyuanzu = threeSum(arr);
        System.out.println("---最后结果---");
        System.out.println(sanyuanzu);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 3)
            return res;
        Arrays.sort(nums); // 排序

        for (int i = 0; i < nums.length - 2; i++) {
            // 假如一开始大于0，和后面的就组不成
            if (nums[i] > 0) {
                return res;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    while (left < right && nums[left] == nums[left + 1]) {
                        left--;
                    }

                    right--;
                    left++;
                } else if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                }
            }
        }
        return res;
    }

}

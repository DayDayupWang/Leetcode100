import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;

/**
 * solution26
 */
public class solution26 {

    public static void main(String[] args) {
        int[] nums = new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        int[] nums1 = new int[] { 1, 2 };
        System.out.println(removeDuplicates(nums1));

    }

    public static int removeDuplicates(int[] nums) {
        int tmp = nums[0];
        int len = nums.length;
        int right = 1;
        for (int i = 1; i < len; i++) {

            while (nums[right] == tmp && right < nums.length - 1) {
                right++;
            }
            // 判断有效替换
            if (nums[i] == tmp) {
                len--;
            }
            nums[i] = nums[right];
            tmp = nums[i];

        }
        return len;
    }
}
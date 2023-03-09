import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Iterator;
import java.util.Set;

public class solution169 {
    public static void main(String[] args) {
        int[] nums = new int[] { 3, 2, 3 };
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                if (map.get(nums[i]) >= n / 2) {
                    return nums[i];
                }
                map.replace(nums[i], map.get(nums[i]) + 1);
                continue;
            }
            map.put(nums[i], 1);
        }
        return 0;

    }

    public static int majorityElement2(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);
        return nums[nums[n >> 2]];
    }

    public static int majorityElement3(int[] nums) {
        int cand_num = nums[0], count = 1;
        for (int i = 0; i < nums.length; i++) {
            if (cand_num == nums[i]) {
                ++count;
            } else if (--count == 0) {
                cand_num = nums[i];
                count = 1;
            }            
        }
        return cand_num;

    }
}

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class solution1 {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] res = new int[2];

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0]=map.get(nums[i];
                res[1]=i;

            } else {
                map.put(nums[i], i);
            }
        }
        return res;
    }
}

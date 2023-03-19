import java.lang.foreign.VaList;
import java.util.HashSet;

/**
 * compi04
 */
public class compi04 {

    public static void main(String[] args) {

    }

    public int findSmallestInteger(int[] nums, int value) {
        HashSet<Integer> set = new HashSet<Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > value ) {
                nums[i] = nums[i] % value;
            }
            set.add(nums[i]);
        }
        int min = value;
        for (int i = 0; i < value; i++) {
            if (set.contains(i)) {
                continue;
            }
            min = i < min ? i : min;
        }
        return min;
    }
}
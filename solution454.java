import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class solution454 {
    public static void main(String[] args) {
        int[] nums1 = new int[] { 1, 2 };
        int[] nums2 = new int[] { -2, -1 };
        int[] nums3 = new int[] { -1, 2 };
        int[] nums4 = new int[] { 0, 2 };
        int count = fourSumCount(nums1, nums2, nums3, nums4);
        System.out.println(count);
        // int[] nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2];
    }

    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> abMap = new HashMap<Integer, Integer>();

        int n = nums1.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                abMap.put(nums1[i] + nums2[j], abMap.getOrDefault(nums1[i] + nums2[j], 0) + 1);
            }
        }
        int count = 0;
        for (int k : nums3) {
            for (int q : nums4) {
                if (abMap.containsKey(-k - q)) {
                    count = count + abMap.get(-k - q);
                }
            }
        }
        return count;
    }

}

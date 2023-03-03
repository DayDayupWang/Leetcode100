import java.util.HashMap;
import java.util.Set;

public class solution136 {
    public static void main(String[] args) {
        int[] arr = { 4,2,2, 1, 1 };
        int SingleNum = singleNumber(arr);
        System.out.println(SingleNum);
    }

    public static int singleNumber(int[] nums) {
        int SingleNum = nums[0];// 从第一位开始
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.remove(nums[i]);
            } else {
                map.put(nums[i], i);
            }

        }
        // SingleNum = (int) map.values().toArray()[0];
        Set<Integer> key = map.keySet();
        for (Integer k : key) {
            SingleNum = k;
        }
        return SingleNum;
    }
}

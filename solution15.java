import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.Set;

public class solution15 {
    public static void main(String[] args) {
        int[] arr = { -1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4 };
        List<List<Integer>> sanyuanzu = threeSum(arr);
        System.out.println("---最后结果---");
        System.out.println(sanyuanzu);

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<List<Integer>>();

        HashMap<Integer, List<Integer>> Map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (i != j) {
                    for (int k = 2; k < nums.length; k++) {
                        if (j != k && i != k && nums[i] + nums[j] + nums[k] == 0) {
                            List<Integer> list = new ArrayList<Integer>(3);
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            // if (Map.containsKey(nums[i] ^ nums[j] ^ nums[k])) {
                            //     break;
                            // }else{
                                System.out.println((nums[i]) ^ (nums[j]) );
                                Map.put((nums[i]) ^ (nums[j]), list);
                            // }
                        
                            // if (Map.isEmpty()) {
                            
                            // } else {
                            // Set<Integer> keyset = Map.keySet();
                            // for (int YiHuo : keyset) {
                            // int flag = nums[i] ^ nums[j] ^ nums[k] ^ YiHuo;
                            // if (flag == 0) {// 如果存在重复的就不添加了
                            // break;
                            // } else {
                            // Map.put(nums[i] ^ nums[j] ^ nums[k], list);
                            // }
                            // }

                            // }
                        } else {
                            continue;
                        }
                    }

                } else {
                    continue;

                }

            }

        }
        Set<Integer> keyset = Map.keySet();
        for (Integer integer : keyset) {
            answer.add(Map.get(integer));
        }
        return answer;
    }
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class solution349 {
    public void jiaoji() {

    }

    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> map1 = new HashSet<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            map1.add(nums1[i]);
        }
        HashSet<Integer> tmp = new HashSet<Integer>();

        for (int i = 0; i < nums2.length; i++) {
            if (map1.contains(nums2[i])) {
                tmp.add(nums2[i]);

            }
        }

        int[] res = new int[tmp.size()];

        int j = 0;
        for (Integer integer : tmp) {

            res[j] = integer.intValue();
            j++;
        }

        return res;
    }
}

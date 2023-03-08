import java.util.HashSet;

public class solution3 {
    public static void main(String[] args) {

    }

    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> occ = new HashSet<Character>();
        int left = 0;
        int right = 0;
        int max = 0;
        for (; right < s.length(); right++) {
            char charAt = s.charAt(right);
            while (occ.contains(charAt)) {
                occ.remove(s.charAt(left));
                left++;
            }
            occ.add(charAt);
            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}

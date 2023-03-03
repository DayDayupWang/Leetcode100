
import java.util.HashMap;
import java.util.Iterator;


public class solution242 {
    public static void main(String[] args) {
        String s = "anagramqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqaq";
        String t = "nagaramqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqdq";
        // String s = "rat";
        // String t = "car";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sArr = s.toCharArray();
        HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
        for (char c : sArr) {
            if (map1.containsKey(c)) {
                map1.put(c, map1.get(c) + 1);
            } else {
                map1.put(c, 1);
            }
        }
        char[] tArr = t.toCharArray();
        HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();
        for (char q : tArr) {
            if (map2.containsKey(q)) {
                map2.put(q, map2.get(q) + 1);

            } else {
                map2.put(q, 1);
            }

        }
        Iterator<HashMap.Entry<Character, Integer>> it = map1.entrySet().iterator();
        while (it.hasNext()) {
            HashMap.Entry<Character, Integer> next = it.next();
            if (map2.get(next.getKey()) != next.getValue()) {
                return false;
            }

        }
        return true;
    }
}

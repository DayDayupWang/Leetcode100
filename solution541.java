public class solution541 {
    public static void main(String[] args) {
       String s = "abcd";
       int k = 2;
      System.out.println(reverseStr(s, k)); 

    }

    public static String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        int start = 0;
        while (len >= 2 * k) {
            String subS = s.substring(start, start + k );// ab
            String comS=s.substring(start + k, start+2*k);
            char[] charmap = subS.toCharArray();
            char[] charArray = comS.toCharArray();
            switchCharArr(charmap);
            for (char c : charmap) {
                sb.append(c);
            }
            for (char c : charArray) {
                sb.append(c);
            }

            len = len - 2 * k;
            start = start + 2 * k;
        }
        // 判断剩余的部分
        String finalS = s.substring(start);
        if (finalS.length() < k) {
            char[] charmap = finalS.toCharArray();
            switchCharArr(charmap);
            for (char c : charmap) {
                sb.append(c);
            }
        } else if (finalS.length() >= k) {
            String subS = s.substring(start, start + k);// ab
            char[] charmap = subS.toCharArray();
            String comS=s.substring(start + k);
            char[] charArray = comS.toCharArray();
            switchCharArr(charmap);
            for (char c : charmap) {
                sb.append(c);
            }
            for (char c : charArray) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void switchCharArr(char[] charmap) {
        int len = charmap.length;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            char tmp = charmap[left];

            charmap[left] = charmap[right];
            charmap[right] = tmp;
            right--;
            left++;
        }
    }

}

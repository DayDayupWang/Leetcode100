import java.security.DrbgParameters.Reseed;

/**
 * offerSolution58_2
 */
public class offerSolution58_2 {

    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        String res = reverseLeftWords(s, k);
        System.out.println(res);

    }

    public static String reverseLeftWords(String s, int n) {
        char[] charArray = s.toCharArray();
        StringBuilder tmp = new StringBuilder();

        for (int i = n; i < charArray.length; i++) {
            tmp.append(charArray[i]);
        }
        for (int i = 0; i < n; i++) {
            tmp.append(charArray[i]);
        }
        return tmp.toString();
    }
}
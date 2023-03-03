public class offerSolution05 {
    public static void main(String[] args) {
        String s = "We are happy.";
        String space = " ";
        // System.out.println(space);
        String res = replaceSpace(s);
        System.out.println(res);
    }

    public static String replaceSpace(String s) {
        char[] charArray = s.toCharArray();
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == ' ') {
                res.append('%');
                res.append('2');
                res.append('0');
            } else {
                res.append(charArray[i]);
            }

        }

        return res.toString();
    }
}

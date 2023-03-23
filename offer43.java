public class offer43 {

    public static void main(String[] args) {

        
    }

    public int countDigitOne(int n) {

        
        int[] counter1 = new int[n];

        int count = 0;
        for (int i = 0; i < n; i++) {
            String string = Integer.toString(n);

            for (int j = string.length() - 1; j >= 0; j--) {
                if (string.charAt(j) == '1') {

                    count++;
                }

            }
        }

    }
}

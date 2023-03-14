public class cowsolution2 {
    public int minCake(int n, int a, int b) {
        // write code here

        int[][] dp = new int[n + 1][n + 1];
        if (n <= 1) {
            return 0;
        }
        if (n == 2) {
            return a > b ? b : a;
        }

        if ((a + b) / n < 2) {
            return 0;
        }
        if ((a + b) / n == 2 && (a + b) % 2 == 0) {
            if (a % 2 == 1) {
                return 0;
            } else {
                return 2;
            }
        }
        int res=Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            if (a%i==0&&b%(n-i)==0) {
             res= Math.min(res, Math.min(a/i, b/i)) ;
            }
        }
       return res;

    }
}

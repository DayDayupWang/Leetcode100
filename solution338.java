
public class solution338 {
    public static void main(String[] args) {

    }

    public int[] countBits(int n) {
        int[] res = new int[n + 1];

        // return recursiveCount(n, res);

        while (n >= 0) {
            res[n] = Integer.bitCount(n);
            n--;

        }
        return res;
    }

    public int[] recursiveCount(int n, int[] res) {
        if (n == 0) {
            res[0] = 0;

            return res;
        } else {
            res[n] = Integer.bitCount(n);
            n--;
            recursiveCount(n, res);
        }
    }
}

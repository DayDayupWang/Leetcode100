import java.util.HashMap;

public class solution70 {
    public static void main(String[] args) {

    }

    public int climbStairs(int n) {
        HashMap<Integer, Integer> Csmap = new HashMap<Integer, Integer>();
        int count = Recur(n, Csmap);
        return count;
    }

    public int Recur(int n, HashMap<Integer, Integer> Csmap) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n > 2) {
            // if (!Csmap.containsKey(n - 1)) {
            // Integer num = Recur(n - 1);
            // Csmap.put(n - 1, num);
            // }
            if (!Csmap.containsKey(n)) {
                Csmap.put(n, Recur(n - 1, Csmap) + Recur(n - 2, Csmap));
            }

            return Csmap.get(n);
        }
        return 0;
    }

}

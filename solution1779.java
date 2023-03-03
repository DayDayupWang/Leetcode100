import java.util.HashMap;

/**
 * solution1779
 */
public class solution1779 {

    public static void main(String[] args) {

    }

    public int nearestValidPoint(int x, int y, int[][] points) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = points.length - 1; i >= 0; i--) {
            if (x - points[i][0] == 0 || y - points[i][1] == 0) {
                map.put(Math.abs(x - points[i][0]) + Math.abs(y - points[i][1]), i);
            }
        }
        int ans = -1;
        int min = Integer.MAX_VALUE;
        for (int key : map.keySet()) {
            if (min > key) {
                ans = map.get(key);
                min = key;
            }
        }
        return ans;
    }

    // public int nearestValidPoint(int x, int y, int[][] points) {
    // int left = -1;
    // int i = 0;
    // int ManDist = Integer.MAX_VALUE;
    // while (i < points.length) {

    // if (x - points[i][0] == 0 || y - points[i][1] == 0) {
    // int Nowdist = Math.abs(x - points[i][0]) + Math.abs(y - points[i][1]);
    // if (ManDist > Nowdist) {
    // left = i;
    // ManDist=Nowdist;
    // }
    // }
    // i++;
    // }
    // return left;
    // }

}

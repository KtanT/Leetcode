import java.util.HashMap;
import java.util.Map;

/**
 * 
 */

/**
 * @author Kyran
 */
public class NumberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        if (points.length == 0 || points[0].length == 0) {
            return 0;
        }

        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }

                int d = getDistance(points[i], points[j]);
                map.put(d, map.getOrDefault(d, 0) + 1);
            }

            for (int val : map.values()) {
                result += val * (val - 1);  //C[n,2] * 2
            }
            map.clear();
        }

        return result;
    }

    private int getDistance(int[] a, int[] b) {
        int dx = a[0] - b[0];
        int dy = a[1] - b[1];

        return dx * dx + dy * dy;
    }
}

import java.util.Arrays;
import java.util.Comparator;

public class KclosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int K) {

        if(points.length < K) return points;


        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                double d1 = Math.sqrt(o1[0]*o1[0] + o1[1]*o1[1]);
                double d2 = Math.sqrt(o2[0]*o2[0] + o2[1]*o2[1]);

                if(d1 > d2) return 1;
                if(d1<d2) return -1;

                return 0 ;
            }
        });




        return Arrays.copyOfRange(points, 0, K);
    }
}

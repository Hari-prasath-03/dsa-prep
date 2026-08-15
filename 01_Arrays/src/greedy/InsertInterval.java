package greedy;

import utils.Arrays2D;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> list = new ArrayList<>();

        int i = 0;
        while (i < n && intervals[i][1] < newInterval[0]) {
            list.add(intervals[i++]);
        }

        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        list.add(newInterval);

        while (i < n) {
            list.add(intervals[i++]);
        }

        return list.toArray(int[][]::new);
    }

    public static void main(String[] args) {
        int[][] t1i = {{1,3},{6,9}};
        int[] t1ni = {2, 5};

        int[][] t2i = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] t2ni = {4,8};

        Arrays2D.print2dArray(insert(t1i, t1ni));
        Arrays2D.print2dArray(insert(t2i, t2ni));
    }
}

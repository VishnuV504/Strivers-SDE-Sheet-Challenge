import java.util.*;
import java.io.*;
/*******************************************************

    Following is the Interval class structure

    class Interval {
        int start, int finish;

        Interval(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
    }
    
*******************************************************/

import java.util.List;
import java.util.ArrayList;

public class Solution {
    public static List<Interval> mergeIntervals(Interval[] intervals) {
        // write your code here.
        List<Interval> li = new ArrayList<>();
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1.start, i2.start));
        int n = intervals.length;
        int first = intervals[0].start;
        int second = intervals[0].finish;
        for (int i = 1; i < n; i++) {
            if (intervals[i].start <= second)
                second = Math.max(second, intervals[i].finish);
            else {
                li.add(new Interval(first, second));
                first = intervals[i].start;
                second = intervals[i].finish;
            }
        }
        li.add(new Interval(first, second));
        return li;

    }
}

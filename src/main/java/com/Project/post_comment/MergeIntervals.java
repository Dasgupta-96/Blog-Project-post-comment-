package com.Project.post_comment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

  public static void main(String[] args) {

    int[][] intervals = {
      {1, 3},
      {2, 6},
      {8, 10},
      {9, 12}
    };

    System.out.println(Arrays.deepToString(findMergeIntervals(intervals)));
  }

  private static int [][] findMergeIntervals(int[][] intervals) {

    Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

    List<int[]> result = new ArrayList<>(); // [1,3] [2,6],[8,10]. [9,12]

    int[] newInterval = intervals[0];

    result.add(newInterval);

    for (int[] interval : intervals) {

      if (interval[0] <= newInterval[1]) {

        newInterval[1] = Math.max(newInterval[1], interval[1]);

      } else {
        newInterval = interval;
        result.add(newInterval);
      }

    }
    return result.toArray(new int[result.size()][]);


  }
}

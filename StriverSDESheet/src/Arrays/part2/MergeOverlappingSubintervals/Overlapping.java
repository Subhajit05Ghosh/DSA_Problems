package Arrays.part2.MergeOverlappingSubintervals;

import java.util.*;

public class Overlapping {


    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
//Input format
        int n = sc.nextInt();
        int input[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            int sp = sc.nextInt();
            int ep = sc.nextInt();
            input[i][0] = sp;
            input[i][1] = ep;
        }
        int[][] output = mergeIntervals(input);
        System.out.print("[");
        for (int arr[] : output) {
            System.out.println(Arrays.toString(arr));
        }
        System.out.print("]");
    }

    private static int[][] mergeIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        ArrayList<int[]> ar = new ArrayList<>();
        for (int[] interval : intervals) {
            if (ar.size() == 0) {
                ar.add(interval);
            } else {
                int[] prevInterval = ar.get(ar.size() - 1);
                if (interval[0] < prevInterval[1]) {
                    prevInterval[1] = Math.max(interval[1], prevInterval[1]);
                } else {
                    ar.add(interval);
                }
            }
        }
        return ar.toArray(new int[ar.size()][]);
    }
}
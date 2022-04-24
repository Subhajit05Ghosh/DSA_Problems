package ArrayProblems.in.Triplets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletsLeetCode {
    public static void main(String[] args) {
        int arr[] = {-1, 0, 1, 2, -1, -4};
        int target = 0;
        List<List<Integer>> al=triplets(arr,target);
        System.out.println(al.toString());
    }

    private static List<List<Integer>> triplets(int[] arr, int target) {
        Arrays.sort(arr);
        int n = arr.length;
        List<List<Integer>> output_arr = new ArrayList<>();
        for (int i = 0; i < n - 2; i++) {
            if (i == 0 || (i > 0) && arr[i] != arr[i - 1]) {
                int high = n - 1;
                int low = 0;
                while (low < high) {
                    if (arr[i] + arr[high] + arr[low] == target) {
                        output_arr.add(Arrays.asList(arr[i], arr[high], arr[low]));
                        while(low<high && arr[low]==arr[low+1])
                            low++;
                        while(low<high && arr[high]==arr[high-1])
                            high--;
                        low++;
                        high--;
                    } else if (arr[i] + arr[high] + arr[low] > target) {
                        high--;
                    } else {
                        low++;
                    }
                }
            }
        }
            return output_arr;
        }

}

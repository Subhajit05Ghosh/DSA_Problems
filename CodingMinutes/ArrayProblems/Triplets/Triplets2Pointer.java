package ArrayProblems.in.Triplets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Triplets2Pointer {
    public static void main(String[] args) {
        //int arr[]={1,2,3,4,5,6,7,8,9,15};
        //int target=18;
        int arr[] = {-1, 0, 1, 2, -1, -4};
        int target = 0;
        // List aList=Arrays.asList(arr);
        // Collections.addAll(aList, arr);
        List aList = new ArrayList();
        for (int a = 0; a < arr.length; a++) {
            aList.add(arr[a]);
        }
        List<List<Integer>> result = triplets(aList, target);
        System.out.println(result);
    }

    private static List<List<Integer>> triplets(List<Integer> aList, int target) {
        int n = aList.size();
        Collections.sort(aList);
        //List<List<Integer>> resultset=new ArrayList<>();
        List<List<Integer>> resultset = new ArrayList<>();
        for (int i = 0; i <= n - 3; i++) {
            if (i == 0 || (i > 0) && aList.get(i) != aList.get(i - 1)) {
                int j = i + 1;
                int k = n - 1;
                while (j < k) {
                    int currentSum = aList.get(i);
                    currentSum += aList.get(j);
                    currentSum += aList.get(k);
                    if (currentSum == target) {
                        // resultset.add(Collections.singletonList(aList.get(i)));
                        List<Integer> list = new ArrayList<>();
                        list.add(aList.get(i));
                        list.add(aList.get(j));
                        list.add(aList.get(k));
                        resultset.add(list);
                        while (j < k && aList.get(j) == aList.get(j + 1)) {
                            j++;
                        }
                        while (j < k && aList.get(k) == aList.get(k - 1)) {
                            k--;
                        }
                        j++;
                        k--;
                    } else if (currentSum > target) {
                        k--;
                    } else {
                        j++;
                    }
                }
            }
        }
        return resultset;
    }
}

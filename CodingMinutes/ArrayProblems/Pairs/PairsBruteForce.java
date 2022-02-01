package ArrayProblems.in.Pairs;

public class PairsBruteForce {
    public static void main(String[] args) {
        int arr[] = {10, 5, 2, 3, -6, 9, 11};
        int sum = 4;
        int result[] = reqPairs(arr, sum);
        System.out.println(result[0] + " " + result[1]);
    }

    private static int[] reqPairs(int[] arr, int sum) {
        int target = 0;
        for (int i = 0; i < arr.length; i++) {
            target = sum - arr[i];
            for (int j = i; j < arr.length; j++) {
                if (target == arr[j]) {
                    return new int[]{arr[i], arr[j]};
                }
            }
        }
        return new int[]{-1, -1};
    }
}

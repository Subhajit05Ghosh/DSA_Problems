package ArrayProblems.in.SubarraySort;

import java.util.Arrays;

public class SubArrSort1 {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,8,7,9,10,11};
        int pos[]=subArrSort(arr);
        System.out.println(pos[0]+" "+pos[1]);
    }
    private static int[] subArrSort(int arr[]){
        int i=0;
        int n=arr.length;
        int array[]=new int[arr.length];
        System.arraycopy(arr,0,array,0,arr.length);
        Arrays.sort(array);
        while(i<n && arr[i]==array[i]){
        i++;
        }
        int j=arr.length-1;
        while(j>=0 && arr[j]==array[j]){
            j--;
        }
        if(i==arr.length){
            return new int[]{-1,-1};
        }
        return new int[]{i,j};
    }
}

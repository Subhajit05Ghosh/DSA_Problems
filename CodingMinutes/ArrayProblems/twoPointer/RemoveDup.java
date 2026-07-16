package ArrayProblems.in.twoPointer;

import java.util.Arrays;

public class RemoveDup {
    public static void main(String[] args) {
        int arr[]={1,2,2,3,4,4,4,5,5,6,6,7};
        removeDuplicates(arr);
    }

    private static void removeDuplicates(int[] arr) {
        int i=0;
        for(int j=1;j< arr.length;j++){
            if(arr[i]!=arr[j]){
                i++;
                arr[i]=arr[j];
            }
        }
        System.out.println(Arrays.toString(Arrays.copyOf(arr,i+1)));
    }
}

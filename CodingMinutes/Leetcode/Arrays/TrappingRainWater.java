package Leetcode.Arrays;
//https://leetcode.com/problems/trapping-rain-water/
public class TrappingRainWater {
    public static void main(String[] args) {
    int height[] = {0,1,0,2,1,0,1,3,2,1,2,1};
    int water=trap(height);
    System.out.println(water);
    }

    private static int trap(int[] height) {
        int water=0;
        int i=0;
        int j=height.length-1;
        int maxRight=0,maxLeft=0;
        while(i<j){
            if(height[i]<=height[j]){
             maxLeft=Math.max(maxLeft,height[i]);
             water+=maxLeft-height[i];
             i++;
            }
            else{
            maxRight=Math.max(maxRight,height[j]);
            water+=maxLeft-height[j];
            j--;
            }
        }
        return water;
    }
}

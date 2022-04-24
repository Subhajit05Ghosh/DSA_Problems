//https://leetcode.com/problems/trapping-rain-water/
package Leetcode.Arrays;

public class TrappingRainWater2 {
    public static void main(String[] args) {
        int height[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int water = trap(height);
        System.out.println(water);
    }

    private static int trap(int[] height) {
        int water = 0;
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                leftMax[0] = height[0];
                rightMax[n-1] = height[n - 1];
            } else {
                leftMax[i] = Math.max(leftMax[i - 1], height[i]);
                rightMax[n-i-1] = Math.max(rightMax[n-i ], height[n-i-1]);
            }
        }
        for (int i = 0; i < n; i++) {
            water += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return water;
    }
}

package Arrays.part1.StocksBuySell;

public class StocksBuySell1 {
    public static void main(String[] args) {
        int a[]={5,2,6,1,4};
        int profit=maxProfit(a);
        System.out.println(profit);
    }

    private static int maxProfit(int[] a) {
        int maxProfit=0;
        int minSoFar=a[0];
        for(int i=0;i<a.length;i++){
        minSoFar=Math.min(minSoFar,a[i]);
        int profit=a[i]-minSoFar;
        maxProfit=Math.max(maxProfit,profit);
        }
        return maxProfit;
    }
}

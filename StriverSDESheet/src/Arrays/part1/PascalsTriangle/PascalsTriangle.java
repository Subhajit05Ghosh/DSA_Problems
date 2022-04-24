package Arrays.part1.PascalsTriangle;
import java.util.*;
public class PascalsTriangle {
    public static void main(String[] args) {
        int row=5;
        List<List<Integer>> result=pascalTriangle(row);
        System.out.println(result.toString());
    }

    private static List<List<Integer>> pascalTriangle(int rowNum) {
        List<List<Integer>> triangle=new ArrayList<>();
        if(rowNum==0)
            return triangle;
        List<Integer> first_row=new ArrayList<>();
        first_row.add(1);
        triangle.add(first_row);
        for(int i=1;i<rowNum;i++){
            List<Integer> prev_row=triangle.get(i-1);
            List<Integer> row=new ArrayList<>();
            row.add(1);
            for(int j=1;j<i;j++){
                row.add(prev_row.get(j-1)+prev_row.get(j));
            }
            row.add(1);
            triangle.add(row);
        }

        return triangle;
    }
}

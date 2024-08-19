import java.util.*;

public class Q3143正方形中的最多点数_数组实现 {

    public int maxPointsInsideSquare(int[][] points, String s) {
        int[][] list = new int[26][2];
        Arrays.setAll(list,i->new int[]{Integer.MAX_VALUE,Integer.MAX_VALUE});

        for(int i=0;i<points.length;i++){
            int bigger = Math.max(Math.abs(points[i][0]),Math.abs(points[i][1]));
            int index = s.charAt(i) - 'a';

            if(bigger <= list[index][0]){
                list[index][1] = list[index][0];
                list[index][0] = bigger;
            } else if (bigger < list[index][1]) {
                list[index][1] = bigger;
            }

        }

        System.out.println(Arrays.deepToString(list));
        System.out.println();

        int max=Integer.MAX_VALUE;
        for(int i=0;i<26;i++){
            max = Math.min(list[i][1]-1,max);

        }

        int ans = 0;
        for(int i=0;i<points.length;i++){
            int bigger = Math.max(Math.abs(points[i][0]),Math.abs(points[i][1]));
            if(bigger <= max) ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Q3143正方形中的最多点数_数组实现 solution = new Q3143正方形中的最多点数_数组实现();
        System.out.println(solution.maxPointsInsideSquare(new int[][]{{2,2},{-1,-2},{-4,4},{-3,1},{3,-3}},"abdca"));
    }
}
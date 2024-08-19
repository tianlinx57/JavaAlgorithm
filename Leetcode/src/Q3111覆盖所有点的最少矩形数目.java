import java.util.Arrays;

public class Q3111覆盖所有点的最少矩形数目 {

    public int minRectanglesToCoverPoints(int[][] points, int w) {
        int n = points.length;
        int[] list = new int[n];
        for(int i=0;i<n;i++){
            list[i] = points[i][0];
        }
        Arrays.sort(list);

        int ans = 0;
        int i=0;
        int target = 0;
        while(true){
            ans++;
            target = list[i]+w;
            while (true){
                ++i;
                if(i>= list.length||list[i]>target){
                    break;
                }
            }
            if (i>= list.length) break;
        }
        return ans;
    }


    public static void main(String[] args) {
        Q3111覆盖所有点的最少矩形数目 solution = new Q3111覆盖所有点的最少矩形数目();
        System.out.println(solution.minRectanglesToCoverPoints(new int[][]{{2,1},{1,0},{1,4},{1,8},{3,5},{4,6},},1));
    }
}
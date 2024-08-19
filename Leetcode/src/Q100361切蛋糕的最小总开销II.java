import java.util.Arrays;

public class Q100361切蛋糕的最小总开销II {
    public long minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        // 计算蛋糕的总开销
        long sum = Arrays.stream(verticalCut).sum();
        sum += Arrays.stream(horizontalCut).sum();

        // 排序
        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);
        int i=0,j=0;
        // 遍历蛋糕
        while (i<=m-2 && j<=n-2){
            // 如果水平切割线小于垂直切割线，则按照垂直切割线计算开销
            if(horizontalCut[m-2-i] <= verticalCut[n-2-j]){
                sum += verticalCut[n-2-j]*i;
                ++j;
            } else {
                // 否则按照水平切割线计算开销
                sum += horizontalCut[m-2-i]*j;
                ++i;
            }
        }
        // 计算剩余的蛋糕
        while (i<=m-2){
            sum += horizontalCut[m-2-i]*j;
            ++i;
        }
        while (j<=n-2){
            sum += verticalCut[n-2-j]*i;
            ++j;
        }
        return sum;
    }
    public static void main(String[] args) {
        Q100361切蛋糕的最小总开销II solution = new Q100361切蛋糕的最小总开销II();
        // System.out.println(solution.numberOfSubmatrices(new char[][]{{'X','Y','.'},{'Y','.','.'}}));
        // System.out.println(solution.minimumCost(3,2,new int[]{1,3},new int[]{5}));
        System.out.println(solution.minimumCost(6,3,new int[]{2,3,2,3,1},new int[]{1,2}));
    }
}
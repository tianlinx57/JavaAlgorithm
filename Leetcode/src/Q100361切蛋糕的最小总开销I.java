import java.util.Arrays;
import java.util.HashSet;

public class Q100361切蛋糕的最小总开销I {
    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        int sum = Arrays.stream(verticalCut).sum();
        sum += Arrays.stream(horizontalCut).sum();
        for(int i=0;i<n-1;i++){
            for(int j=0;j<m-1;j++){
                if(horizontalCut[j]<=verticalCut[i]){
                    sum += horizontalCut[j];
                }else {
                    sum += verticalCut[i];
                }
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        Q100361切蛋糕的最小总开销I solution = new Q100361切蛋糕的最小总开销I();
        // System.out.println(solution.numberOfSubmatrices(new char[][]{{'X','Y','.'},{'Y','.','.'}}));
        System.out.println(solution.minimumCost(3,2,new int[]{1,3},new int[]{5}));
    }
}
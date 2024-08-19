import java.util.Arrays;

public class Q1_week409设计相邻元素求和服务 {
    class neighborSum {
        int[][] nums;
        int n=0;

        public neighborSum(int[][] grid) {
            n = grid.length;
            nums = new int[n][n];
            for (int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++){
                    nums[i][j] = grid[i][j];
                }
            }
        }

        public int adjacentSum(int value) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++){
                    if(nums[i][j] == value){
                        if(i!=0){
                            sum += nums[i-1][j];
                        }
                        if(i!=n-1){
                            sum += nums[i+1][j];
                        }
                        if(j!=0){
                            sum += nums[i][j-1];
                        }
                        if(j!=n-1){
                            sum += nums[i][j+1];
                        }
                    }
                }
            }
            return sum;
        }

        public int diagonalSum(int value) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++){
                    if(nums[i][j] == value){
                        if(i>0 && j>0){
                            sum += nums[i-1][j-1];
                        }
                        if(i>0 && j<n-1){
                            sum += nums[i-1][j+1];
                        }
                        if(i<n-1 && j>0){
                            sum += nums[i+1][j-1];
                        }
                        if(i<n-1 && j<n-1){
                            sum += nums[i+1][j+1];
                        }
                    }
                }
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        Q1_week409设计相邻元素求和服务 solution = new Q1_week409设计相邻元素求和服务();

        // System.out.println(Arrays.toString(solution.occurrencesOfElement(new int[]{1,3,1,7}, new int[]{1,3,2,4},1)));
    }
}
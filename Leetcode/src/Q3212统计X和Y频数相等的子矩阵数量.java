import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q3212统计X和Y频数相等的子矩阵数量 {
    public int numberOfSubmatrices(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp_x = new int[n][m];
        int[][] dp_y = new int[n][m];
        if(grid[0][0] == 'X'){
            ++dp_x[0][0];
        }
        if(grid[0][0] == 'Y'){
            ++dp_y[0][0];
        }

        for(int i=1;i<m;i++){
            if(grid[0][i] == 'X'){
                dp_x[0][i] = dp_x[0][i-1]+1;
            } else {
                dp_x[0][i] = dp_x[0][i-1];
            }
            if(grid[0][i] == 'Y'){
                dp_y[0][i] = dp_y[0][i-1]+1;
            } else {
                dp_y[0][i] = dp_y[0][i-1];
            }
        }

        for(int i=1;i<n;i++){
            if(grid[i][0] == 'X'){
                dp_x[i][0] = dp_x[i-1][0]+1;
            } else {
                dp_x[i][0] = dp_x[i-1][0];
            }
            if(grid[i][0] == 'Y'){
                dp_y[i][0] = dp_y[i-1][0]+1;
            } else {
                dp_y[i][0] = dp_y[i-1][0];
            }
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                int temp = dp_x[i-1][j] + dp_x[i][j-1] - dp_x[i-1][j-1] ;
                if(grid[i][j] == 'X'){
                    dp_x[i][j] = temp+1;
                } else {
                    dp_x[i][j] = temp;
                }
                temp = dp_y[i-1][j] + dp_y[i][j-1] - dp_y[i-1][j-1] ;
                if(grid[i][j] == 'Y'){
                    dp_y[i][j] = temp+1;
                } else {
                    dp_y[i][j] = temp;
                }
            }
        }
        // System.out.println(Arrays.deepToString(dp_x));
        // System.out.println(Arrays.deepToString(dp_y));

        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(dp_x[i][j] == dp_y[i][j] && dp_x[i][j] >= 1){
                    ++ans;
                }
            }
        }
        return ans;


    }


    public static void main(String[] args) {
        Q3212统计X和Y频数相等的子矩阵数量 solution = new Q3212统计X和Y频数相等的子矩阵数量();
        // System.out.println(solution.numberOfSubmatrices(new char[][]{{'X','Y','.'},{'Y','.','.'}}));
        System.out.println(solution.numberOfSubmatrices(new char[][]{{'.','.'},{'Y','X'}}));
    }
}
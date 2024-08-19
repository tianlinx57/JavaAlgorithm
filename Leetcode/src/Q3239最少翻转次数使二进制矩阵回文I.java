public class Q3239最少翻转次数使二进制矩阵回文I {
    public int minFlips(int[][] grid) {
        return Math.min(hang(grid),lie(grid));
    }

    int hang(int[][] grid){
        int ans = 0;
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0;i<n;i++){
            int left=0,right=m-1;
            while(left<=right){
                if(grid[i][left]!=grid[i][right]){
                    ans++;
                }
                left++;
                right--;
            }
        }
        return ans;
    }

    int lie(int[][] grid){
        int ans = 0;
        int n = grid.length;
        int m = grid[0].length;
        for(int j=0;j<m;j++){
            int top=0,bot=n-1;
            while(top<=bot){
                if(grid[top][j]!=grid[bot][j]){
                    ans++;
                }
                top++;
                bot--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Q3239最少翻转次数使二进制矩阵回文I solution = new Q3239最少翻转次数使二进制矩阵回文I();

        System.out.println(solution.minFlips(new int[][]{{1,0,0}, {0,0,0}, {0,0,1}} ));
    }
}
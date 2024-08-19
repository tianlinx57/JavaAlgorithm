public class Q3240最少翻转次数使二进制矩阵回文II {
    public int minFlips(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int hang = n/2;
        int lie = m/2;

        int ans = 0;
        for(int i=0;i<hang;i++){
            for(int j=0;j<lie;j++){
                int count = 0;
                if(grid[i][j] == 1){
                    ++count;
                }
                if(grid[i][m-j-1] == 1){
                    ++count;
                }
                if(grid[n-i-1][j] == 1){
                    ++count;
                }
                if(grid[n-i-1][m-j-1] == 1){
                    ++count;
                }
                if(count>2){
                    ans += 4-count;
                }else {
                    ans += count;
                }
            }
        }

        if(n%2==1 && m%2==1){
            if(grid[hang][lie] == 1){
                ans++;
            }
        }

        int count10 = 0, count11 = 0;
        if(m%2==1){
            for(int i=0;i<hang;i++){
                if(grid[i][lie] == 1 && grid[n-1-i][lie] == 1) {
                    ++count11;
                }
                if(grid[i][lie] == 0 && grid[n-1-i][lie] == 1 || grid[i][lie] == 1 && grid[n-1-i][lie] == 0) {
                    ++count10;
                }
            }
        }

        if(n%2 == 1){
            for(int i=0;i<lie;i++) {
                if (grid[hang][i] == 1 && grid[hang][m - 1 - i] == 1) {
                    ++count11;
                }
                if(grid[hang][i] == 1 && grid[hang][m - 1 - i] == 0 || grid[hang][i] == 0 && grid[hang][m - 1 - i] == 1) {
                    ++count10;
                }
            }
        }

        ans += count10;
        if(count10 == 0 && count11%2 == 1){
            ans += 2;
        }


        return ans;
    }


    public static void main(String[] args) {
        Q3240最少翻转次数使二进制矩阵回文II solution = new Q3240最少翻转次数使二进制矩阵回文II();

        // System.out.println(solution.minFlips(new int[][]{{0,1}, {0,1}, {0,0}} ));
        System.out.println(solution.minFlips(new int[][]{{0}} ));
    }
}
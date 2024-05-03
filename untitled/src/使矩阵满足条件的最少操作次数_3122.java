// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class 使矩阵满足条件的最少操作次数_3122 {
    public static void main(String[] args) {
        使矩阵满足条件的最少操作次数_3122 main = new 使矩阵满足条件的最少操作次数_3122();
        // System.out.println(main.minimumOperations(new int[][]{{1,0,2}, {1,0,2}}));
        System.out.println(main.minimumOperations(new int[][]{{1,1,1}, {0,0,0}})); //3
        // System.out.println(Arrays.toString(main.findAnswer(3, new int[][]{{2,1,6}})));
    }

    //grid.length 行数 grid[0].length 列数
    public int minimumOperations(int[][] grid) {
        int[][] dp = new int[10][grid[0].length];

        for(int i=0;i<10;i++){
            for(int j=0;j<grid[0].length;j++){
                dp[i][j] += grid.length;
            }
        }

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                // System.out.println(i);
                // System.out.println(j);
                // System.out.println();
                dp[grid[i][j]][j]--;
            }
        }

        // for(int i=0;i<dp.length;i++){
        //     System.out.println(Arrays.toString(dp[i]));
        // }

        for(int i=1;i<grid[0].length;i++){
            for(int j=0;j<10;j++){
                int min = Integer.MAX_VALUE;
                for(int k=0;k<10;k++){
                    if(k==j) continue;
                    min = Math.min(min,dp[k][i-1]);
                }
                dp[j][i] += min;
            }
        }
        // System.out.println();
        // for(int i=0;i<dp.length;i++){
        //     System.out.println(Arrays.toString(dp[i]));
        // }
        // System.out.println();

        int res = Integer.MAX_VALUE;
        for(int i=0;i<10;i++){
            res = Math.min(res,dp[i][grid[0].length-1]);
        }

        return res;
    }
}
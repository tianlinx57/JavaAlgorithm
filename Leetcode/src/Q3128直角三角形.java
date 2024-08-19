public class Q3128直角三角形 {

    public long numberOfRightTriangles(int[][] grid) {
        int ans = 0;
        int[] lines = new int[grid.length];
        int[] columns = new int[grid[0].length];

        for(int j=0;j<grid.length;j++){
            for(int i=0;i<grid[0].length;i++){
                if(grid[j][i] == 1) lines[j]++;
            }
        }

        for(int j=0;j<grid[0].length;j++){
            for(int i=0;i<grid.length;i++){
                if(grid[i][j] == 1) columns[j]++;
            }
        }


        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1) ans += (lines[i]-1)*(columns[j]-1);
            }
        }
        return ans;
    }



    public static void main(String[] args) {
        Q3128直角三角形 solution = new Q3128直角三角形();
        System.out.println(solution.numberOfRightTriangles(new int[][]{{0,1,0},{0,1,1},{0,1,0}}));
        // System.out.println(solution.combinationSum3(2,18));
    }
}
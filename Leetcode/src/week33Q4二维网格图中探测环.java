//没做出
public class week33Q4二维网格图中探测环 {
    int[][] visited;
    int m;
    int n;
    int[] direction = new int[]{0,1,0,-1,0};
    public boolean containsCycle(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j] == 1) continue;
                if(dfs(grid,i,j,-100)) return true;
            }
        }
        return false;
    }
    boolean dfs(char[][] grid,int i,int j,int from_direction){
        if(visited[i][j] == 1) return false;
        visited[i][j] = 1;
        boolean ok = false;
        for(int k=0;k<4;k++) {
            if(Math.abs(k-from_direction) == 2)continue;
            int newi = i + direction[k];
            int newj = j + direction[k + 1];
            if(newi < 0 || newi >= m || newj < 0 || newj >= n)continue;
            if(visited[newi][newj] == 1 && grid[newi][newj] == grid[i][j]) {
                // System.out.println(from_direction);
                // System.out.println(k);
                // System.out.println("i: "+i+" j: "+j+" newi: "+newi+" newj: "+newj);
                // System.out.println();
                return true;
            }
            if(visited[newi][newj] == 1) continue;
            if(grid[newi][newj] == grid[i][j]) {
                ok |= dfs(grid, newi, newj, k);
            }
        }
        return ok;
    }
    public static void main(String[] args) {
        week33Q4二维网格图中探测环 solution = new week33Q4二维网格图中探测环();
        // System.out.println(solution.containsCycle(new char[][]{{'a','a','a','a'},{'a','b','b','a'},{'a','b','b','a'},{'a','a','a','a'}}));
        // System.out.println(solution.containsCycle(new char[][]{{'a','b','b'},{'b','z','b'},{'b','b','a'}}));
        // System.out.println(solution.containsCycle(new char[][]{{'b'},{'b'}}));
        System.out.println(solution.containsCycle(new char[][]{{'b','a','c'},{'c','a','c'},{'d','d','c'},{'b','b','c'}}));
    }
}
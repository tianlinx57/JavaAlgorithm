import java.util.Arrays;

public class Q100351交替组II {
    public int numberOfAlternatingGroups(int[] colors) {
        int n = colors.length;
        int ans = 0;
        for(int i=0;i<n;i++){
            if(colors[i]!=colors[(i+1)%n] && colors[(i+1)%n]!=colors[(i+2)%n]){
                ++ans;
            }
        }
        return ans;
    }
    // public int numberOfAlternatingGroups(int[] colors, int k) {
    //     int n = colors.length;
    //     int ans = 0;
    //     for(int i=0;i<n;i++){
    //         int flag = 0;
    //         for(int j=1;j<k;j++){
    //             if(colors[(i+j-1)%n]==colors[(i+j)%n]){
    //                 flag = 1;
    //             }
    //         }
    //         if(flag == 0) ++ans;
    //     }
    //     return ans;
    // }
    int[][] memo;

    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        memo = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(memo[i],-1);
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            if(dfs(colors,i,(i+k-1)%n)){
                ++ans;
            }
        }
        return ans;
    }

    boolean dfs(int[] colors,int i,int j){
        if(memo[i][j] != -1){
            return memo[i][j] == 1;
        }
        if(i == j) {
            memo[i][j] = 1;
            return memo[i][j] == 1;
        }
        int n = colors.length;
        if(colors[i] == colors[(i+1)%n]){
            memo[i][j] = 0;
            return memo[i][j] == 1;
        }
        boolean temp = dfs(colors,(i+1)%n,j);
        if(temp){
            memo[i][j] = 1;
            return memo[i][j] == 1;
        }
        memo[i][j] = 0;
        return memo[i][j] == 1;
    }

    public static void main(String[] args) {
        Q100351交替组II solution = new Q100351交替组II();
        // System.out.println(solution.numberOfAlternatingGroups(new int[]{0,1,0,1,0},3));
        System.out.println(solution.numberOfAlternatingGroups(new int[]{0,1,0,0,1,0,1},6));
    }
}
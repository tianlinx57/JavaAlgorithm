import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q3238求出胜利玩家的数目 {
    public int winningPlayerCount(int n, int[][] pick) {
        int[][] dp = new int[n][11];
        for(int[] p:pick){
            dp[p[0]][p[1]]++;
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<=10;j++){
                if(dp[i][j] > i){
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Q3238求出胜利玩家的数目 solution = new Q3238求出胜利玩家的数目();

        System.out.println(solution.winningPlayerCount(4, new int[][]{{2, 4}, {0, 2}, {0, 4}} ));
    }
}
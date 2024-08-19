import java.util.ArrayList;
import java.util.List;

public class Q699掉落的方块 {
    public List<Integer> fallingSquares(int[][] positions) {
        int[] dp = new int[100000000+1000000];
        List<Integer> ans = new ArrayList<>();
        int max_all = 0;
        for(int[] pos : positions) {
            int left = pos[0];
            int length = pos[1];
            int max = 0;
            for(int i = left; i < left + length; i++){
                max = Math.max(max, dp[i]);
            }
            for(int i = left; i < left + length; i++){
                dp[i] = max + length;
            }
            max_all = Math.max(max_all, max + length);
            ans.add(max_all);
        }
        return ans;
    }
    public static void main(String[] args) {
        Q699掉落的方块 solution = new Q699掉落的方块();
        System.out.println(solution.fallingSquares(new int[][]{{1, 2}, {2, 3}, {6, 1}}));
    }
}
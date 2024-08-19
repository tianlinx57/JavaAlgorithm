public class Q100351交替组II_dp {


    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i=n-1;i>=0;i--){
            if(colors[i] == colors[(i+1)%n]){
                dp[i] = 1;
            }else {
                dp[i] = dp[(i+1)%n]+1;
            }
        }
        for(int i=n-1;i>=0;i--){
            if(colors[i] == colors[(i+1)%n]){
                dp[i] = 1;
            }else {
                dp[i] = dp[(i+1)%n]+1;
            }
        }

        int ans = 0;
        for(int i=0;i<n;i++){
            if(dp[i] >= k){
                ans++;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        Q100351交替组II_dp solution = new Q100351交替组II_dp();
        // System.out.println(solution.numberOfAlternatingGroups(new int[]{0,1,0,1,0},3));
        System.out.println(solution.numberOfAlternatingGroups(new int[]{0,1,0,0,1,0,1},6));
    }
}
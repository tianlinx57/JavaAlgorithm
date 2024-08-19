public class Q3147从魔法师身上吸取的最大能量 {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int[] dp = new int[n];

        for(int i=0;i<n;i++){
            if(i<k) dp[i] = Math.max(dp[i],energy[i]);
            else{
                dp[i] = Math.max(0,dp[i-k]+energy[i]);
            }
        }

        for(int i=0;i<k;i++){
            dp[n-1-i] = energy[n-1-i] + (n-1-i-k>=0?dp[n-1-i-k] : 0);
        }
        int ans = Integer.MIN_VALUE;
        System.out.println(ans);
        for(int i=0;i<k && n>=i;i++){
            ans = Math.max(ans,dp[n-i-1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Q3147从魔法师身上吸取的最大能量 solution = new Q3147从魔法师身上吸取的最大能量();
        // char[] test = new char[]{'1','2'};
        // System.out.println(test);
        // char[] test1 = Arrays.copyOfRange(test,0,1);
        // System.out.println(test1);
        System.out.println(solution.maximumEnergy(new int[]{5,2,-10,-5,1},3));
    }
}
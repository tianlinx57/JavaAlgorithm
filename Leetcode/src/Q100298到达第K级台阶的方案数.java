public class Q100298到达第K级台阶的方案数 {
    public int waysToReachStair(int k) {
        if(k == 0) return 2;

        k = k-1;

        int ans = 0;
        int i = 0;
        // System.out.println("1<<i -(i+1) -1:"+((1<<i) -(i+1) -1));
        // System.out.println("k:"+k);
        while ((1<<i) -(i+1) -1 <= k){
            if((1<<i)-1 < k){
                ++i;
                continue;
            }
            ans += C(i+1,(1<<i) -1 -k);
            // System.out.println(ans);
            ++i;
        }

        return ans;
    }

    int C(int n,int k){
        k = Math.min(k,n-k);
        long ans = 1;
        for(int i=0;i<k;i++){
            ans *= (n-i);
            ans /= (i+1);
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        Q100298到达第K级台阶的方案数 solution = new Q100298到达第K级台阶的方案数();
        // System.out.println(solution.waysToReachStair(0));
        // System.out.println(solution.waysToReachStair(1));
        System.out.println(solution.waysToReachStair(2));
    }
}
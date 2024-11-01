import java.util.Arrays;

public class 用友Q3 {
    int[][] memo;
    public int goldenFinger (int n, int m) {
        int bigger = Math.max(n,m);
        int smaller = Math.min(m,n);
        if(memo == null) memo = new int[bigger+1][smaller+1];
        if(memo[bigger][smaller] != 0) return memo[bigger][smaller];
        if(smaller == 0) return 0;
        int ans = Integer.MAX_VALUE;
        for(int i=smaller;i>=1;--i){
            int temp = 1+goldenFinger(smaller-i,i)+goldenFinger(bigger-i,smaller);
            ans = Math.min(ans,temp);
            temp = 1+goldenFinger(smaller-i,bigger)+goldenFinger(bigger-i,i);
            ans = Math.min(ans,temp);
        }
        memo[bigger][smaller] = ans;
        return ans;
    }

    public static void main(String[] args) {
        用友Q3 solution = new 用友Q3();
        // System.out.println(solution.goldenFinger(2,3));
        // System.out.println(solution.goldenFinger(8,5));
        System.out.println(solution.goldenFinger(100,101));
    }
}
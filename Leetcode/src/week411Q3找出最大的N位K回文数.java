public class week411Q3找出最大的N位K回文数 {
    public String largestPalindrome(int n, int k) {
        int ans = 0;
        for(int i=0;i<n;i++){
            ans += 9*Math.pow(10,i);
        }
        for(int i=0;i<k;i++){
            if(ans%k==0) break;
            ans--;
        }
        while (ans>0){
            if(check(ans,n))break;
            ans -= k;
        }
        return String.valueOf(ans);
    }
    boolean check(int x,int n){
        int[] weishu = new int[n];
        for(int i=0;i<n;i++){
            weishu[i] = x%10;
            x /= 10;
        }
        int i=0, j=n-1;
        while (i<=j){
            if(weishu[i]!=weishu[j])return false;
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args) {
        week411Q3找出最大的N位K回文数 solution = new week411Q3找出最大的N位K回文数();
        // System.out.println(solution.largestPalindrome(3,5));
        System.out.println(solution.largestPalindrome(7,8));
        System.out.println(88899888%4);
    }
}
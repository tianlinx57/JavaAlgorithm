import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

public class week138doubleQ3统计好整数的数目 {
    long ans = 0;
    HashSet<Long> visited = new HashSet<>();
    public long countGoodIntegers(int n, int k) {
        ans = 0;
        visited = new HashSet<>();
        int[] pow10 = new int[10];
        pow10[0] = 1;
        for (int i = 1; i < n; i++) {
            pow10[i] = pow10[i - 1] * 10 % k;
        }

        dfs(0,n-1,n,k,0,pow10,new int[10]);
        return ans;
    }
    private void dfs(int i, int j, int n, int k,int yushu, int[] pow10, int[] count) {
        if(visited.contains(hash(count)))return;
        visited.add(hash(count));
        if(i==j-1){
            for(int a=0;a<10;a++){
                if(a==0 && i==0) continue;
                count[a] += 2;
                long temp = yushu + a*(pow10[j] + pow10[i]);
                temp %= k;
                if(temp == 0){
                    // System.out.println(Arrays.toString(count));
                    ans += jisuan(count,n);
                }
                count[a] -= 2;
            }
        } else if(i==j){
            for(int a=0;a<10;a++){
                if(a==0 && i==0) continue;
                count[a] += 1;
                long temp = yushu + a*(pow10[i]);
                temp %= k;
                if(temp == 0){
                    // System.out.println(Arrays.toString(count));
                    ans += jisuan(count,n);
                }
                count[a] -= 1;
            }
        } else {
            for(int a=0;a<10;a++){
                if(a==0 && i==0) continue;
                count[a] += 2;
                yushu = yushu + a*(pow10[j] + pow10[i]);
                yushu %= k;
                dfs(i+1,j-1,n,k,yushu*10+a,pow10,count);
                count[a] -= 2;
            }
        }
    }

    long hash(int[] count){
        long ans = 0;
        long mod = 1;
        for(int i=0;i<10;i++){
            ans += mod*count[i];
            mod *= 10;
        }
        System.out.println(Arrays.toString(count));
        System.out.println(ans);
        System.out.println();
        return ans;
    }

    private long jisuan(int[] count,int n) {
        // System.out.println(Arrays.toString(count));
        long temp = 1;
        temp *=  C(n-1,count[0]);
        n -= count[0];
        for(int i=1;i<=9;i++){
            temp *= C(n,count[i]);
            n -= count[i];
        }
        // System.out.println(Arrays.toString(count));
        // System.out.println(temp);
        return temp;
    }

    private long C(int n, int k) {
        if(k==0 || n==0) return 1;
        long ans = 1;
        for (int i = n; i >= n - k + 1; i--) {
            ans *= i;
        }
        for (int i = 1; i <= k; i++) {
            ans /= i;
        }
        return ans;
    }

    public static void main(String[] args) {
        week138doubleQ3统计好整数的数目 solution = new week138doubleQ3统计好整数的数目();
        System.out.println(solution.countGoodIntegers(3,5));
        System.out.println(solution.countGoodIntegers(1,4));
        System.out.println(solution.countGoodIntegers(5,6));
    }
}
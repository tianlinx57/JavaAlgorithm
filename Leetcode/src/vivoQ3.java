import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class vivoQ3 {
    public boolean canEqualDistribution (int[] prices, int k) {
        int sum = Arrays.stream(prices).sum();
        int max = Arrays.stream(prices).max().getAsInt();
        int each = sum/k;
        if(sum%k!=0 || max>each)return false;
        Arrays.sort(prices);
        return dfs(prices,new int[prices.length],k,0,0,each);
    }
    boolean dfs(int[] prices,int[] visited,int k,int now,int sum,int each){
        if(k == now) return true;
        int n = prices.length;

        boolean ans = false;
        for(int i=n-1;i>=0;--i){
            if(visited[i] == 1||prices[i]>each-sum)continue;
            if(prices[i] == each-sum) {
                visited[i] = 1;
                if(dfs(prices,visited,k,now+1,0,each)) {
                    ans = true;
                    break;
                }
                visited[i] = 0;
            } else {
                visited[i] = 1;
                if(dfs(prices,visited,k,now,sum+prices[i],each)) {
                    ans = true;
                    break;
                }
                visited[i] = 0;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        vivoQ3 solution = new vivoQ3();
        System.out.println(solution.canEqualDistribution(new int[]{5,4,1,3,2,3,2},4));
    }
}
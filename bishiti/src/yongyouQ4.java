import java.util.*;

public class yongyouQ4 {
    int ans = 0;
    int sum = 0;

    public void dfs(int start,int week, int n, int[][] zuidatianshu, int[][] path) {
        if(week == n) {
            ans = Math.max(ans, sum);
            return;
        }
        for(int i=0;i<n;i++){
            if(path[start][i] == 1 || i==start){
                sum += zuidatianshu[i][week];
                dfs(i, week+1, n, zuidatianshu, path);
                sum -= zuidatianshu[i][week];
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] path = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                path[i][j] = in.nextInt();
            }
        }
        int k = in.nextInt();
        int[][] zuidatianshu = new int[n][k];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < k; j++) {
                zuidatianshu[i][j] = in.nextInt();
            }
        }
        yongyouQ4 q4 = new yongyouQ4();
        q4.dfs(0,0,k,zuidatianshu,path);
        System.out.println(q4.ans);
    }
}

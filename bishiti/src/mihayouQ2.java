import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class mihayouQ2 {
    long ans = 0;
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] ewaijiangli = new int[m];
        int[][] jiangli = new int[n][3];
        int[][] laiyuan = new int[n][3];
        for(int i=0;i<m;i++){
            ewaijiangli[i] = in.nextInt();
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<=2;j++){
                jiangli[i][j] = in.nextInt();
            }
            for(int j=0;j<=2;j++){
                laiyuan[i][j] = in.nextInt();
            }
        }

        mihayouQ2 q2 = new mihayouQ2();
        q2.dfs(n, m, ewaijiangli, jiangli, laiyuan, 0, 0, new int[m]);
        System.out.println(q2.ans);
    }

    void dfs(int n,int m,int[] ewaijiangli,int[][] jiangli,int[][] laiyuan,int now,long sum,int[] guaiwucount){
        if(now == n){
            ans = Math.max(ans,sum);
            return;
        }
        for(int i=0;i<3;i++){
            long tempsum = sum+jiangli[now][i];
            guaiwucount[laiyuan[now][i]-1]++;
            if(guaiwucount[laiyuan[now][i]-1] == 3) tempsum += ewaijiangli[laiyuan[now][i]-1];
            dfs(n, m, ewaijiangli, jiangli, laiyuan, now+1, tempsum, guaiwucount);
            guaiwucount[laiyuan[now][i]-1]--;
        }
    }
    
}

import java.util.*;

public class baiduQ3 {
    int[] leixing;
    List<Integer>[] linjiebiao;
    int[] visited;
    void howmanyknow(int n,int m,int q,int[][] guanxi,int[] leixing,int[] liuyan){
        this.leixing = leixing;
        visited = new int[n+1];
        linjiebiao = new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            linjiebiao[i] = new ArrayList<>();
        }

        for(int[] yidui:guanxi){
            int a = yidui[0];
            int b = yidui[1];
            linjiebiao[a].add(b);
            linjiebiao[b].add(a);
        }
        
        for(int a=0;a<q;a++){
            check(liuyan[a]);
            int ans = 0;
            for(int i=0;i<=n;i++){
                if(visited[i]==1){
                    ans++;
                }
            }
            System.out.println(ans);
        }
        
    }
    void check(int a){
        Arrays.fill(visited, 0);
        dfs(a);
    }
    void dfs(int a){
        if(visited[a]==1){
            return;
        }
        visited[a] = 1;
        if(leixing[a]==1){
            for(int b:linjiebiao[a]){
                if(visited[b]==0){
                    dfs(b);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int q = in.nextInt();
        int[] leixing = new int[n+1];
        int[][] guanxi = new int[m][2];
        int[] liuyan = new int[q];
        for(int i=0;i<m;i++){
            guanxi[i][0] = in.nextInt();
            guanxi[i][1] = in.nextInt();
        }
        for(int i=1;i<=n;i++){
            leixing[i] = in.nextInt();
        }
        // System.out.println(Arrays.toString(leixing));
        for(int i=0;i<q;i++){
            liuyan[i] = in.nextInt();
        }
        baiduQ3 b = new baiduQ3();
        b.howmanyknow(n,m,q,guanxi,leixing,liuyan);


    }
}

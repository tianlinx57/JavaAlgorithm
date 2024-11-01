import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class mihayouQ3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        String xxx = in.nextLine();
        char[][] c = new char[m][n];
        for (int i = 0; i < m; i++) {
            String s = in.nextLine();
            // System.out.println(s);
            for (int j = 0; j < n; j++) {
                c[i][j] = s.charAt(j);
            }
        }
        // System.out.println(Arrays.deepToString(c));

        mihayouQ3 q3 = new mihayouQ3();
        q3.solve(c,m,n);
        // System.out.println(q3.sum);
        // System.out.println(q3.max);
        System.out.println(q3.max);
    }
    
    void solve(char[][] c, int m, int n) {
        visited_all = new int[m][n];
        visited_red = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(c[i][j]=='.' && visited_red[i][j]==0){
                    count = 0;
                    visited_all = new int[m][n];
                    init(i,j,m,n,c,0);
                    max = Math.max(max,count);
                }
            }
        }
    }
    void init(int i,int j,int m,int n,char[][] c,int zhuangtai){
        // System.out.println(i);
        // System.out.println(j);
        // System.out.println();
        ++count;
        visited_red[i][j] = 1;
        visited_all[i][j] = 1;
        for(int x=0;x<4;x++){
            int newi = i+position[x][0];
            int newj = j+position[x][1];
            // System.out.println(newi);
            // System.out.println(newj);
            // System.out.println();
            if(newi<0 || newi>=m || newj>=n || newj<0 || visited_all[newi][newj]==1){
                continue;
            }
            if(zhuangtai==0){
                if(c[newi][newj]=='.'){
                    init(newi, newj, m, n, c, 0);
                }else{
                    init(newi, newj, m, n, c, 1);
                }
                continue;
            }
            //只能加陆地
            if(c[newi][newj]=='#'){
                init(newi, newj, m, n, c, 1);
            }
        }
    }
    int[][] visited_all;
    int[][] visited_red;

    int[][] position = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    int max = 0;
    int count = 0;
    
}

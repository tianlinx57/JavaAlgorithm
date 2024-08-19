import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Q3123最短路径中的边 {
    public static void main(String[] args) {
        Q3123最短路径中的边 main = new Q3123最短路径中的边();
        // System.out.println(Arrays.toString(main.findAnswer(6, new int[][]{{0, 1, 4}, {0, 2, 1}, {1, 3, 2}, {1, 4, 3}, {1, 5, 1}, {2, 3, 1}, {3, 5, 3}, {4, 5, 2}})));
        System.out.println(Arrays.toString(main.findAnswer(6, new int[][]{{2,1,6}})));
    }

    boolean[][] closistPath;
    List<List<Integer>> closistPoint = new ArrayList<>();

    //djistra
    public boolean[] findAnswer(int n, int[][] edges) {
        int[][] edgeGraph = new int[n][n];
        int[] distance = new int[n];

        boolean[] done = new boolean[n];
        closistPath = new boolean[n][n];
        boolean[] res = new boolean[edges.length];


        for(int i=1;i<distance.length;i++){
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < n; i++) {
            closistPoint.add(new ArrayList<>()); // 初始化 closistPoint 包含 n 个空的列表
        }
        // int[][] closistPoint = new int[n][];


        for(int[] edge:edges){
            edgeGraph[edge[0]][edge[1]] = edge[2];
            edgeGraph[edge[1]][edge[0]] = edge[2];
        }
        // for(int i=0;i<n;i++){
        //     System.out.println(Arrays.toString(edgeGraph[i]));
        // }
        // System.out.println();


        for(int i=0;i<n;i++){
            int k=Integer.MAX_VALUE;
            int k_min=Integer.MAX_VALUE;
            for(int j=0;j<n;j++){
                if(distance[j]<k_min&&done[j]==false){
                    k=j;
                    k_min=distance[j];
                }
            }
            if(k==Integer.MAX_VALUE){
                break;
            }
            done[k] = true;
            for(int j=0;j<n;j++){
                if(j==k||edgeGraph[k][j]==0) continue;
                if(distance[k]+edgeGraph[k][j]<distance[j]){
                    distance[j] = distance[k]+edgeGraph[k][j];
                    closistPoint.set(j, new ArrayList<>(Collections.singletonList(k)));
                } else if (distance[k]+edgeGraph[k][j]==distance[j]) {
                    closistPoint.get(j).add(k);
                }
            }

        }

        dfs(n-1);

        // System.out.println(Arrays.toString(closistPoint.toArray()));
        // System.out.println();
        //
        //
        // for(int i=0;i<n;i++){
        //     System.out.println(Arrays.toString(closistPath[i]));
        // }
        // System.out.println();


        for(int i=0;i<edges.length;i++){
            res[i] =closistPath[edges[i][0]][edges[i][1]];
        }


        return res;


    }

    void dfs(int i){
        if(i==0) return ;
        for(int j:closistPoint.get(i)){
            closistPath[i][j] = true;
            closistPath[j][i] = true;
            dfs(j);
        }
    }


}
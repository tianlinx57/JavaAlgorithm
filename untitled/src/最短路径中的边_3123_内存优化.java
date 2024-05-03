import java.util.Arrays;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class 最短路径中的边_3123_内存优化 {
    public static void main(String[] args) {
        最短路径中的边_3123_内存优化 main = new 最短路径中的边_3123_内存优化();
        System.out.println(Arrays.toString(main.findAnswer(6, new int[][]{{0, 1, 4}, {0, 2, 1}, {1, 3, 2}, {1, 4, 3}, {1, 5, 1}, {2, 3, 1}, {3, 5, 3}, {4, 5, 2}})));
        // System.out.println(Arrays.toString(main.findAnswer(3, new int[][]{{2,1,6}})));
    }

    boolean[] ans;
    boolean[] visited;


    //djistra
    public boolean[] findAnswer(int n, int[][] edges) {
        ans = new boolean[edges.length];
        visited = new boolean[n];
        int[][][] edgeGraph = new int[n][n][2];
        int[] distance = new int[n];

        boolean[] done = new boolean[n];


        for(int i=1;i<distance.length;i++){
            distance[i] = Integer.MAX_VALUE;
        }



        for(int i=0;i<edges.length;i++){
            edgeGraph[edges[i][0]][edges[i][1]][0] = edges[i][2];
            edgeGraph[edges[i][0]][edges[i][1]][1] = i;

            edgeGraph[edges[i][1]][edges[i][0]][0] = edges[i][2];
            edgeGraph[edges[i][1]][edges[i][0]][1] = i;
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
                if(j==k||edgeGraph[k][j][0]==0) continue;
                if(distance[k]+edgeGraph[k][j][0]<distance[j]){
                    distance[j] = distance[k]+edgeGraph[k][j][0];
                }
            }

        }

        System.out.println(Arrays.toString(distance));

        dfs(n-1,distance);

        // System.out.println(Arrays.toString(closistPoint.toArray()));
        // System.out.println();
        //
        //
        // for(int i=0;i<n;i++){
        //     System.out.println(Arrays.toString(closistPath[i]));
        // }
        // System.out.println();

        return null;
    }

    void dfs(int i, int[] distance){
        visited[i] = true;
        // if(distance[i] == )
            //失败！ 一开始建立的表有问题 要修改 很复杂！！！！
    }




}
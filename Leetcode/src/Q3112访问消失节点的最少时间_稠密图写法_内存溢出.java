import java.util.Arrays;

public class Q3112访问消失节点的最少时间_稠密图写法_内存溢出 {

    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        int Max = Integer.MAX_VALUE/2;
        
        int[][] graph = new int[n][n];
        int[] distances = new int[n];
        boolean[] checked = new boolean[n];

        // for(int i=0;i<n;i++){
        //     distances[i] = Max;
        // }
        Arrays.fill(distances,Max);
        for(int[] edge:graph){
            Arrays.fill(edge,Max);
        }

        distances[0] = 0;

        for(int[] edge:edges){
            if(graph[edge[0]][edge[1]] >  edge[2]){
                graph[edge[0]][edge[1]] = edge[2];
                graph[edge[1]][edge[0]] = edge[2];
            }
        }


        while(true){
            int min=Max;
            int dis = Max;
            for(int i=0;i<n;i++){
                if(distances[i] < dis && !checked[i]){
                    min = i;
                    dis = distances[i];
                }
            }

            if(min == Max) break;
            checked[min] = true;

            for(int i=0;i<n;i++){
                if(dis+graph[min][i] < disappear[i]){
                    distances[i] = Math.min(distances[i],dis+graph[min][i]);
                }
            }
        }
        for(int i=0;i<n;i++){
            if(distances[i] == Max) distances[i] = -1;
        }
        return distances;

    }


    public static void main(String[] args) {
        Q3112访问消失节点的最少时间_稠密图写法_内存溢出 solution = new Q3112访问消失节点的最少时间_稠密图写法_内存溢出();
        System.out.println(Arrays.toString(solution.minimumTime(3, new int[][]{{0, 1, 2}, {1, 2, 1}, {0, 2, 4}}, new int[]{1, 1, 5})));
        //输入：n = 3, edges = [[0,1,2],[1,2,1],[0,2,4]], disappear = [1,1,5]
        //
        // 输出：[0,-1,4]
    }
}
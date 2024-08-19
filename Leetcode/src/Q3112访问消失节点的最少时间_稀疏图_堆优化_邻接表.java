import java.util.*;

public class Q3112访问消失节点的最少时间_稀疏图_堆优化_邻接表 {

    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        int Max = Integer.MAX_VALUE/2;

        List<int[]>[] lin_jie_biao = new ArrayList[n];
        //
        // Arrays.setAll(lin_jie_biao,i->new ArrayList<>());
        for(int i=0;i<n;i++){
            lin_jie_biao[i] = new ArrayList<>();
        }

        for(int[] edge:edges){
            lin_jie_biao[edge[0]].add(new int[]{edge[1], edge[2]});
            lin_jie_biao[edge[1]].add(new int[]{edge[0], edge[2]});
        }

        int[] distances = new int[n];
        Arrays.fill(distances,Max);

        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->(a[1]-b[1]));
        queue.offer(new int[]{0,0});

        while(!queue.isEmpty()){
            int[] item = queue.poll();
            int dis = item[1];
            int index = item[0];
            //
            // System.out.println("dis:"+dis);
            // System.out.println("index:"+index);
            // System.out.println();

            if(distances[index] < dis) continue;
            distances[index] = dis;

            for(int[] point : lin_jie_biao[index]){
                if(dis+point[1] < distances[point[0]] && dis+point[1]<disappear[point[0]]){
                    distances[point[0]] = dis+point[1];
                    queue.offer(new int[]{point[0],distances[point[0]]});
                }
            }
        }
        for(int i=0;i<n;i++){
            if(distances[i] == Max) distances[i] = -1;
        }
        return distances;
    }



    public static void main(String[] args) {
        Q3112访问消失节点的最少时间_稀疏图_堆优化_邻接表 solution = new Q3112访问消失节点的最少时间_稀疏图_堆优化_邻接表();
        System.out.println(Arrays.toString(solution.minimumTime(3, new int[][]{{0, 1, 2}, {1, 2, 1}, {0, 2, 4}}, new int[]{1, 3, 5})));
        //输入：n = 3, edges = [[0,1,2],[1,2,1],[0,2,4]], disappear = [1,1,5]
        //
        // 输出：[0,-1,4]
    }
}
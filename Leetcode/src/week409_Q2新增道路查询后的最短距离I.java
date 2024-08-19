import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class week409_Q2新增道路查询后的最短距离I {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<Integer>[] lin_jie_ju_zhen = new ArrayList[n];
        for(int i=0;i<n;i++){
            lin_jie_ju_zhen[i] = new ArrayList<>();
        }
        int[] ans = new int[queries.length];
        int count = 0;
        for(int[] query:queries){
            int from = query[0];
            int to = query[1];
            lin_jie_ju_zhen[to].add(from);
            int step = dfs(lin_jie_ju_zhen,n-1);
            ans[count++] = step;
        }
        return ans;
    }

    int dfs(List<Integer>[] lin_jie_ju_zhen,int to){
        if(to == 0) return 0;
        int min = Integer.MAX_VALUE;
        min = Math.min(min,dfs(lin_jie_ju_zhen,to-1)+1);
        for(int i : lin_jie_ju_zhen[to]){
            min = Math.min(min,dfs(lin_jie_ju_zhen,i)+1);
        }
        return min;
    }

    public static void main(String[] args) {
        week409_Q2新增道路查询后的最短距离I solution = new week409_Q2新增道路查询后的最短距离I();

        System.out.println(Arrays.toString(solution.shortestDistanceAfterQueries(5, new int[][]{{2,4},{0,2},{0,4}})));
    }
}
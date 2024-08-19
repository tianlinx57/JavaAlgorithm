import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q100354统计好节点的数目 {
    int ans = 0;
    public int countGoodNodes(int[][] edges) {
        int n = edges.length;
        List<Integer>[] lin_jie_ju_zhen = new ArrayList[n+1];
        Arrays.setAll(lin_jie_ju_zhen, i -> new ArrayList<>());
        for(int[] edge:edges){
            int a = edge[0];
            int b = edge[1];
            lin_jie_ju_zhen[a].add(b);
            lin_jie_ju_zhen[b].add(a);
        }
        dfs(lin_jie_ju_zhen,0,0);
        return ans;
    }

    int dfs(List<Integer>[] lin_jie_ju_zhen,int root,int node){
        int same = -1;
        int flag = 0;
        int sum = 1;
        for(int i:lin_jie_ju_zhen[node]){
            if(i!=root){
                int temp = dfs(lin_jie_ju_zhen,node,i);
                sum += temp;
                if(same==-1) same = temp;
                else if(same!=temp) flag = 1;
            }
        }
        if(flag==0) ans++;
        return sum;
    }
    public static void main(String[] args) {
        Q100354统计好节点的数目 solution = new Q100354统计好节点的数目();
        System.out.println(solution.countGoodNodes(new int[][]{{0,1},{0,2},{1,3},{1,4},{2,5},{2,6}}));
    }
}
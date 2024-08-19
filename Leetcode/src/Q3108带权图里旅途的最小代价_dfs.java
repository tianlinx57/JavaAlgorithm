import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q3108带权图里旅途的最小代价_dfs {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        List<int[]>[] lin_jie_ju_zhen = new List[n];

        Arrays.setAll(lin_jie_ju_zhen,i->new ArrayList<>());
        // for(int i=0;i<n;i++){
        //     lin_jie_ju_zhen[i] = new ArrayList<>();
        // }

        for(int[] edge:edges){
            // System.out.println(Arrays.toString(edge));
            lin_jie_ju_zhen[edge[0]].add(new int[]{edge[1],edge[2]});
            lin_jie_ju_zhen[edge[1]].add(new int[]{edge[0],edge[2]});
        }

        //每个点所在的连通图序号
        int[] lintongtu = new int[n];
        Arrays.fill(lintongtu, -1);
        // for(int i = 0 ;i<n;i++){
        //     lintongtu[i] = -1;
        // }

        //连通图所有边的and和
        // int[] and = new int[n];
        List<Integer> and = new ArrayList<>();


        for(int i=0;i<n;i++){
            if(lintongtu[i] == -1){
                and.add(dfs(i,and.size(),lintongtu,lin_jie_ju_zhen));
            }
        }

        // System.out.println();
        // System.out.println(and);
        // System.out.println(Arrays.toString(lintongtu));
        //
        // System.out.println();
        // for(int[] test:lin_jie_ju_zhen[4]){
        //     System.out.println(Arrays.toString(test));
        // }
        // System.out.println();
        // for(int[] test:lin_jie_ju_zhen[0]){
        //     System.out.println(Arrays.toString(test));
        // }

        int[] ans = new int[query.length];
        for(int i=0;i< query.length;i++){
            if(query[i][0]==query[i][1]){
                ans[i] = 0;
            } else if (lintongtu[query[i][0]] == lintongtu[query[i][1]]) {
                ans[i] = and.get(lintongtu[query[i][0]]);
            } else {
                ans[i] = -1;
            }
        }



        return ans;

    }

    int dfs(int i,int index, int[] liantongtu,List<int[]>[] lin_jie_ju_zhen){
        liantongtu[i] = index;
        int and = -1;
        for(int[] edge : lin_jie_ju_zhen[i]){
            and &= edge[1];
            if(liantongtu[edge[0]] == -1){
                and &= dfs(edge[0], index, liantongtu, lin_jie_ju_zhen);
            }
        }
        return and;
    }


    public static void main(String[] args) {
        Q3108带权图里旅途的最小代价_dfs solution = new Q3108带权图里旅途的最小代价_dfs();
        System.out.println(Arrays.toString(solution.minimumCost(5, new int[][]{{0,1,7}, {1,3,7}, {1,2,1}}, new int[][]{{0,3},{3,4}})));
    }
}
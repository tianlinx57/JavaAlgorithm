import java.util.Arrays;

public class Q3108带权图里旅途的最小代价_并查集_自己写 {

    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        UnionFindSet set = new UnionFindSet(n);
        for(int[] edge:edges){
            set.union(edge[0],edge[1],edge[2]);
        }

        int[] ans = new int[query.length];
        for(int i=0;i< query.length;i++){
            int a=query[i][0];
            int b=query[i][1];
            if(a==b) ans[i] = 0;
            else if (set.find(a) == set.find(b)) {
                ans[i] = set.and_sum[set.find(a)];
            } else {
                ans[i] = -1;
            }
        }
        return ans;
    }

    class UnionFindSet{
        int[] and_sum,parent;

        UnionFindSet(int n){
            and_sum=new int[n];
            Arrays.fill(and_sum,-1);

            parent=new int[n];
            Arrays.setAll(parent,i->i);
        }

        int find(int i){
            if(parent[i] != i){
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }

        void union(int a,int b,int value){
            int parent_a = find(a);
            int parent_b = find(b);
            if(parent_a!=parent_b){
                parent[parent_a] = parent_b;
                and_sum[parent_b] &= and_sum[parent_a]&value;
            } else {
                and_sum[parent_a] &= value;
            }
        }
    }

    public static void main(String[] args) {
        Q3108带权图里旅途的最小代价_并查集_自己写 solution = new Q3108带权图里旅途的最小代价_并查集_自己写();
        System.out.println(Arrays.toString(solution.minimumCost(5, new int[][]{{0,1,7}, {1,3,7}, {1,2,1}}, new int[][]{{0,3},{3,4}})));
    }
}
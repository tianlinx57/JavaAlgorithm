import java.util.*;

//并查集
public class Q1579保证图可完全遍历 {
    class UnionFind {
        int[] parent;
        int setCount;//集合数

        public UnionFind(int n) {
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            setCount = n;
        }



        public void union(int i, int j) {
            int pi = find(i), pj = find(j);
            if (pi == pj) {
                return;
            } else if (pi < pj) {
                parent[pj] = pi;
            } else {
                parent[pi] = pj;
            }
            --setCount;
        }

        public int find(int i) {
            if (parent[i] == i) {
                return i;
            }
            return parent[i] = find(parent[i]);
        }
    }
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind unionFindSetAlice = new UnionFind(n);
        UnionFind unionFindSetBob = new UnionFind(n);

        int ans = 0;
        for(int[] edge:edges){
            int a = edge[2]-1;
            int b = edge[1]-1;
            int type = edge[0];
            if(type==3){
                if(unionFindSetAlice.find(a)==unionFindSetAlice.find(b)){
                    ++ans;
                } else{
                    unionFindSetAlice.union(a,b);
                    unionFindSetBob.union(a,b);
                }
            }
        }

        for(int[] edge:edges){
            int a = edge[2]-1;
            int b = edge[1]-1;
            int type = edge[0];
            if(type==1){
                if(unionFindSetAlice.find(a)==unionFindSetAlice.find(b)){
                    ++ans;
                } else{
                    unionFindSetAlice.union(a,b);
                }
            }
            if(type==2){
                if(unionFindSetBob.find(a)==unionFindSetBob.find(b)){
                    ++ans;
                } else{
                    unionFindSetBob.union(a,b);
                }
            }
        }

        if(unionFindSetAlice.setCount!=1||unionFindSetBob.setCount!=1){
            return -1;
        }
        return ans;

    }


    public static void main(String[] args) {
        Q1579保证图可完全遍历 solution = new Q1579保证图可完全遍历();
        System.out.println(solution.maxNumEdgesToRemove(4,new int[][]{{3,1,2},{3,2,3},{1,1,3},{1,2,4},{1,1,2},{2,3,4}}));
    }
}
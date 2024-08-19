import java.util.Arrays;

public class Q3108带权图里旅途的最小代价_并查集 {
    // 与运算次数越多，结果越小，由于可以走重复路径，那么同一个连通子图内的路径都要用上

    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        // 构造并查集
        UnionFind uf = new UnionFind(n);
        for (int[] e : edges) {
            int i = e[0], j = e[1], d = e[2];
            uf.union(i, j, d);
        }
        // 处理查询
        int[] ans = new int[query.length];
        for (int k = 0; k < query.length; k++) {
            int i = query[k][0], j = query[k][1];
            if (i == j) {
                // 不用动，代价0
                continue;
            }
            int pi = uf.find(i), pj = uf.find(j);
            ans[k] = pi != pj ? -1 : uf.dist[pi];
        }
        return ans;
    }

    class UnionFind {
        // dist: 组内最小代价
        int[] parent, dist;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.dist = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            Arrays.fill(dist, Integer.MAX_VALUE);
        }

        public void union(int i, int j, int d) {
            int pi = find(i), pj = find(j);
            if (pi == pj) {
                dist[pi] &= d;
            } else if (pi < pj) {
                parent[pj] = pi;
                dist[pi] = dist[pi] & dist[pj] & d;
            } else {
                parent[pi] = pj;
                dist[pj] = dist[pi] & dist[pj] & d;
            }
        }

        public int find(int i) {
            if (parent[i] == i) {
                return i;
            }
            return parent[i] = find(parent[i]);
        }
    }


    public static void main(String[] args) {
        Q3108带权图里旅途的最小代价_并查集 solution = new Q3108带权图里旅途的最小代价_并查集();
        System.out.println(Arrays.toString(solution.minimumCost(5, new int[][]{{0,1,7}, {1,3,7}, {1,2,1}}, new int[][]{{0,3},{3,4}})));
    }
}
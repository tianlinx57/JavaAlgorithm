import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class manbangQ3 {
    static class UnionFind {
        int[] parent;
        int setCount;//集合数
        long[] sum;

        public UnionFind(int n) {
            this.parent = new int[n+1];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            setCount = n;
        }

        public UnionFind(int n,int[] nums) {
            this.parent = new int[n+1];
            this.sum = new long[n+1];
            for (int i = 1; i < n+1; i++) {
                parent[i] = i;
                sum[i] = nums[i-1];
            }
            setCount = n;
        }



        public void union(int i, int j) {
            int pi = find(i), pj = find(j);
            if (pi == pj) {
                return;
            } else if (pi < pj) {
                parent[pj] = pi;
                sum[pi] += sum[pj];
            } else {
                parent[pi] = pj;
                sum[pj] += sum[pi];
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

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = in.nextInt();
        }
        UnionFind unionFind = new UnionFind(n, nums);

        List<Integer>[] linjiebiao;
        linjiebiao = new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            linjiebiao[i] = new ArrayList<>();
        }

        for(int i=0;i<n-1;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            linjiebiao[a].add(b);
            linjiebiao[b].add(a);
        }

        int maxindex = 1;
        for(int i=1;i<=n;++i){
            for(int edge:linjiebiao[i]){
                if(edge<i){
                    unionFind.union(i, edge);
                }
            }
            if(unionFind.sum[unionFind.find(i)] > unionFind.sum[unionFind.find(maxindex)]){
                maxindex = i;
            }
            // System.out.println(Arrays.toString(unionFind.sum));
            // System.out.println(Arrays.toString(unionFind.parent));
            System.out.println(unionFind.sum[unionFind.find(maxindex)]);
        }
    }
}

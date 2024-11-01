import java.util.*;

public class baiduQ3_bingchaji {
    int[] leixing;
    List<Integer>[] linjiebiao;
    int[] visited;
    void howmanyknow(int n,int m,int q,int[][] guanxi,int[] leixing,int[] liuyan){
        this.leixing = leixing;
        visited = new int[n+1];
        linjiebiao = new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            linjiebiao[i] = new ArrayList<>();
        }

        for(int[] yidui:guanxi){
            int a = yidui[0];
            int b = yidui[1];
            linjiebiao[a].add(b);
            linjiebiao[b].add(a);
        }
        UnionFindSet unionFindSet = new UnionFindSet(n+1);
        for(int i=1;i<=n;i++){
            Arrays.fill(visited, 0);
            if(leixing[i] == 1){
                for(int j:linjiebiao[i]){
                    if(leixing[j] == 1){
                        unionFindSet.union(i,j,1);
                    } else {
                        if(visited[j] == 0){
                            visited[j] = 1;
                            unionFindSet.set(i, unionFindSet.find(i)+1);
                        }
                    }
                }
            }
        }
        for(int a=0;a<q;a++){
            if(leixing[liuyan[a]] == 2) {
                System.out.println("1");
            } else {
                System.out.println(unionFindSet.and_sum[unionFindSet.find(liuyan[a])]);
            }
        }
        
    }
    class UnionFindSet{
        int[] and_sum,parent;

        UnionFindSet(int n){
            and_sum=new int[n];
            Arrays.fill(and_sum,0);

            parent=new int[n];
            Arrays.setAll(parent,i->i);
        }

        int find(int i){
            if(parent[i] != i){
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }

        void set(int i,int val){
            and_sum[find(i)] = val;
        }

        void union(int a,int b,int value){
            int parent_a = find(a);
            int parent_b = find(b);
            if(parent_a!=parent_b){
                parent[parent_a] = parent_b;
                and_sum[parent_b]++;
            } else {
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int q = in.nextInt();
        int[] leixing = new int[n+1];
        int[][] guanxi = new int[m][2];
        int[] liuyan = new int[q];
        for(int i=0;i<m;i++){
            guanxi[i][0] = in.nextInt();
            guanxi[i][1] = in.nextInt();
        }
        for(int i=1;i<=n;i++){
            leixing[i] = in.nextInt();
        }
        // System.out.println(Arrays.toString(leixing));
        for(int i=0;i<q;i++){
            liuyan[i] = in.nextInt();
        }
        baiduQ3_bingchaji b = new baiduQ3_bingchaji();
        b.howmanyknow(n,m,q,guanxi,leixing,liuyan);


    }
}

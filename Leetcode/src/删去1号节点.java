import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 删去1号节点 {

    int dfs(int i,int parent,List<Integer>[] lin_jie_biao){
        if(lin_jie_biao[i].size() == 1){
            return 1;
        }
        int sum = 1;
        for(int j=0;j<lin_jie_biao[i].size();j++){
            if(lin_jie_biao[i].get(j) == parent) continue;
            sum += dfs(lin_jie_biao[i].get(j),i,lin_jie_biao);
        }
        return sum;
    }

    public static void main(String[] args) {
        删去1号节点 main = new 删去1号节点();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        // 注意 hasNext 和 hasNextLine 的区别
        int[][] edges = new int[n-1][2];
        for(int i=0;i<n-1;i++){
            edges[i][0] = in.nextInt();
            edges[i][1] = in.nextInt();
        }

        List<Integer>[] lin_jie_biao = new ArrayList[n];
        for(int i=0;i<n;i++){
            lin_jie_biao[i] = new ArrayList<>();
        }

        for(int[] edge:edges){
            lin_jie_biao[edge[0]-1].add(edge[1]-1);
            lin_jie_biao[edge[1]-1].add(edge[0]-1);
        }

        int sum = 0;
        int max = 0;
        List<Integer> temp = lin_jie_biao[0];
        for(int i=0;i<temp.size();i++){
            int needCutNumber = main.dfs(temp.get(i),0,lin_jie_biao);
            if(needCutNumber > max){
                sum += max;
                max = needCutNumber;
            }else{
                sum += needCutNumber;
            }
        }
        System.out.println(sum+1);
    }
}

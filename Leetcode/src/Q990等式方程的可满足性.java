import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q990等式方程的可满足性 {
    int[] fa = new int[26];
    int find(int x){
        if(fa[x]!=x){
            return find(fa[x]);
        }
        return fa[x];
    }
    void merge(int from,int to){
        int f_from = find(from);
        int f_to = find(to);
        if(f_from==f_to) return;
        fa[f_from] = f_to;
    }
    public boolean equationsPossible(String[] equations) {
        for(int i=0;i<26;i++){
            fa[i] = i;
        }
        List<int[]> butong = new ArrayList<>();
        for(String eq:equations){
            char a = eq.charAt(0);
            char b = eq.charAt(3);
            if(eq.charAt(1) == '!') butong.add(new int[]{a,b});
            else{
                merge(a-'a',b-'a');
            }
        }
        for(int[] bt:butong){
            if(find(bt[0]-'a')==find(bt[1]-'a')) return false;//如果两个字符属于同一个集合，则不满足相等关系
        }
        return true;
    }
    public static void main(String[] args) {
        Q990等式方程的可满足性 solution = new Q990等式方程的可满足性();
        System.out.println(solution.equationsPossible(new String[]{"a==b","b!=a"}));
    }
}
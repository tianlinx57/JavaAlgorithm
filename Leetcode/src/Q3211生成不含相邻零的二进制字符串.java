import java.util.ArrayList;
import java.util.List;

public class Q3211生成不含相邻零的二进制字符串 {

    String path = "";
    List<String> ans = new ArrayList<>();
    public List<String> validStrings(int n) {
        if(n == 1) return List.of(new String[]{"0", "1"});
        dfs(n,true);
        return ans;
    }

    void dfs(int n,boolean shanggeshi1){
        if(n==0){
            ans.add(path);
            return;
        }
        path += "1";
        dfs(n-1,true);
        path = path.substring(0,path.length()-1);

        if(shanggeshi1){
            path += "0";
            dfs(n-1,false);
            path = path.substring(0,path.length()-1);
        }

    }


    public static void main(String[] args) {
        Q3211生成不含相邻零的二进制字符串 solution = new Q3211生成不含相邻零的二进制字符串();
        System.out.println(solution.validStrings(3));
    }
}
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q22括号生成 {

    Set<String> set = new HashSet<>();

    String string = new String();

    void dfs(int depth, int n){
        if(depth == n){
            set.add(string);
            return;
        }
        for(int i = 0 ; i <= string.length() ; i++){
            StringBuilder sb = new StringBuilder(string);
            sb.insert(i,'(');
            sb.insert(i+1,')');
            string = sb.toString();
            // System.out.println(string);
            dfs(depth+1,n);
            sb = new StringBuilder(string);
            sb.deleteCharAt(i);
            sb.deleteCharAt(i);
            string = sb.toString();
        }

    }

    public List<String> generateParenthesis(int n) {
        dfs(0,n);
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        Q22括号生成 solution = new Q22括号生成();
        System.out.println(solution.generateParenthesis(3));
    }
}
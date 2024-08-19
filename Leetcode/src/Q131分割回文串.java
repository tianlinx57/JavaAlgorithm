import java.util.ArrayList;
import java.util.List;

public class Q131分割回文串 {

    List<List<String>> result = new ArrayList<>();
    List<String> path = new ArrayList<>();
    void dfs(int startIndex, String s){
        if(startIndex== s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=startIndex;i<s.length();i++){
            if(isHuiwen(s.substring(startIndex,i+1))){
                path.add(s.substring(startIndex,i+1));
                dfs(i+1,s);
                path.removeLast();
            }
        }
    }
    boolean isHuiwen(String s){
        for(int i=0,j=s.length()-1;i<j;i++,j--){
            if(s.charAt(i)!=s.charAt(j)) return false;
        }
        return true;
    }


    public List<List<String>> partition(String s) {
        dfs(0,s);
        return  result;
    }


    public static void main(String[] args) {
        Q131分割回文串 solution = new Q131分割回文串();
        System.out.println(new String("aab").substring(0,1));
        System.out.println(solution.partition(new String("aab")));
        // System.out.println(solution.combinationSum3(2,18));
    }
}
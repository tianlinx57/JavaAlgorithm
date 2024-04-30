import java.util.ArrayList;
import java.util.List;

public class 复原IP地址_93 {

    List<String> result = new ArrayList<>();
    String path = "";
    int[] dp = new int[1000];
    void dfs(int startIndex, int depth, String s){
        // System.out.println();
        // System.out.println("startIndex:"+startIndex);
        // System.out.println("depth:"+depth);
        // System.out.println();
        if(startIndex==s.length() && depth==4){
            // System.out.println(path);
            result.add(new String(path));
            return;
        } else if (depth==4||startIndex==s.length()) {
            return;
        }
        if(s.charAt(startIndex) == '0'){
            if (depth == 0) {
                path+="0";
            } else {
                path+=".0";
            }
            dfs(startIndex+1,depth+1,s);
            if (depth == 0) {
                return;
            } else {
                path=path.substring(0,path.length()-2);
            }

            return;
        }

        for(int i=1;i<=3&&startIndex+i<=s.length();i++){
            // System.out.println(path);
            if (depth == 0) {
                if(isLegal(s.substring(startIndex,startIndex+i))){
                    path+=s.substring(startIndex,startIndex+i);
                } else {
                    continue;
                }
            } else {
                if(isLegal(s.substring(startIndex,startIndex+i))){
                    path+=".";
                    path+=s.substring(startIndex,startIndex+i);
                } else {
                    continue;
                }
            }
            dfs(startIndex+i,depth+1,s);
            if (depth == 0) {
                path=path.substring(0,path.length()-i);
            } else {
                // System.out.println("前："+path);
                path=path.substring(0,path.length()-i-1);
                // System.out.println("后："+path);
                // System.out.println();
            }

        }
    }

    boolean isLegal(String s){
        int i = Integer.parseInt(s);
        if(dp[i]==1){
            return false;
        }
        if(dp[i]==2){
            return true;
        }

        if(s.length()==2&&s.charAt(0)=='0'){
            dp[i] = 1;
            return false;
        }
        if(s.length()==3&&(s.charAt(0)>='3'||s.charAt(0)=='2'&&s.charAt(1)>'5'||s.charAt(0)=='2'&&s.charAt(1)=='5'&&s.charAt(2)>'5')){
            dp[i] = 1;
            return false;
        }
        dp[i] = 2;
        return true;
    }


    public List<String> restoreIpAddresses(String s) {
        dfs(0,0,s);
        return result;
    }


    public static void main(String[] args) {
        复原IP地址_93 solution = new 复原IP地址_93();
        // System.out.println(solution.isLegal("255"));
        // System.out.println(solution.restoreIpAddresses(new String("25525511135")));
        System.out.println(solution.restoreIpAddresses(new String("101023")));
    }
}
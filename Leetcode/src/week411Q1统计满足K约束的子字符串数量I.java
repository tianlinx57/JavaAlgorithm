import java.util.ArrayList;
import java.util.TreeSet;


public class week411Q1统计满足K约束的子字符串数量I {
    public int countKConstraintSubstrings(String s, int k) {
        int n = s.length();
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<=n;j++){
                if(check(s.substring(i,j),k)){
                    ans++;
                    System.out.println(s.substring(i,j));
                }
            }
        }
        return ans;
    }
    boolean check(String s,int k){
        int count0=0,count1=0;
        for(char c:s.toCharArray()){
            if(c=='0') count0++;
            if(c=='1') count1++;
            if(count0>k && count1>k) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        week411Q1统计满足K约束的子字符串数量I solution = new week411Q1统计满足K约束的子字符串数量I();
        System.out.println(solution.countKConstraintSubstrings("10101",1));
        // System.out.println("10101".substring(1,2));
    }
}
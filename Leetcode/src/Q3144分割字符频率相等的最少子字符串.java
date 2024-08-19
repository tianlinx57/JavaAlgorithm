import java.util.Arrays;

public class Q3144分割字符频率相等的最少子字符串 {
    public int minimumSubstringsInPartition(String s) {
        char[] chars= s.toCharArray();
        int n = chars.length;
        int[] dp = new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 1;
        for(int i=1;i<n;i++){
            int[] count = new int[26];
            for(int j=i;j>=0;j--){
                count[chars[j]-'a']++;
                if(isValid(count)){
                    if(j==0) dp[i] = 1;
                    else{
                        dp[i] = Math.min(dp[i], dp[j-1]+1);
                    }
                }
            }
        }

        return dp[n-1];
    }


    boolean isValid(int[] counts){
        int check = -1;
        for(int i=0;i<26;i++){
            if(counts[i]!=0){
                if(check==-1){
                    check=counts[i];
                }else {
                    if(counts[i] != check){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Q3144分割字符频率相等的最少子字符串 solution = new Q3144分割字符频率相等的最少子字符串();
        // char[] test = new char[]{'1','2'};
        // System.out.println(test);
        // char[] test1 = Arrays.copyOfRange(test,0,1);
        // System.out.println(test1);
        System.out.println(solution.minimumSubstringsInPartition("fabccddg"));
    }
}
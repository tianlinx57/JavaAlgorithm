// package CodeForces.round167;

import java.util.Arrays;
import java.util.Scanner;

public class Q2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());

        for(int i=0;i<n;i++){
            String substring = in.nextLine();
            String subseq = in.nextLine();

            int ans = 0;
            for(int j=0;j<substring.length();j++){
                ans = Math.max(ans,dfs(substring.substring(j),subseq));
            }
            System.out.println(subseq.length()+substring.length()-ans);
        }
    }

    static int dfs(String substring,String subseq){
        if(substring.isEmpty() || subseq.isEmpty()){
            return 0;
        }
        int ans=0;
        for(int i=0;i<subseq.length();i++){
            if(substring.charAt(0) == subseq.charAt(i)){
                ans = Math.max(ans,dfs(substring.substring(1),subseq.substring(i+1))+1);
            }
        }
        return ans;
    }



}


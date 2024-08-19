public class 消除AB {
    int deleteAB(String string){
        return dfs(0,string);
    }

    int dfs(int startIndex, String string){
        // System.out.println(startIndex);
        // System.out.println(string);
        // System.out.println();
        int n = string.length();
        if(n < 2) return n;
        int ans = n;
        for(int i=startIndex;i<n-1;i++){
            if(string.substring(i,i+2).equals("AB")){
                String s = string.substring(0,i) + string.substring(i+2,n);
                ans = Math.min(dfs(Math.max(0,i-1),s),ans);
            }
            if(string.substring(i,i+2).equals("BB")){
                String s = string.substring(0,i) + string.substring(i+2,n);
                ans = Math.min(dfs(Math.max(0,i-1),s),ans);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        消除AB solution = new 消除AB();
        System.out.println(solution.deleteAB("AABBBABBBB"));
        System.out.println(solution.deleteAB("BABA"));
        System.out.println(solution.deleteAB("AAA"));
    }
}
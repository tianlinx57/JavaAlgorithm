import java.util.HashMap;

public class Q3213最小代价构造字符串 {

    int ans = Integer.MAX_VALUE;
    int sum=0;
    HashMap<String,Integer> hashMap = new HashMap<>();
    HashMap<String,Integer> min_value = new HashMap<>();
    public int minimumCost(String target, String[] words, int[] costs) {
        for(int i=0;i< words.length;i++){
            String word = words[i];
            if(hashMap.containsKey(word)){
                hashMap.put(word,Math.min(hashMap.get(word),costs[i]));
            } else {
                hashMap.put(word,costs[i]);
            }
        }
        // System.out.println(hashMap);
        dfs(target,0);
        return ans == Integer.MAX_VALUE?-1:ans;
    }

    int dfs(String target,int sum){
        if(min_value.containsKey(target)){
            ans = Math.min(ans,sum+min_value.get(target));
            return min_value.get(target);
        }

        if(target.isEmpty()){
            ans = Math.min(ans,sum);
            return 0;
        }
        int n = target.length();
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(hashMap.containsKey(target.substring(i,n))){
                int value = dfs(target.substring(0,i),hashMap.get(target.substring(i,n))+sum);
                if(value != -1){
                    min = Math.min(min,value+hashMap.get(target.substring(i,n)));
                }
            }
        }
        if(min != Integer.MAX_VALUE){
            min_value.put(target,min);
            return min;
        }
        return -1;
    }


    public static void main(String[] args) {
        Q3213最小代价构造字符串 solution = new Q3213最小代价构造字符串();
        // System.out.println(solution.numberOfSubmatrices(new char[][]{{'X','Y','.'},{'Y','.','.'}}));
        System.out.println(solution.minimumCost("abcdef", new String[]{"abdef","abc","d","def","ef"},new int[]{100,1,1,10,5}));
    }
}
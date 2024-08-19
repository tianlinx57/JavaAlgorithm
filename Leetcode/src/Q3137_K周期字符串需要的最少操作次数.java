import java.util.HashMap;
import java.util.Map;

public class Q3137_K周期字符串需要的最少操作次数 {

    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        int n = word.length()/k;
        Map<String,Integer> map = new HashMap<>();

        int max = 0;
        for(int i=0;i<n;i++){
            String s = word.substring(i * k, (i + 1) * k);
            if(map.containsKey(s)){
                map.replace(s,map.get(s)+1);
                max = Math.max(max,map.get(s));
                continue;
            }
            map.put(s,1);
            max = Math.max(max,1);
        }
        return n-max;
    }


    public static void main(String[] args) {
        Q3137_K周期字符串需要的最少操作次数 solution = new Q3137_K周期字符串需要的最少操作次数();
        System.out.println(solution.minimumOperationsToMakeKPeriodic(new String("leetcodeleet"),4));
    }
}
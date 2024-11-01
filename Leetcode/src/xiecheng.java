import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class xiecheng {

    boolean xxx(List<Integer> nums){
        // int n = nums.size();
        // return dfs(0,nums,n);
        int max = nums.get(0);
        int n = nums.size();
        for(int i=1;i<n;i++){
            if(max < i) return false;
            max = Math.max(max,i+nums.get(i));
        }
        return true;
    }
    // boolean dfs(int start,List<Integer> nums,int n){
    //     if(start == n) return true;
    //     int step = nums.get(start);
    //     boolean res = false;
    //     for(int i=1;i<=step;++i){
    //         res |= dfs(start+i,nums,n);
    //     }
    //     return res;
    // }

    public static void main(String[] args) {
        xiecheng solution = new xiecheng();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        System.out.println(solution.xxx( list));
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(0);
        list2.add(1);
        System.out.println(solution.xxx( list2));

        List<String> arrayList = new ArrayList<>();
        List<String> synchronizedList = Collections.synchronizedList(arrayList);

        ThreadLocal<Integer> threadLocal1 = new ThreadLocal<>();
        threadLocal1.set(100);
        System.out.println(1);//
    }
}
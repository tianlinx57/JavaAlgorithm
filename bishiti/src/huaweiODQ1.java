import java.util.*;

public class huaweiODQ1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int n = 0;
        while (in.hasNext()) {
            list.add(in.nextInt());
            ++n;
        }
        Integer[] nums = list.toArray(new Integer[list.size()]);
        if(n == 1) {
            System.out.println(nums[0]);
            return;
        }
        dfs(1,n,nums);
    }
    static void dfs(int i,int n, Integer[] nums) {
        if(2*i > n){
            return;
        }
        dfs(i*2, n,nums);
        dfs(i*2+1, n,nums);
        System.out.print(nums[i-1]);
        System.out.print(" ");
    }
}

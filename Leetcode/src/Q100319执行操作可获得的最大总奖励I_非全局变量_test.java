import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q100319执行操作可获得的最大总奖励I_非全局变量_test {
    public int maxTotalReward(int[] rewardValues) {
        System.out.println(Arrays.toString(rewardValues));
        dfs(rewardValues);
        System.out.println(Arrays.toString(rewardValues));
        return 1;
    }

    void dfs(int[] nums){
        //根据nums生成一个副本
        // temp[0] = 999;
        // nums[0] = 100;
    }

    public static void main(String[] args) {
        Q100319执行操作可获得的最大总奖励I_非全局变量_test solution = new Q100319执行操作可获得的最大总奖励I_非全局变量_test();
        System.out.println(solution.maxTotalReward(new int[]{1,1,3,3}));
    }
}
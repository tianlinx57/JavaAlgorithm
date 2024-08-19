import java.util.*;

public class Q100319执行操作可获得的最大总奖励I {
    int[] nums;
    int ans = 0;
    boolean done = false;
    public int maxTotalReward(int[] rewardValues) {
        Arrays.sort(rewardValues);
        List<Integer> list = new ArrayList<>();

        int now = 0;
        int n = rewardValues.length;
        for(int i=0;i<n;i++){
            if(rewardValues[i] > now){
                list.add(rewardValues[i]);
                now = rewardValues[i];
            }
        }
        nums = new int[list.size()];
        for(int i=0;i<list.size();i++){
            nums[i] = list.get(i);
        }
        int max = nums[nums.length-1];
        dfs(0,max,0);
        return ans;
    }

    void dfs(int startIndex, int max, int sum){
        if(done) return;
        if(sum == max-1){
            ans = max + sum;
            done = true;
            return;
        }
        if(sum >= max){
            ans = Math.max(ans,sum);
            return;
        }
        for(int i=startIndex;i< nums.length;i++){
            if(sum >= nums[i]) continue;
            dfs(i+1,max,sum+nums[i]);
        }
    }

    public static void main(String[] args) {
        Q100319执行操作可获得的最大总奖励I solution = new Q100319执行操作可获得的最大总奖励I();
        ClassLoader classLoader1 = solution.getClass().getClassLoader();
        System.out.println(classLoader1);
        System.out.println(classLoader1.getParent());
        System.out.println(classLoader1.getParent().getParent());
        System.out.println(solution.maxTotalReward(new int[]{1,1,3,3}));
    }
}
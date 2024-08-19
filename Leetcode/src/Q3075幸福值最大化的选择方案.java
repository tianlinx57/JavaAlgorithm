import java.util.Arrays;

public class Q3075幸福值最大化的选择方案 {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n = happiness.length;
        Arrays.sort(happiness);

        long ans = 0;
        int number = 0;
        // for(int i=0;i<n;i++){
        //     if(happiness[i] < k-1){
        //         ans+=happiness[i];
        //         number++;
        //     }else {
        //         break;
        //     }
        // }
        for(int i=n-1;i>=0;i--){
            if(number == k) break;

            ans += Math.max(0,happiness[i]-number);

            number++;
        }

        return ans;

    }

    public static void main(String[] args) {
        Q3075幸福值最大化的选择方案 solution = new Q3075幸福值最大化的选择方案();

        // System.out.println(solution.maximumHappinessSum(new int[]{1,2,3},2));
        System.out.println(solution.maximumHappinessSum(new int[]{12,1,42},3));
    }
}
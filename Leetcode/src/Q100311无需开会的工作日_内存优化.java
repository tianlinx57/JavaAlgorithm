import java.util.Arrays;

public class Q100311无需开会的工作日_内存优化 {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings,(p, q) -> p[0] - q[0]);
        int ans = 0;
        int right = 0;
        int n = meetings.length;
        for(int i=0;i<n;i++){
            if(meetings[i][0] > right+1){
                ans += meetings[i][0]-right-1;
            }
            right = Math.max(right,meetings[i][1]);
        }
        ans += days - right;
        return ans;
    }

    public static void main(String[] args) {
        Q100311无需开会的工作日_内存优化 solution = new Q100311无需开会的工作日_内存优化();

        System.out.println(solution.countDays(10,new int[][]{{5,7},{1,3},{9,10}}));
    }
}
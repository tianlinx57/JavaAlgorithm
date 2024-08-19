import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeSet;


public class week137Q3放三个车的价值之和最大I {
    TreeSet<long[]> treeSet = new TreeSet<>((a, b) -> {
        // 比较第一个元素
        if (a[0] != b[0]) {
            return Long.compare(a[0], b[0]);
        }
        // 如果第一个元素相同，比较第二个元素
        if (a[1] != b[1]) {
            return Long.compare(a[1], b[1]);
        }
        // 如果第二个元素也相同，比较第三个元素
        return Long.compare(a[2], b[2]);
    });
    public long maximumValueSum(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                treeSet.add(new long[]{board[i][j],i,j});
            }
        }

        ArrayList<long[]> banned = new ArrayList<>();
        long ans = Long.MIN_VALUE;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                banned = new ArrayList<>();
                long temp = 0;
                temp += board[i][j];
                banned.add(new long[]{board[i][j],i,j});
                long[] max1 = search(banned);
                long[] max2 = search2(banned);
                // System.out.println(i+" "+j+" "+max1[0]+" "+max2[0]);
                banned.add(max1);
                long[] third=search(banned);
                temp += max1[0] + third[0];


                banned.removeLast();
                banned.add(max2);
                third=search(banned);
                temp = Math.max(temp,max2[0] + third[0] + board[i][j]);


                ans = Math.max(ans,temp);
            }
        }
        return ans;
    }
    //ban后第一大的
    long[] search(ArrayList<long[]> banned){
        outer:
        for(long[] nums : treeSet.descendingSet()){
            for(long[] ban:banned){
                if(nums[1]==ban[1]) {
                    continue outer;
                }
                if(nums[2]==ban[2]) {
                    continue outer;
                }
            }
            return new long[]{nums[0],nums[1],nums[2]};
        }
        return new long[]{0,0,0};
    }
    //ban后第二大的
    long[] search2(ArrayList<long[]> banned){
        int flag = 0;
        outer:
        for(long[] nums : treeSet.descendingSet()){
            for(long[] ban:banned){
                if(nums[1]==ban[1]) {
                    continue outer;
                }
                if(nums[2]==ban[2]) {
                    continue outer;
                }
            }
            if(flag==0) flag++;
            else{
                return new long[]{nums[0],nums[1],nums[2]};
            }

        }
        return new long[]{0,0,0};
    }
    public static void main(String[] args) {
        week137Q3放三个车的价值之和最大I solution = new week137Q3放三个车的价值之和最大I();
        // System.out.println(solution.maximumValueSum(new int[][]{{-3,1,1,1},{-3,1,-3,1},{-3,2,1,1}}));
        // System.out.println(solution.maximumValueSum(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
        // System.out.println(solution.maximumValueSum(new int[][]{{1,1,1},{1,1,1},{1,1,1}}));
        System.out.println(solution.maximumValueSum(new int[][]{{82,24,11},{95,91,-8},{-89,-30,-29}}));//144
    }
}
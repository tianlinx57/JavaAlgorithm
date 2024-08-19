import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.TreeSet;


public class week137Q3放三个车的价值之和最大I_错误 {
    PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b)->{return b[0]-a[0];});
    TreeSet<int[]> treeSet = new TreeSet<>((a, b) -> {
        // 比较第一个元素
        if (a[0] != b[0]) {
            return Integer.compare(a[0], b[0]);
        }
        // 如果第一个元素相同，比较第二个元素
        if (a[1] != b[1]) {
            return Integer.compare(a[1], b[1]);
        }
        // 如果第二个元素也相同，比较第三个元素
        return Integer.compare(a[2], b[2]);
    });
    public long maximumValueSum(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                priorityQueue.add(new int[]{board[i][j],i,j});
                treeSet.add(new int[]{board[i][j],i,j});
            }
        }

        // System.out.println(treeSet.size());
        int max1 = Integer.MIN_VALUE;
        int[] xy1 = new int[2];
        int max2 = Integer.MIN_VALUE;
        int[] xy2 = new int[2];
        int max3 = Integer.MIN_VALUE;
        int[] xy3 = new int[2];
        int max4 = Integer.MIN_VALUE;
        int[] xy4 = new int[2];
        int[] peek=priorityQueue.remove();
        max1 = peek[0];
        xy1 =  new int[]{peek[1],peek[2]};

        peek=priorityQueue.remove();
        max2 = peek[0];
        xy2 =  new int[]{peek[1],peek[2]};

        peek=priorityQueue.remove();
        max3 = peek[0];
        xy3 =  new int[]{peek[1],peek[2]};

        peek=priorityQueue.remove();
        max4 = peek[0];
        xy4 =  new int[]{peek[1],peek[2]};

        priorityQueue.offer(new int[]{max1,xy1[0],xy1[1]});
        priorityQueue.offer(new int[]{max2,xy2[0],xy2[1]});
        priorityQueue.offer(new int[]{max3,xy3[0],xy3[1]});
        priorityQueue.offer(new int[]{max4,xy4[0],xy4[1]});

        // System.out.println(max1+","+xy1[0]+","+xy1[1]);
        // System.out.println(max2+","+xy2[0]+","+xy2[1]);
        // System.out.println(max3+","+xy3[0]+","+xy3[1]);

        long ans = 0;
        ans += max1;
        ArrayList<int[]> banned = new ArrayList<>();
        banned.add(new int[]{max1,xy1[0],xy1[1]});
        int[] newpoint = search(banned);
        ans += newpoint[0];
        banned.add(new int[]{newpoint[0],newpoint[1],newpoint[2]});

        newpoint = search(banned);
        ans += newpoint[0];
        banned.add(new int[]{newpoint[0],newpoint[1],newpoint[2]});
        // for(int[] tt:banned){
        //     System.out.println(Arrays.toString(tt));
        // }


        long newans = max2;
        banned = new ArrayList<>();
        banned.add(new int[]{max2,xy2[0],xy2[1]});
        newpoint = search(banned);
        newans += newpoint[0];
        banned.add(new int[]{newpoint[0],newpoint[1],newpoint[2]});
        newpoint = search(banned);
        newans += newpoint[0];

        ans = Math.max(ans,newans);

        //第三大
        newans = max3;
        banned = new ArrayList<>();
        banned.add(new int[]{max3,xy3[0],xy3[1]});
        newpoint = search(banned);
        newans += newpoint[0];
        banned.add(new int[]{newpoint[0],newpoint[1],newpoint[2]});
        newpoint = search(banned);
        newans += newpoint[0];

        ans = Math.max(ans,newans);

        //第四大
        newans = max4;
        banned = new ArrayList<>();
        banned.add(new int[]{max4,xy4[0],xy4[1]});
        newpoint = search(banned);
        newans += newpoint[0];
        banned.add(new int[]{newpoint[0],newpoint[1],newpoint[2]});
        newpoint = search(banned);
        newans += newpoint[0];

        ans = Math.max(ans,newans);

        //1不要2
        newans = max1;
        banned = new ArrayList<>();
        banned.add(new int[]{max1,xy1[0],xy1[1]});
        newpoint = search2(banned);
        System.out.println(newpoint[0]);
        newans += newpoint[0];
        banned.add(new int[]{newpoint[0],newpoint[1],newpoint[2]});
        newpoint = search(banned);
        System.out.println(newpoint[0]);
        newans += newpoint[0];

        ans = Math.max(ans,newans);

        return ans;
    }

    int[] search2(ArrayList<int[]> banned){
        int flag = 0;
        outer:
        for(int[] nums : treeSet.descendingSet()){
            for(int[] ban:banned){
                if(nums[1]==ban[1]) {
                    continue outer;
                }
                if(nums[2]==ban[2]) {
                    continue outer;
                }
            }
            if(flag==0) flag++;
            else{
                return new int[]{nums[0],nums[1],nums[2]};
            }

        }
        return new int[]{0,0,0};
    }

    int[] search(ArrayList<int[]> banned){
        outer:
        for(int[] nums : treeSet.descendingSet()){
            for(int[] ban:banned){
                if(nums[1]==ban[1]) {
                    continue outer;
                }
                if(nums[2]==ban[2]) {
                    continue outer;
                }
                if(nums[0]>ban[0]){
                    continue outer;
                }
            }
            return new int[]{nums[0],nums[1],nums[2]};
        }
        return new int[]{0,0,0};
    }
    public static void main(String[] args) {
        week137Q3放三个车的价值之和最大I_错误 solution = new week137Q3放三个车的价值之和最大I_错误();
        // System.out.println(solution.maximumValueSum(new int[][]{{-3,1,1,1},{-3,1,-3,1},{-3,2,1,1}}));
        // System.out.println(solution.maximumValueSum(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
        // System.out.println(solution.maximumValueSum(new int[][]{{1,1,1},{1,1,1},{1,1,1}}));
        // System.out.println(solution.maximumValueSum(new int[][]{{82,24,11},{95,91,-8},{-89,-30,-29}}));
        System.out.println(solution.maximumValueSum(new int[][]{{70,-16,31},{2,75,37},{67,-95,-44}}));
    }
}
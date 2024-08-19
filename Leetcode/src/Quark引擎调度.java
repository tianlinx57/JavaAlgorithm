import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Quark引擎调度 {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] jobs = new int[n][3];
        int i = 0;
        for(int j=0;j<n;j++) { // 注意 while 处理多个 case
            jobs[i][0] = in.nextInt();
            jobs[i][1] = in.nextInt();
            jobs[i][2] = in.nextInt();
            ++i;
        }

        //int[0]到达时间 int[1]task数量 int[2]执行需要时间
        // deque里存放任务结束时间
        Deque<Integer> deque = new ArrayDeque<>();
        int[] ans = new int[n];

        int remainingTask = m;
        int RealTime = 0;
        for(i=0;i<n;i++){
            if(remainingTask > jobs[i][1]){
                for(int k = 0;k<jobs[i][1];k++){
                    deque.offer(Math.max(RealTime,jobs[i][0]) + jobs[i][2]);
                }
                remainingTask -= jobs[i][1];
                ans[i] = Math.max(RealTime,jobs[i][0]) + jobs[i][2];
                continue;
            }

            int todoTimes = Math.min(remainingTask,jobs[i][1]);
            for(int k = 0;k<todoTimes;k++){
                deque.offer(Math.max(RealTime,jobs[i][0]) + jobs[i][2]);
            }

            jobs[i][1] -= todoTimes;
            remainingTask -= todoTimes;

            while(jobs[i][1] != 0){
                RealTime = deque.removeFirst();
                deque.offer(Math.max(RealTime,jobs[i][0]) + jobs[i][2]);
                jobs[i][1]--;
            }

            ans[i] = Math.max(RealTime,jobs[i][0]) + jobs[i][2];
        }
        for(i=0;i<n;i++){
            System.out.println(ans[i]);
        }
    }
}


import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int times = Integer.parseInt(in.nextLine());
 
        for(int i=0;i<times;i++){
            int n = in.nextInt();
            long[] values = new long[n+1];
            int[] flags = new int[n+1];
            Arrays.fill(flags, -1);
            for(int j=1;j<=n;j++){
                values[j] = in.nextLong();
            }
            Deque<int[]> deque = new ArrayDeque<>();
            for(int j=0;j<n-1;j++){
                int point1 = in.nextInt();
                int point2 = in.nextInt();
                int[] temp = new int[]{point1,point2};
                deque.offer(temp);
            }
            
            flags[1] = 0;
            while(!deque.isEmpty()){
                int[] temp = deque.poll();
                int point1 = temp[0];
                int point2 = temp[1];
                if(flags[point1] == -1 && flags[point2] == -1){
                    deque.offer(temp);
                    continue;
                }else if(flags[point1]!= -1 && flags[point2] == -1){
                    flags[point2] = 1^flags[point1];
                }else if(flags[point1] == -1 && flags[point2]!= -1){
                    flags[point1] = 1^flags[point2];
                }
            }
 
            long count0 = 0;
            long count1 = 0;
            for(int j=1;j<=n;j++){
                if(flags[j] == 0){
                    count0 += values[j];
                }else{
                    count1 += values[j];
                }
            }
            // System.out.println(Arrays.toString(flags));
            // System.out.println(count0);
            // System.out.println(count1);
            if(count0 < count1) {
                System.out.println(count1 + count0*2);
            } else{
                System.out.println(count0 + count1*2);
            }
            // System.out.println();
 
        }
    }
}

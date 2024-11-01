import java.util.Map;
import java.util.TreeMap;

public class vivoQ1 {

    public int staffGroup (int[] staff) {
        int count0 = 0, count1 = 0;
        for(int i:staff){
            if(i==0)count0++;
            else count1++;
        }
        int ans = 0;
        ans += count1;
        count0 -= count1;
        if(count0<=0) return ans;
        ans += count0/3;
        if(count0%3!=0) ++ans;
        return ans;
    }

    public static void main(String[] args) {
        vivoQ1 solution = new vivoQ1();
        System.out.println(solution.staffGroup(new int[]{1,0,0,0,1}));
    }
}
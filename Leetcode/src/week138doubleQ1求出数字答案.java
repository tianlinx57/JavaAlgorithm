import java.util.Arrays;
import java.util.PriorityQueue;

public class week138doubleQ1求出数字答案 {
    public int generateKey(int num1, int num2, int num3) {
        int ans = 0;
        int mod = 1;
        for(int i=0;i<4;i++){
            int a = num1%10;
            int b = num2%10;
            int c = num3%10;
            int min = Math.min(a,b);
            min = Math.min(min,c);

            ans += min*mod;
            mod*=10;
            num1 /= 10;
            num2 /= 10;
            num3 /= 10;
        }
        return ans;
    }
    public static void main(String[] args) {
        week138doubleQ1求出数字答案 solution = new week138doubleQ1求出数字答案();
        System.out.println(solution.generateKey(1,10,1000));
    }
}
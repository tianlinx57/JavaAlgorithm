import java.util.Scanner;

public class 整数切割 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        long number = in.nextLong();


        long first = 0, second = 0;

        first = number/10;
        second = Math.abs(number%10);
        long ans = first+second;

        long weishu = 10;
        while(Math.abs(number/weishu) != 0){
            first = number/weishu;
            second = Math.abs(number)%weishu;
            weishu *= 10;
        }
        ans = Math.max(ans,first+second);

        System.out.println(ans);

    }
}

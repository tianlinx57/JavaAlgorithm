import java.util.Arrays;
import java.util.Scanner;

public class baiduQ1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String str = in.nextLine();
        String[] times = str.split(" ");
        for(int i=1;i<n;i++){
            double ans = 0;
            String now = times[i];
            String before = times[i-1];
            String[] now_fenge = now.split(":");
            String[] before_fenge = before.split(":");
            double hour_now = Integer.parseInt(now_fenge[0]);
            double hour_before = Integer.parseInt(before_fenge[0]);
            double minuit_now = Integer.parseInt(now_fenge[1]);
            double minuit_before = Integer.parseInt(before_fenge[1]);
            double second_now = Integer.parseInt(now_fenge[2]);
            double second_before = Integer.parseInt(before_fenge[2]);
            if(hour_now < hour_before || (hour_now == hour_before && minuit_now < minuit_before) || (hour_now == hour_before && minuit_now == minuit_before && second_now < second_before)) hour_now+= 24;
            ans += (hour_now - hour_before)*60;
            ans += (minuit_now - minuit_before);
            ans += (second_now - second_before)/60;
            System.out.println(ans);
        }
    }
}

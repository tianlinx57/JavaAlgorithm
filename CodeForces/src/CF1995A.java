import java.util.HashMap;
import java.util.Scanner;

public class CF1995A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Cases = Integer.parseInt(in.nextLine());

        for(;Cases>0;Cases--) {
            int n = in.nextInt();
            int k = in.nextInt();
            int ans = 0;
            while(k>0) {
                k -= n - (ans+1)/2;
                ++ans;
            }
            System.out.println(ans);
        }
    }
}

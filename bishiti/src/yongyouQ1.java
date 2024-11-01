import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class yongyouQ1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int shengyu = in.nextInt();
        if(shengyu == 0) {
            System.out.println(false);
            return;
        }
        --shengyu;
        while (true) {
            if(!in.hasNext()) {
                System.out.println(true);
                break;
            }
            int n = in.nextInt();
            shengyu = Math.max(shengyu,n);
            --shengyu;
            if(shengyu == -1) {
                // if(!in.hasNext()) {
                //     System.out.println(true);
                //     break;
                // }
                System.out.println(false);
                break;
            }
            
        }
    }
}

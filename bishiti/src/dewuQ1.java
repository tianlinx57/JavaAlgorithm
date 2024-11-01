import java.util.Arrays;
import java.util.Scanner;

public class dewuQ1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        String[] strs = string.split(" ");
        int sum = 0;
        // for(int i=0;i<4;i++){
        //     int a = Integer.parseInt(strs[0].substring(i, i+1));
        //     int b = Integer.parseInt(strs[1].substring(i, i+1));
        //     int abs = Math.abs(a-b);
        //     sum += Math.min(10-abs, abs);
        // }
        // System.out.println(sum);
        for(int i=0;i<4;i++){
            int a = Integer.parseInt(strs[0].substring(i, i+1));
            int b = Integer.parseInt(strs[1].substring(i, i+1));
            if(a < b){
                sum += 10+a-b;
            }else{
                sum += a-b;
            }
        }
        System.out.println(sum);
    }
}

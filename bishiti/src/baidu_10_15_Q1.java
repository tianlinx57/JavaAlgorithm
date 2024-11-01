import java.util.Arrays;
import java.util.Scanner;

public class baidu_10_15_Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Cases = Integer.parseInt(in.nextLine());
        for(int i=0;i<Cases;i++){
            long n = in.nextLong();
            long k = in.nextLong();
            long max = (n+1)/2;
            if(n%2==1){
                if(k<=max){
                    System.out.println(k);
                }else{
                    System.out.println(n+1-k);
                }
            }else{
                if(k<=max){
                    System.out.println(k);
                }else{
                    System.out.println(n+1-k);
                }
            }
        }
    }
}

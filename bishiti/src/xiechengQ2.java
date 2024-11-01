import java.util.Arrays;
import java.util.Scanner;

public class xiechengQ2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = Long.parseLong(in.nextLine());
        int days = 0 ;
        while (n>0) {
            ++days;
            if(n==1) break;
            if(isOdd(n)){
                n -= n/3 + 1;
            }else{
                n -= n/2 + 1;
            }
        }
        System.out.println(days);
    }
    static boolean isOdd(long n){
        double sqrt = Math.sqrt((double)n);
        for(int i=2; i<=sqrt; i++){
            if(n%i==0) return false;
        }
        return true;
    }
}

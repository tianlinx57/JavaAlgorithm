import java.util.Scanner;

public class meituanQ1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long a = in.nextLong();
        long b = in.nextLong();
        long c = in.nextLong();
        long d = in.nextLong();

        long n = in.nextLong();
        long sum = 0 ;
        long max = Long.MIN_VALUE;
        // long max_distance = 0;
        for(int i=0;i<n;i++){
            long x = in.nextLong();
            long y = in.nextLong();
            long b_temp = Math.abs(x-c)+Math.abs(y-d);
            long a_temp = Math.abs(x-a)+Math.abs(y-b);
            long chaju = b_temp-a_temp;
            if(chaju>max){
                max = chaju;
                // max_distance = b_temp;
            }

            sum = sum + b_temp + b_temp;
            // System.out.println(min);
            // System.out.println(min_distance);
            // System.out.println();
        }
        sum -= max;
        System.out.println(sum);
    }
}

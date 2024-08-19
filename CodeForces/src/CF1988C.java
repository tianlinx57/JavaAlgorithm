import java.util.Scanner;

public class CF1988C {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Cases = Integer.parseInt(in.nextLine());

        for(int i=0;i<Cases;i++){
            long n = in.nextLong();
            int bitcount = Long.bitCount(n);
            if(bitcount == 1){
                System.out.println(1);
                System.out.println(n);
                continue;
            }
            System.out.println(bitcount+1);
            long buyongde1 = Long.highestOneBit(n);
            while(buyongde1 != 0){
                if((buyongde1 & n) == 0) {
                    buyongde1 = buyongde1 >> 1;
                    continue;
                }
                long blockCode = (-1) ^ buyongde1;
                System.out.print(n & blockCode);
                System.out.print(" ");
                buyongde1 = buyongde1 >> 1;
            }
            System.out.println(n);
        }
    }
}
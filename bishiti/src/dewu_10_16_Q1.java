import java.util.Arrays;
import java.util.Scanner;

public class dewu_10_16_Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Cases = Integer.parseInt(in.nextLine());
        for(int cc=0;cc<Cases;++cc){
            Double n = Double.parseDouble(in.nextLine());
            String String1 = in.nextLine();
            String String2 = in.nextLine();
            int count = 0;
            for(int i=0;i<n;++i){
                if(String1.charAt(i)==String2.charAt(i)){
                    ++count;
                }
            }
            if(count<n/2){
                System.out.println("oh no");
            }
            else if(count>n/2){
                System.out.println("oh yes");
            }
            else{
                System.out.println("(O.O)");
            }
        }
        
    }
}

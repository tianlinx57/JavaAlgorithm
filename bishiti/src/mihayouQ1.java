import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class mihayouQ1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) { 
            int a = in.nextInt();
            int b = in.nextInt();
            int max = 0;
            int count46 = 0;
            for(int i=b;i>=a;i--){
                if(count(i)>count46){
                    max = i;
                    count46 = count(i);
                }
            }
            System.out.println(max);
        }
    }
    static int count(int a){
        int count = 0;
        int temp = a;
        while(temp!=0){
            int num = temp%10;
            if(num==4 || num==6){
                count++;
            }
            temp /= 10;
        }
        return count;
    }
    
}

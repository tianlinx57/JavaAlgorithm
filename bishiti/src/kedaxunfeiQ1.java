import java.util.Arrays;
import java.util.Scanner;

public class kedaxunfeiQ1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        for(int i=0;i<n;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(b+a*b);
        }
    }
}

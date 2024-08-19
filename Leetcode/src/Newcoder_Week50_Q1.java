import java.util.Scanner;

public class Newcoder_Week50_Q1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int x = in.nextInt();

        if(Math.min(a,b)+x > Math.max(a,b)){
            System.out.println("YES");
            return;
        }
        System.out.println("NO");
    }
}

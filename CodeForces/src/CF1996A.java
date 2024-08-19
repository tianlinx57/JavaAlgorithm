import java.util.*;

public class CF1996A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Cases = Integer.parseInt(in.nextLine());

        for(;Cases>0;Cases--) {
            int n = in.nextInt();
            System.out.println(n/4 + (n%4==0?0:1));
        }
    }
}

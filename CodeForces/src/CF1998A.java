import java.util.*;

public class CF1998A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Cases = Integer.parseInt(in.nextLine());

        for(;Cases>0;Cases--) {
            int x = in.nextInt();
            int y = in.nextInt();
            int k = in.nextInt();
            if(k%2 == 1){
                System.out.println(x+" "+y);
            }
            for(int i=1;i<=k/2;i++){
                System.out.println((x-i) + " " + (y));
                System.out.println((x+i) + " " + (y));
            }
        }
    }
}

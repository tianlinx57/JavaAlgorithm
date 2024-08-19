// package CodeForces.round957div3;

import java.util.Scanner;

public class Q1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int times = in.nextInt();

        for(int i=0;i<times;i++){
            int n = in.nextInt();
            int m = in.nextInt();
            int k = in.nextInt();

            int x0 = in.nextInt();
            int y0 = in.nextInt();
            int jiou = (x0+y0)%2;
            
            int temp = 0;
            for(int j=0;j<k;j++) {
                int x = in.nextInt();
                int y = in.nextInt();
                if((x+y)%2 == jiou && temp == 0) {
                    System.out.println("NO");
                    temp = 1;
                }
            }
            if(temp == 0){
                System.out.println("YES");
            }
            
        }
    

    }



}

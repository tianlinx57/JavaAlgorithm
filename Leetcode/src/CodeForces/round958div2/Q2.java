package CodeForces.round958div2;

import java.util.Scanner;

public class Q2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int times = Integer.parseInt(in.nextLine());
 
        for(int i=0;i<times;i++){
            int n = Integer.parseInt(in.nextLine());
            String string = in.nextLine();
            char[] chars = string.toCharArray();
            int count0 = 0;
            int count1 = 0;
            int flag = 0;

            for(int j=0;j<n;j++){
                if(chars[j] == '0'){
                    if(flag == 0){
                        flag = 1;
                        count0++;
                    }
                    
                }else {
                    flag = 0;
                    count1++;
                }
            }
            // System.out.println(string);
            // System.out.println(count0);
            // System.out.println(count1);
            
            if(count1 > count0){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }



}


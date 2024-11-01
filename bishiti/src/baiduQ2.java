import java.util.Arrays;
import java.util.Scanner;

public class baiduQ2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        for(int i=0;i<n;i++){
            String str = in.nextLine();
            String[] strs = str.split(" ");
            // System.out.println(strs[2].equals("*"));
            if(strs[2].equals("+") || strs[2].equals("*")){
                System.out.println("=");
                continue;
            }
            if (strs[1].equals(strs[0])) {
                System.out.println("=");
                continue;
            }
            int a = Integer.parseInt(strs[0]);
            int b = Integer.parseInt(strs[1]);
            if(strs[2].equals("/") || strs[2].equals("-")){
                if(a>b) {
                    System.out.println(">");
                    continue;
                } else{
                    System.out.println("<");
                    continue;
                }
            }
            if(Math.min(a, b) == 1){
                if(a<b){
                    System.out.println("<");
                } else{
                    System.out.println(">");
                }
            } else if(Math.min(a, b) == 2){
                if(Math.max(a, b)==4){
                    System.out.println("=");
                } else if(Math.max(a, b)<4){
                    if(a<b){
                        System.out.println("<");
                    } else{
                        System.out.println(">");
                    }
                } else{
                    if(a<b){
                        System.out.println(">");
                    } else{
                        System.out.println("<");
                    }
                }
            }else{
                if(a<b){
                    System.out.println(">");
                } else{
                    System.out.println("<");
                }
            }
        }
    }
}

import java.util.Scanner;

public class CF1994B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Cases = Integer.parseInt(in.nextLine());

        for(;Cases>0;Cases--) {
            int n = Integer.parseInt(in.nextLine());
            String first = in.nextLine();
            String seconde = in.nextLine();
            int i=0,j=0;
            for(;i<n;i++){
                if(first.charAt(i) == '1'){
                    break;
                }
            }
            for(;j<n;j++){
                if(seconde.charAt(j) == '1'){
                    break;
                }
            }
            if(i<=j){
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }
}

import java.util.Scanner;

public class meituant2Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int jisum = 0;
        int ousum = 0;
        for(int i=0;i<n;i++){
            int num = in.nextInt();
            if(num%2==0){
                ousum += num+1;
            }else {
                jisum += num+1;
            }
        }
        System.out.println(Math.min(jisum,ousum));
    }
}

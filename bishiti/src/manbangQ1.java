import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class manbangQ1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        HashSet<String> names = new HashSet<>();
        outer:
        for(int i=0;i<n;i++){
            String s = in.nextLine();
            if(s.length()<6 || s.length()>12){
                System.out.println("illegal length");
                continue;
            }
            for(char c:s.toCharArray()){
                if(!(c>='a' && c<='z' || c>='A' && c<='Z' )){
                    System.out.println("illegal charactor");
                    continue outer;
                }
            }
            if(names.contains(s)){
                System.out.println("acount existed");
                continue;
            }
            names.add(s);
            System.out.println("registration complete");
        
        }
    }
}

import java.util.Arrays;
import java.util.Scanner;

public class xiechengQ1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        for(int i=0;i<n;i++){
            String s = in.nextLine();
            char[] chars = s.toCharArray();
            chars[0] += 'A'-'a';
            int count = 0;
            for(int j=1;j<=chars.length-1;j++){
                if(chars[j]=='_'){
                    ++count;
                    chars[j+1] += 'A'-'a';
                    for(int k=j;k<=chars.length-2;k++){
                        chars[k] = chars[k+1];
                    }
                }
            }
            System.out.println(new String(chars).substring(0, chars.length-count));
        }
    }
}

import java.util.Arrays;
import java.util.Scanner;

public class baidu_10_15_Q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        char[] chars = s.toCharArray();
        char[] newChars = new char[chars.length];
        for(int i=0;i<chars.length;++i){
            int temp = i;
            int index = 0;
            while (temp >= index && index < chars.length) {
                if(temp==index){
                    index++;
                    temp = chars.length-1;
                }else{
                    // index++;
                    // temp--;
                    int chaju = (temp-index+1)/2;
                    index+=chaju;
                    temp-=chaju;
                }
            }
            newChars[index-1] = chars[i];
        }
        System.out.println(new String(newChars));
    }
}

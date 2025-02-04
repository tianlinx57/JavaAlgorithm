import java.util.*;

public class huaweiODQ2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String s = in.nextLine();
        String[] split = s.split("-");
        // System.out.println(Arrays.toString(split));
        StringBuilder sb = new StringBuilder();
        sb.append(split[0]);

        StringBuilder sb2 = new StringBuilder();
        for(int i=1;i<split.length;i++) {
            sb2.append(split[i]);
        }
        String last = sb2.toString();
        int i = 0;
        while(i < last.length()) {
            int next = i+n;
            if(next > last.length()) {
                next = last.length();
            }
            String temp = last.substring(i, next);
            temp = change(temp);
            sb.append("-").append(temp);
            i = next;
        }
        System.out.println(sb.toString());
    }
    static String change(String s) {
        int len = s.length();
        int countSmall = 0;
        int countBig = 0;
        for(char c : s.toCharArray()){
            if(c>='a'&&c<='z') countSmall++;
            if(c>='A'&&c<='Z') countBig++;
        }
        StringBuilder sb = new StringBuilder();
        int flag = 0;
        if(countSmall == countBig) {return s;}
        if(countSmall > countBig) {flag = 1;}
        for(char c : s.toCharArray()){
            if(c>='a'&&c<='z') {
                if(flag == 0) sb.append(Character.toUpperCase(c));
                else sb.append(c);
                continue;
            }
            if(c>='A'&&c<='Z') {
                if(flag == 1) sb.append(Character.toLowerCase(c));
                else sb.append(c);
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}

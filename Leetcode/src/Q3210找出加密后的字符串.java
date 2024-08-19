import java.util.Arrays;

public class Q3210找出加密后的字符串 {

    public String getEncryptedString(String s, int k) {
        char[] chars = s.toCharArray();
        char[] newChars = new char[s.length()];
        for(int i=0;i<s.length();i++){
            newChars[i] = chars[(i+k)%s.length()];
        }
        return new String(newChars);
    }


    public static void main(String[] args) {
        Q3210找出加密后的字符串 solution = new Q3210找出加密后的字符串();
        System.out.println(solution.getEncryptedString("dart", 3));
    }
}
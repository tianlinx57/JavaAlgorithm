import java.util.HashMap;

public class Q100352交换后字典序最小的字符串 {

    public String getSmallestString(String s) {
        char[] chars = s.toCharArray();
        int n = s.length();
        for(int i=0;i<n-1;i++){
            if(chars[i] > chars[i+1] && (chars[i]-chars[i+1])%2 == 0){
                char temp = chars[i];
                chars[i] = chars[i+1];
                chars[i+1] = temp;
                break;
            }
        }
        return new String(chars);
    }


    public static void main(String[] args) {
        Q100352交换后字典序最小的字符串 solution = new Q100352交换后字典序最小的字符串();
        // System.out.println(solution.numberOfSubmatrices(new char[][]{{'X','Y','.'},{'Y','.','.'}}));
        System.out.println(solution.getSmallestString("45320"));
    }
}
public class week138doubleQ2哈希分割字符串 {
    public String stringHash(String s, int k) {
        int n = s.length()/k;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            int count = 0;
            String substring = s.substring(i*k,i*k+k);
            for(char c:substring.toCharArray()){
                count += c-'a';
            }
            count = count%26;
            sb.append((char)('a'+count));
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        week138doubleQ2哈希分割字符串 solution = new week138doubleQ2哈希分割字符串();
        System.out.println(solution.stringHash("abcd",2));
        System.out.println(((double)100/7 == (double)200/14));
        System.out.println((double)100/7);
    }
}
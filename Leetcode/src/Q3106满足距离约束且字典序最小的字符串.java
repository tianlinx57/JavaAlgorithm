public class Q3106满足距离约束且字典序最小的字符串 {
    public String getSmallestString(String s, int k) {
        int i=0;
        StringBuilder sb = new StringBuilder(s);
        while(k>0&&i<s.length()){
            int gap_to_a = s.charAt(i) - 'a';

            if(gap_to_a > 13){
                if(k<26-gap_to_a){
                    sb.deleteCharAt(i);
                    sb.insert(i,(char)(s.charAt(i)-k));
                    k=0;
                } else{
                    k -= 26-gap_to_a;
                    sb.deleteCharAt(i);
                    sb.insert(i,'a');
                }
            }else {
                if(k<gap_to_a){
                    sb.deleteCharAt(i);
                    sb.insert(i,(char)(s.charAt(i)-k));
                    k=0;
                }else{
                    k-=gap_to_a;
                    sb.deleteCharAt(i);
                    sb.insert(i,'a');
                }
            }
            ++i;
        }
        return new String(sb);
    }

    public static void main(String[] args) {
        Q3106满足距离约束且字典序最小的字符串 solution = new Q3106满足距离约束且字典序最小的字符串();
        // System.out.println(solution.getSmallestString("zbbz",3));
        System.out.println(solution.getSmallestString("a",26));

        // StringBuilder sb = new StringBuilder();
        // System.out.println(sb.length());
        // sb.insert(0,'a');
        // System.out.println(sb);

    }
}
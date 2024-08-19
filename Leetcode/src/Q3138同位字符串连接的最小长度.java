public class Q3138同位字符串连接的最小长度 {
    public int minAnagramLength(String s) {

        int n = s.length();

        outerLoop:
        for(int i=1;i<=n/2;i++){
            if(n%i != 0) continue;
            int[] counts = new int[26];
            for(int j=0;j<i;j++){
                counts[s.charAt(j)-'a']++;
            }
            // System.out.println(Arrays.toString(counts));
            // System.out.println();

            for(int j=1;j<n/i;j++){
                int[] new_count = new int[26];
                for(int k=0;k<i;k++){
                    int temp = s.charAt(j*i+k)-'a';
                    if(++new_count[temp] > counts[temp]){
                        continue outerLoop;
                    }
                }
            }
            return i;
        }
        return n;
    }

    public static void main(String[] args) {
        Q3138同位字符串连接的最小长度 solution = new Q3138同位字符串连接的最小长度();
        System.out.println(solution.minAnagramLength("aabbabab"));
    }
}
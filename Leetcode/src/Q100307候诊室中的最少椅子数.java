public class Q100307候诊室中的最少椅子数 {
    public int minimumChairs(String s) {
        char[] chars = s.toCharArray();
        int ans = 0;
        int now = 0;
        int n = chars.length;
        for(int i=0;i<n;i++){
            if(chars[i] == 'E'){
                now++;
                ans = Math.max(ans,now);
            }else {
                now--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Q100307候诊室中的最少椅子数 solution = new Q100307候诊室中的最少椅子数();

        System.out.println(solution.minimumChairs("EEEEEEE"));
    }
}
public class Q100336交替组I {
    public int numberOfAlternatingGroups(int[] colors) {
        int n = colors.length;
        int ans = 0;
        for(int i=0;i<n;i++){
            if(colors[i]!=colors[(i+1)%n] && colors[(i+1)%n]!=colors[(i+2)%n]){
                ++ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Q100336交替组I solution = new Q100336交替组I();
        ClassLoader classLoader1 = solution.getClass().getClassLoader();
    }
}
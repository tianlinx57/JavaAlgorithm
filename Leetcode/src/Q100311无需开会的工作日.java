public class Q100311无需开会的工作日 {
    public int countDays(int days, int[][] meetings) {
        int[] meets = new int[days+2];
        int n = meetings.length;
        for(int i=0;i<n;i++){
            meets[meetings[i][0]]++;
            meets[meetings[i][1]+1]--;
        }

        int ans = 0;
        int temp = 0;
        for(int i=1;i<=days;i++){
            temp += meets[i];
            if(temp == 0){
                ++ans;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        Q100311无需开会的工作日 solution = new Q100311无需开会的工作日();

        System.out.println(solution.countDays(10,new int[][]{{5,7},{1,3},{9,10}}));
    }
}
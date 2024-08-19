import java.util.Arrays;
import java.util.HashMap;

public class Q3160所有球里面不同颜色的数目_两个hashmap {
    public int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;

        HashMap<Integer,Integer> number_of_color = new HashMap<>();
        HashMap<Integer,Integer> colors_of_balls = new HashMap<>();

        // System.out.println("1");

        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            int ball = queries[i][0];
            int color = queries[i][1];

            if(!colors_of_balls.containsKey(ball)){
                number_of_color.put(color,number_of_color.getOrDefault(color,0)+1);
            }else if (colors_of_balls.get(ball) != color){
                int old_color = colors_of_balls.get(ball);
                int new_color = queries[i][1];

                if(number_of_color.get(old_color) == 1){
                    number_of_color.remove(old_color);
                }else {
                    number_of_color.put(old_color,number_of_color.get(old_color)-1);
                }

                number_of_color.put(new_color,number_of_color.getOrDefault(new_color,0)+1);
            }
            colors_of_balls.put(ball,color);

            ans[i] = number_of_color.size();
        }
        return ans;

    }

    public static void main(String[] args) {
        Q3160所有球里面不同颜色的数目_两个hashmap solution = new Q3160所有球里面不同颜色的数目_两个hashmap();

        // System.out.println(Arrays.toString(solution.queryResults(4,new int[][]{{1,4}, {2,5},{1,3},{3,4}})));
        System.out.println(Arrays.toString(solution.queryResults(1,new int[][]{{0,1}, {0,4},{0,4},{0,1},{1,2}})));
    }
}
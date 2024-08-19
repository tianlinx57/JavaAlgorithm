import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q100393矩阵中的蛇 {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int place = 0;
        for(String s:commands){
            if(s.equals("RIGHT")){
                place+=1;
            }
            if(s.equals("LEFT")){
                place-=1;
            }
            if(s.equals("UP")){
                place-=n;
            }
            if(s.equals("DOWN")){
                place+=n;
            }
        }
        return place;
    }
    public static void main(String[] args) {
        Q100393矩阵中的蛇 solution = new Q100393矩阵中的蛇();
        System.out.println(solution.finalPositionOfSnake(2,new ArrayList<>(Arrays.asList("RIGHT","DOWN"))));
    }
}
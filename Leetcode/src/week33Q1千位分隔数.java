import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


public class week33Q1千位分隔数 {
    public String thousandSeparator(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(n);
        int index = sb.length() - 3;
        while(index>0){
            sb.insert(index,".");
            index -= 3;
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        week33Q1千位分隔数 solution = new week33Q1千位分隔数();
        System.out.println(solution.thousandSeparator(123456789));
    }
}
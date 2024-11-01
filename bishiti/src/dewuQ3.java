import java.util.*;

public class dewuQ3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String s = in.nextLine();
        Deque<Integer> deque = new ArrayDeque<>();
        int max = 0;
        for(int i=0;i<n;i++){
            if(deque.isEmpty()){
                max = i;
            }
            if(s.charAt(i) == '('){
                deque.add(1);
            } else {
                if(deque.isEmpty()){
                    System.out.println(i);
                    return;
                }
                deque.removeLast();
            }
        }
        if(deque.isEmpty()){
            System.out.println(n);
        } else{
            System.out.println(max);
        }
    }
}


import java.util.*;

public class manbangQ4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c = in.nextInt();
        HashMap<Integer,HashSet<Integer>> hashMap = new HashMap<>();
        
        for(int i=0;i<n;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            if(!hashMap.containsKey(a)){
                hashMap.put(a, new HashSet<>());
            }
            hashMap.get(a).add(b);
        }
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(c);
        HashSet<Integer> ans = new HashSet<>();
        while (!deque.isEmpty()) {
            int a = deque.pollFirst(); 
            ans.add(a);
            HashSet<Integer> hashSet = hashMap.get(a);
            
            if (hashSet != null) {
                for (int i : hashSet) {
                    if (!ans.contains(i)) {
                        deque.add(i);
                        // ans.add(i);
                    }
                }
            }
        }
        // for(int i:ans) System.out.println(i);
        System.out.println(ans.size());
    }
}

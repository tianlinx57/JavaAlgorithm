import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Q242有效的字母异位词 {

    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0 ; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }else{
                map.put(s.charAt(i),1);
            }

        }
        for(int i = 0 ; i < t.length(); i++){
            if(map.containsKey(t.charAt(i))){
                map.put(t.charAt(i),map.get(t.charAt(i))-1);
            }else{
                return false;
            }
        }
        for(Character c : map.keySet()){
            if(map.get(c)!=0)return false;
        }
        Stack<Integer> stack = new Stack<>();
        return true;
    }

    public static void main(String[] args) {
        Q242有效的字母异位词 solution = new Q242有效的字母异位词();
        String s = "anagram", t = "nagaram";
        System.out.println(solution.isAnagram(s,t));
        s = "rat"; t = "car";
        System.out.println(solution.isAnagram(s,t));
    }
}
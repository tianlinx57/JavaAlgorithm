// import java.util.HashMap;
// import java.util.Map;
// import java.util.Queue;
// import java.util.Stack;
//
// public class 有效的字母异位词242 {
//
//     public boolean isAnagram(String s, String t) {
//         Map<Character,Integer> map = new HashMap<>();
//         for(int i = 0 ; i < s.length(); i++){
//             if(map.containsKey(s.charAt(i))){
//                 map.put(s.charAt(i),map.get(s.charAt(i))+1);
//             }else{
//                 map.put(s.charAt(i),1);
//             }
//
//         }
//         for(int i = 0 ; i < t.length(); i++){
//             if(map.containsKey(t.charAt(i))){
//                 map.put(t.charAt(i),map.get(t.charAt(i))-1);
//             }else{
//                 return false;
//             }
//         }
//         for(Character c : map.keySet()){
//             if(map.get(c)!=0)return false;
//         }
//         Stack<Integer> stack = new Stack<>();
//         Queue
//         return true;
//     }
//
//     public static void main(String[] args) {
//         有效的字母异位词242 solution = new 有效的字母异位词242();
//         String s = "anagram", t = "nagaram";
//         System.out.println(solution.isAnagram(s,t));
//         s = "rat"; t = "car";
//         System.out.println(solution.isAnagram(s,t));
//     }
// }
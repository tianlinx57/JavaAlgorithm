import java.util.HashMap;
import java.util.Map;

class danci_pipei {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> patternMap = new HashMap<>();
//        Map<String, Character> wordMap = new HashMap<>();
        String[] words = s.split(" ");

        if (pattern.length() != words.length) {
            return false; // 如果 pattern 和 s 的单词数不匹配，直接返回 false
        }

        for(int i=0; i<pattern.length(); i++) {
            if(patternMap.containsKey(pattern.charAt(i))){
                if(!patternMap.get(pattern.charAt(i)).equals(words[i])){
                    return false;
                }
            }
            else {
                patternMap.put(pattern.charAt(i),words[i]);
            }
        }
        if (hasDuplicateValues(patternMap)){return false;}
        return true;
    }

    // 检查哈希表中是否有不一样的键对应一样的值
    private boolean hasDuplicateValues(Map<?, ?> map) {
        Map<Object, Integer> valueCount = new HashMap<>();
        for (Object value : map.values()) {
            valueCount.put(value, valueCount.getOrDefault(value, 0) + 1);
        }
        for (int count : valueCount.values()) {
            if (count > 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        danci_pipei solution = new danci_pipei();
        System.out.println(solution.wordPattern("abba", "dog cat cat dog")); // 输出 true
        System.out.println(solution.wordPattern("abba", "dog cat cat fish")); // 输出 false
        System.out.println(solution.wordPattern("aaaa", "dog cat cat dog")); // 输出 false
        System.out.println(solution.wordPattern("abba", "dog dog dog dog")); // 输出 false
    }
}

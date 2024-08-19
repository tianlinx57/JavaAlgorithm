package 自定义数据结构;

import java.util.HashMap;

//前缀树 子节点isEnd为true表示有这个字符串
class Trie {
    HashMap<Character,Trie> children;
    boolean isEnd;

    public Trie() {
        children = new HashMap<>();
        isEnd = false;
    }

    public void insert(String word) {
        if(word.isEmpty()){
            isEnd = true;
            return;
        }
        char c = word.charAt(0);
        if(children.containsKey(c)){
            children.get(c).insert(word.substring(1));
        } else {
            Trie child = new Trie();
            children.put(c,child);
            child.insert(word.substring(1));
        }
    }

    public boolean search(String word) {
        if (word.isEmpty()) return isEnd;
        char c = word.charAt(0);
        if(children.containsKey(c)){
            return children.get(c).search(word.substring(1));
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        if(prefix.isEmpty()){
            return true;
        }

        char c = prefix.charAt(0);
        if(children.containsKey(c)){
            return children.get(c).startsWith(prefix.substring(1));
        }
        return false;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.startsWith("app"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("apple"));
        System.out.println(trie.startsWith("applea"));
    }
}
import java.util.*;

public class DomainSet {
    private TrieNode root;

    // 构造方法
    public DomainSet(Set<String> domains) {
        root = new TrieNode();
        for (String domain : domains) {
            addDomain(domain);
        }
    }

    // 添加域名到前缀树中
    private void addDomain(String domain) {
        String[] parts = domain.split("\\.");
        TrieNode node = root;
        for (int i = parts.length - 1; i >= 0; i--) {
            node = node.getChildren().computeIfAbsent(parts[i], k -> new TrieNode());
        }
        node.setEndOfDomain(true);
    }

    // 判断域名是否存在于前缀树中或是某个已存在域名的子域名
    public boolean contains(String domain) {
        String[] parts = domain.split("\\.");
        TrieNode node = root;
        for (int i = parts.length - 1; i >= 0; i--) {
            node = node.getChildren().get(parts[i]);
            if (node == null) {
                return false;
            }
            if (node.isEndOfDomain()) {
                return true; // 找到了一个完整的域名
            }
        }
        return node.isEndOfDomain();
    }

    // 前缀树节点类
    private static class TrieNode {
        private final Map<String, TrieNode> children = new HashMap<>();
        private boolean endOfDomain;

        public Map<String, TrieNode> getChildren() {
            return children;
        }

        public boolean isEndOfDomain() {
            return endOfDomain;
        }

        public void setEndOfDomain(boolean endOfDomain) {
            this.endOfDomain = endOfDomain;
        }
    }
}

package TrieTree;
import java.util.*;


public class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    //API : insert
    public boolean insert(String target) {
        TrieNode cur = root;
        for (int i = 0; i < target.length(); i++) {
            TrieNode next = cur.children.get(target.charAt(i));
            if (next == null) {
                next = new TrieNode();
                cur.children.put(target.charAt(i), next);
            }
            cur = next;
        }
        cur.isWord = true;
        return true;
    }

    //API: findAllWithPrefix
    public List<String> findAllWithPrefix(String prefix) {
        List<String> res = new ArrayList<>();
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            TrieNode next = cur.children.get(prefix.charAt(i));
            if (next == null) return res;
            cur = next;
        }
        dfs(cur, new StringBuilder(), res);
        return res;
    }

    private void dfs(TrieNode root, StringBuilder sb, List<String> res) {
        if (root.isWord) res.add(sb.toString());
        for (Map.Entry<Character, TrieNode> child : root.children.entrySet()) {
            sb.append(child.getKey());
            dfs(child.getValue(), sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}


package TrieTree;
import java.util.*;

public class TrieNode {
    Map<Character, TrieNode> children;
    boolean isWord;
    public TrieNode () {
        children = new HashMap<>();
    }
}

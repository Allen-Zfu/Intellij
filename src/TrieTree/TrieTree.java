package TrieTree;
import java.util.*;

public class TrieTree {
    //define class node
    private class TrieNode {
        boolean isWord;
        Map<Character, TrieNode> children;
        List<String> startWith; // prefix words

        public TrieNode() {
            this.isWord = false;
            this.children = new HashMap<>();
            startWith = new ArrayList<>();
        }
    }

    //field + constructor
    private TrieNode root;
    public TrieTree() {
        this.root = new TrieNode();
    }

    // api
    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode next = cur.children.get(word.charAt(i));
            if (next == null) {
                next = new TrieNode();
                cur.children.put(word.charAt(i), next);
            }
            cur = next;
            cur.startWith.add(word);
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode next = cur.children.get(word.charAt(i));
            if (next == null) {
                return false;
            }
            cur = next;
        }
        return cur.isWord;
    }

    public void delete(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode next = cur.children.get(word.charAt(i));
            if (next == null) {
                // this word is not exist
                return;
            }
            cur = next;
            boolean boo = cur.startWith.remove(word);
            //System.out.println(boo);

        }
        // set isWord false
        cur.isWord = false;
    }

    //找到并重建所有start with特定preFix的words
    public List<String> wordsStartWithPrefix(String prefix) {
        //List<String> res = new ArrayList<>();
        // step 1: find the prefix
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            TrieNode next = cur.children.get(prefix.charAt(i));
            if (next == null) {
                return new ArrayList<>(); // prefix is not exist
            } else {
                cur = next;
            }
        }
        // step2: find all words with preFix using 'startWithWords'
        return cur.startWith;
    }
}





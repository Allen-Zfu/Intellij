package TrieTree;

public class TestTrie {

    public static void main(String[] args) {
        TrieTree trie = new TrieTree();
        trie.insert("add");
        trie.insert("append");

//        System.out.println(trie.wordsStartWithPrefix("a"));

//        trie.delete("add");
        System.out.println(trie.wordsStartWithPrefix("a"));
//        System.out.println(trie.wordsStartWithPrefix("ad"));
//        System.out.println(trie.wordsStartWithPrefix("add"));


    }
}

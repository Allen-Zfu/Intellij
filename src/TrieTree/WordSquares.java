package TrieTree;
import java.util.*;

public class WordSquares {
    public static void main(String[] args) {
        WordSquares ob = new WordSquares();
        String[] words = new String[]{"area","lead","wall","lady","ball"};
        List<List<String>> res = ob.wordSquares(words);
        System.out.println(res);
    }

    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<>();
        //sanity check
        if (words == null || words.length == 0) {
            return res;
        }
        int len = words.length;
        //build trie tree for input
        Trie trie = new Trie();
        for (String s : words) {
            trie.insert(s);
        }
        //DFS(backTracking) start from each word in input <=> unconnected
        //s --> init node in curPath (need recovery)
        List<String> curPath = new ArrayList<>(); //words used in curPath, also can be used as mark visited
        for (String s : words) {
            curPath.add(s);
            backTracking(s, trie, curPath, res);
            curPath.remove(curPath.size() - 1);
        }
        return res;

    }

    private void backTracking(String initS, Trie trie, List<String> curPath, List<List<String>> res) {
        int index = curPath.size() - 1;
        //base case
        if (index == initS.length()) {
            res.add(new ArrayList<String>(curPath));
            return;
        }
        //add cur vertex influence to curPath

        //prefix at cur layer : all word 'index' position character in curPath
        StringBuilder prefix = new StringBuilder();
        for (String s : curPath) {
            prefix.append(s.charAt(index + 1));
        }

        //travers all branch, find valid branches at cur layer: (need two conditions)
        //a) all words associated with prefix(find in trie)
        //b) && never used before in curPath (check curPath list)
        List<String> candidates = trie.findAllWithPrefix(prefix.toString()); //all valid branches candidate
        for (String s : candidates) {
            if (!curPath.contains(s)) {
                curPath.add(s);
                backTracking(s, trie, curPath, res);
                curPath.remove(curPath.size() - 1); //recovery
            }
        }
    }
}




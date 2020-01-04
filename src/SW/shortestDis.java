package SW;

public class shortestDis {
    public static int shortestDistance(String[] words, String word1, String word2) {
        int glbShortest = Integer.MAX_VALUE;

        //NFS-SW shortest type
        int slow = 0;
        boolean first = true;
        for (int fast = 0; fast < words.length; fast++) {
            //add fast
            if (!words[fast].equals(word1) && ! words[fast].equals(word2)) {
                continue;
            }
            if (first) {
                first = false;
                continue;
            }
            //remove slow
            while ((!words[slow].equals(word1) && !words[slow].equals(word2))) {
                //move slow
                slow++;
            }
            //update glb
            if (!words[slow].equals(words[fast])) {
                glbShortest = Math.min(glbShortest, fast - slow);
            }
            slow++;
        }
        return glbShortest;
    }

    public static void main(String[] args) {
        String[] str = {"a","c","a","b"};
        System.out.println(shortestDis.shortestDistance(str, "a", "b"));

    }
}

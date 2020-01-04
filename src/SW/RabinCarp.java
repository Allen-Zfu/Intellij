package SW;

public class RabinCarp {
    public int strstr(String large, String small) {
        int k = small.length();
        for (int fast = k - 1; fast < large.length(); fast++) {
            if (isSame(large.substring(fast - k + 1, fast + 1), small)) {
                return fast - k + 1;
            }
        }
        return -1;
    }

    private boolean isSame(String largeSub, String small) {
        for (int i = 0; i < small.length(); i++) {
            if (largeSub.charAt(i) != small.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        RabinCarp ob = new RabinCarp();
        String large = "aabbaabbaabbccaabbaabbaabbaabbcc";
        String small = "aabbaabbaabbaabbcc";
        int res = ob.strstr(large, small);
        System.out.println(res);
    }
}



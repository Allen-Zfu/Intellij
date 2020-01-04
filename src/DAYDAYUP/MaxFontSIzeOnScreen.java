package DAYDAYUP;

public class MaxFontSIzeOnScreen {
    private int paperHeight;
    private int paperWidth;

    public int getHeight(int fontSize) {
        return 1;
    }

    public int getWidth(char c, int fontSize) {
        return 1;
    }

    //BSA找最大可用的fontSize
    public int fontSize(String word) {
        int left = 1;
        int right = 1000;
        int res = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isOut(mid, word)) {
                right = mid - 1;
            } else {
                left = mid + 1;
                res = mid;
            }
        }
        return res;
    }

    //根据paperWidth，计算当前fontSize打印whole String需要所少行
    public int getRow(int fontSize, String word) {
        //sanity check
        if (word == null || word.length() == 0) {
            return 0;
        }
        int row = 0;
        for (int i = 0; i < word.length(); ) {
            int w = getWidth(word.charAt(i), fontSize);
            while (i + 1 < word.length() && paperWidth < w +
                    getWidth(word.charAt(i + 1), fontSize)) {
                w += getWidth(word.charAt(i + 1), fontSize);
                ++i;
            }
            if (w > 0) {
                row++;
            }
        }
        return row;
    }

    //根据getRow计算出的需要的行数，
    //计算使用当前fontSize打印whole string所用的总高度是否会超过屏幕总高度
    public boolean isOut(int fontSize, String word) {
        int height = getHeight(fontSize);
        int row = getRow(fontSize, word);
        return (row * height) > paperHeight;
    }
}






package array;
public class OutOfBoundsChecking {

    /**
     array有效的index范围:     [0, array.length - 1]
     */

    public static void main(String[] args) {
        /** 一个指针，不移动，遍历一维数组  */
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < array.length; i++) {
            System.out.println("array is：" + array[i]);
        }
        /** 一个指针，移动，遍历一维数组  */
        int[] dupArray = new int[]{4, 5, 5, 5, 5, 6, 7, 8, 9};
        for (int i = 0; i < array.length; i++) {
            while (i + 1 < array.length && array[i] == array[i + 1]) {
                i++;    //skip the dup
            }
            System.out.println("dupArray1 is: " + dupArray[i]);
        }
        for (int i = 0; i < array.length; i++) {
            while (i - 1 >= 0 && array[i] == array[i - 1]) {
                i++;
            }
            System.out.println("dupArray2 is: " + dupArray[i]);
        }
//        for (int i = 0; i < array.length; i++) {
//            while (i + 3 < array.length && array[i] == array[i + 3]) {
//                i++;
//            }
//            System.out.println("dupArray3 is: " + dupArray[i]);
//        }
//        for (int i = 0; i < array.length; i++) {
//            while (i - 3 >= 0 && array[i] == array[i - 3]) {
//                i++;
//            }
//            System.out.println("dupArray4 is: " + dupArray[i]);
//        }

        /** 两个指针，不移动，col > row 遍历一维数组
         * -> 效果：打印二维矩阵右上对角线,j >= i, 对角线开始i=0,j=i开始填表  */
        int[] arrayTP = new int[]{1, 2, 3, 4}; //array wth two pointer
        int[][] matrix = new int[4][4];
        for (int i = 0; i < arrayTP.length; i++) {
            for (int j = i; j < arrayTP.length; j++) {
                System.out.println("array1 is：" + arrayTP[j]);
                matrix[i][j] = arrayTP[j];
            }
        }
        //print matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.println(matrix[i][j]);
            }
        }
        /**
         * 打印结果：右上斜对角线
         *        1  2  3  4
         *        0  2  3  4
         *        0  0  3  4
         *        0  0  0  4
         */

        /** 两个指针，不移动，col < row 遍历一维数组
         *  -> 效果：打印二维矩阵左下对角线,j <= 1, leftTop i=0,j=0开始填表 */
        int[][] matrix1 = new int[4][4];
        for (int i = 0; i < arrayTP.length; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.println("array1 is：" + arrayTP[j]);
                matrix1[i][j] = arrayTP[j];
            }
        }
        //print matrix1
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                System.out.println(matrix1[i][j]);
            }
        }
        /**
         * 打印结果：左下斜对角线
         *        1  0  0  0
         *        1  2  0  0
         *        1  2  3  0
         *        1  2  3  4
         */

        /** 两个指针，不移动，col < row 遍历一维数组
         *  -> 效果：打印二维矩阵左上对角线 ，rightTop i=0， j=matrix[0].length - 1开始填表*/
        int[][] matrix3 = new int[4][4];
        for (int i = 0; i < matrix3.length; i++) {
            for (int j = 0; j <= matrix.length - i; j++) {
                System.out.println("array1 is：" + arrayTP[j]);
                matrix1[i][j] = arrayTP[j];
            }
        }
        //print matrix
        for (int i = 0; i < matrix3.length; i++) {
            for (int j = 0; j < matrix3[0].length; j++) {
                System.out.println(matrix3[i][j]);
            }
        }
        /**
         * 打印结果：左上斜对角线
         *        1  2  3  4
         *        1  2  3  0
         *        1  2  0  0
         *        1  0  0  0
         */
    }
}

/**while循环写法：
 * 假设：区间 one , 区间 two (one&two是需要被比较的区间，可以是同一个DS中的两个区间，也可以是两个独立的DS)
 *
 * 1.两个指针同向而行/谁小移谁/谁大移谁，都从左往右遍历
 * int i = one第一个valid idx;    //i用来遍历one
 * int j = two第一个valid idx;    //j用来遍历two
 * int cur = 被抄写DS中第一个valid idx（如果是新的DS,需要新的pointer遍历，如果in-place，可能可以直接使用原array pointer）
 * while (i <= one最后一个valid idx && j <= two最后一个valid idx) {
 *     if.....
 * }
 * //post-processing
 * 根据从左往右/从右往左顺序，决定one/two的两边有哪一段或者哪几段元素在while之外可能没抄完，单独抄写
 *
 * 2.两个指针相向而行
 * one:需要被遍历的区间，本质操作与BS是相同的
 * int l = one第一个valid idx
 * int r = one中最后一个valid idx
 * while (与BS操作类似） {
 *
 * }
 * //post-processing(与BS操作类似)
 *
 *
 */



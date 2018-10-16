package day1016;

import java.util.Arrays;

/**
 * @author zkr123
 * @version 1.0
 * @ClassName Solution
 * @Description
 * @date 2018/10/16 9:13
 */
public class Solution {
    /*给定一个 n × n 的二维矩阵表示一个图像。
    将图像顺时针旋转 90 度。

    说明：
    你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。

    示例 1:
    给定 matrix =
        [
        [1,2,3],
        [4,5,6],
        [7,8,9]
        ],

    原地旋转输入矩阵，使其变为:
            [
            [7,4,1],
            [8,5,2],
            [9,6,3]
            ]
    示例 2:

    给定 matrix =
        [
        [ 5, 1, 9,11],
        [ 2, 4, 8,10],
        [13, 3, 6, 7],
        [15,14,12,16]
        ],

    原地旋转输入矩阵，使其变为:
            [
            [15,13, 2, 5],
            [14, 3, 4, 1],
            [12, 6, 8, 9],
            [16, 7,10,11]
            ]*/
    public void rotate(int[][] matrix) {
        // 1,3轴对称 + x轴对称
        int param = 0;
        int matrixLength = matrix.length;
        for (int x = 0; x < matrixLength; x++) {
            for (int y = 0; y < matrixLength; y++) {
                if (x + y < matrixLength - 1) {
                    param = matrix[x][y];
                    matrix[x][y] = matrix[matrixLength - 1 - y][matrixLength - 1 - x];
                    matrix[matrixLength - 1 - y][matrixLength - 1 - x] = param;
                }
            }
        }
        for (int x = 0; x < matrixLength / 2; x++) {
            for (int y = 0; y < matrixLength; y++) {
                param = matrix[x][y];
                matrix[x][y] = matrix[matrixLength - 1 - x][y];
                matrix[matrixLength - 1 - x][y] = param;
            }
        }
    }


    /*编写一个函数，其作用是将输入的字符串反转过来。

    示例 1:
    输入: "hello"
    输出: "olleh"

    示例 2:
    输入: "A man, a plan, a canal: Panama"
    输出: "amanaP :lanac a ,nalp a ,nam A"*/
    public String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public String reverseString2(String s) {
        char[] chars = s.toCharArray();
        char param;
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - 1 -i]) {
                param = chars[i];
                chars[i] = chars[chars.length - 1 -i];
                chars[chars.length - 1 -i] = param;
            }
        }
        return new String(chars);
    }


    /*给定一个 32 位有符号整数，将整数中的数字进行反转。

    示例 1:

    输入: 123
    输出: 321
    示例 2:

    输入: -123
    输出: -321
    示例 3:

    输入: 120
    输出: 21
    注意:

    假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0*/
    public int reverse (int x) {
        char[] chars = (x + "").toCharArray();
        char param;
        int zeroCount = 0;
        boolean zeroCountFlag = true;
        int i = chars[0] == '-' ? 1 : 0;
        int j = chars.length - 1;
        int k = i;
        while (j > k) {
            if (chars[j] == '0' && zeroCountFlag) {
                zeroCount ++;
                j--;
                continue;
            }
            zeroCountFlag = false;

            if (chars[k] != chars[j]) {
                param = chars[k];
                chars[k] = chars[j];
                chars[j] = param;
            }
            k++;
            j--;
        }
        String s = new String(chars).substring(0, chars.length - zeroCount);
        if (zeroCount != 0){
            return Integer.parseInt(s);
        }
        if (i == 0 && s.length() == 10) {
            int ra = Integer.parseInt(s.substring(0, s.length() - 1));
            if (ra > Integer.MAX_VALUE / 10){
                return 0;
            } else if (ra < Integer.MAX_VALUE / 10 || chars[chars.length - 1] < '7') {
                return Integer.parseInt(s);
            } else {
                return 0;
            }
        }
        if (i == 1 && s.length() == 11){
            int ra = Integer.parseInt(s.substring(0, s.length() - 1));
            if (ra < -Integer.MAX_VALUE / 10){
                return 0;
            } else if (ra > -Integer.MAX_VALUE / 10 || chars[chars.length - 1] < '7') {
                return Integer.parseInt(s);
            } else {
                return 0;
            }
        }
        return Integer.parseInt(s);
    }

    public int reverse2 (int x) {
        if (x < 10 && x > -10) {
            return x;
        }
        if (x == -Integer.MAX_VALUE - 1) {
            return 0;
        }
        int y = Math.abs(x);
        int result = 0;
        String s = new StringBuilder(y + "").reverse().toString();
        if (s.length() < 10) {
            result = x < 0 ? -Integer.parseInt(s) : Integer.parseInt(s);
            return result;
        }
        int la = Integer.parseInt(s.substring(0, s.length() - 1));
        if (la > Integer.MAX_VALUE / 10) {
            return 0;
        } else if (s.charAt(s.length() - 1) > '7') {
            return 0;
        } else {
            result = x < 0 ? -Integer.parseInt(s) : Integer.parseInt(s);
            return result;
        }
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        //int[][] matrix = {
        //    {1,2,3},
        //    {4,5,6},
        //    {7,8,9}
        //};
        //for (int[] ints : matrix) {
        //    System.out.println(Arrays.toString(ints));
        //}
        //System.out.println();
        //so.rotate(matrix);
        //for (int[] ints : matrix) {
        //    System.out.println(Arrays.toString(ints));
        //}

        //String s = "hello";
        //System.out.println("so.reverseString2(s): " + so.reverseString2(s));
        int y = 123;
        System.out.println(so.reverse2(y));



    }
}

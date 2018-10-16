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

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] matrix = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println();
        s.rotate(matrix);
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }

    }
}

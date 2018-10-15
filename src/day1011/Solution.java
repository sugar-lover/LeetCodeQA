package day1011;

import java.util.Arrays;

/**
 * @author zkr123
 * @version 1.0
 * @ClassName Solution
 * @Description
 * @date 2018/10/11 10:13
 */
public class Solution {
    /*给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

    示例 1:
    输入: [1,2,3,4,5,6,7] 和 k = 3
    输出: [5,6,7,1,2,3,4]
    解释:
    向右旋转 1 步: [7,1,2,3,4,5,6]
    向右旋转 2 步: [6,7,1,2,3,4,5]
    向右旋转 3 步: [5,6,7,1,2,3,4]

    示例 2:
    输入: [-1,-100,3,99] 和 k = 2
    输出: [3,99,-1,-100]
    解释:
    向右旋转 1 步: [99,-1,-100,3]
    向右旋转 2 步: [3,99,-1,-100]
    说明:

    尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
    要求使用空间复杂度为 O(1) 的原地算法。*/
    /**
     * @Description:
     * @auther: zkr123
     * @date: 10:16 2018/10/11
     * @param: [nums, k]
     * @return: void
     *
     */
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0) {
            return;
        }
        swapArrays(nums, 0, nums.length - 1);
        swapArrays(nums, 0, k - 1);
        swapArrays(nums,  k, nums.length - 1);

    }

    /**
     * @Description: 交换数组
     * @auther: zkr123
     * @date: 9:26 2018/10/15
     * @param: [nums, startIndex, endIndex] {数组，起始坐标}
     * @return: void
     *
     */
    public void swapArrays (int[] nums, int startIndex, int endIndex) {
        while (true) {
            if (startIndex >= endIndex) {
                break;
            }
            nums[startIndex] = nums[startIndex] ^ nums[endIndex];
            nums[endIndex] = nums[startIndex] ^ nums[endIndex];
            nums[startIndex] = nums[startIndex] ^ nums[endIndex];
            startIndex ++;
            endIndex --;
        }
    }

    public void rotate2(int[] nums, int k) {
        for (int j = 0; j < k; j++) {
            int length = nums.length;
            int finalVal = nums[length - 1];
            for (int i = nums.length - 2; i >= 0; i--) {
                nums[i+1] = nums[i];
                System.out.println(Arrays.toString(nums));
            }
            nums[0] = finalVal;
            System.out.println(Arrays.toString(nums));
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3,4,5,6};
        int k = 4;
        solution.rotate2(nums , k);
        System.out.println(Arrays.toString(nums));
    }
}

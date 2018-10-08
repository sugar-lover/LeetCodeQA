package day1008;

import java.util.Arrays;

public class Solution {

    public int removeDuplicates (int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            return length;
        }
        int resultLength = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != nums[resultLength]) {
                resultLength ++;
                if (i != resultLength) {
                    nums[resultLength] = nums[i];
                }
            }
        }
        return resultLength + 1 ;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {1, 1, 2, 2, 3, 4, 5, 6};
        long start = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            solution.removeDuplicates(nums);
            nums = new int[]{1, 1, 2, 2, 3, 4, 5, 6};
        }
        System.out.println((System.nanoTime() - start) / 100);

    }

}

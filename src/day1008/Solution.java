package day1008;

import java.util.Arrays;
/**
 * @author zkr123
 * @version 1.0
 * @ClassName ListNode
 * @Description
 * @date 2018/10/9 15:06
 */
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
        return resultLength + 1;
    }

    public int removeDuplicates2 (int[] nums) {
        int len = nums.length;
        if(len==0){
            return 0;
        }
        int max = nums[len-1]+1;
        int num = 0;
        for(int i=0;i<len;i++){
            if(i==(len-1)){
                continue;
            }
            if(nums[i]==nums[i+1]){
                nums[i]=max;
                num++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                int x = nums[j];
            }
        }
        return len-num;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int loopCount = 100;
        int[] nums = {1, 1, 2, 2, 3, 4, 5, 6};
        long start = System.nanoTime();
        for (int i = 0; i < loopCount; i++) {
            solution.removeDuplicates2(nums);
            nums = new int[]{1, 1, 2, 2, 3, 4, 5, 6};
        }
        System.out.println((System.nanoTime() - start) / loopCount);

    }

}

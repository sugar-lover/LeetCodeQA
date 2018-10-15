package day1015;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zkr123
 * @version 1.0
 * @ClassName Solution
 * @Description
 * @date 2018/10/15 10:34
 */
public class Solution {
    /*给定一个整数数组，判断是否存在重复元素。
    如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false*/
    public boolean contaionsDulplicate (int[] nums) {
        Set set= new HashSet<Integer>();
        for (Integer i : nums) {
            if (!set.add(i)) {
                return true;
            }
        }
        return false;
    }

    public boolean contaionsDulplicate2 (int[] nums) {
        if (nums.length <= 1) {
            return  false;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]){
                return  true;
            }
        }
        return false;
    }

    /*给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
    说明：
    你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？*/
    public int singleNumber(int[] nums) {
        if (nums.length <= 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 1 && nums[i] != nums[i - 1]) {
                return nums[i - 1];
            }
        }
        return nums[nums.length - 1];
    }

    public int singleNumber2(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

    /*给定两个数组，编写一个函数来计算它们的交集。

    示例 1:
    输入: nums1 = [1,2,2,1], nums2 = [2,2]
    输出: [2,2]

    示例 2:
    输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    输出: [4,9]

    说明：
    输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
    我们可以不考虑输出结果的顺序。

    进阶:
    如果给定的数组已经排好序呢？你将如何优化你的算法？
    如果 nums1 的大小比 nums2 小很多，哪种方法更优？
    如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？*/
    public int[] intersect(int[] nums1, int[] nums2) {
        
        return  nums1;
    }


}

package day1015;

import java.lang.reflect.Array;
import java.util.*;

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
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums1.length; i++) {
            int count = map.get(nums1[i]) == null ? 0 : map.get(nums1[i]);
            int countw = count + 1;

            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == nums1[i]) {
                    if (count != 0) {
                        count --;
                    } else {
                        map.put(Integer.valueOf(nums1[i]), Integer.valueOf(countw) );
                        break;
                    }
                }
            }
        }
        List<Integer> list = new LinkedList<Integer>();
        Set<Integer> ss = map.keySet();
        if (ss.size() == 0) {
            return new int[]{};
        }
        for (Integer integer : ss) {
            int l = map.get(integer);
            System.out.println(l);
            for (Integer i = 0; i < l; i++) {
                list.add(integer);
            }
        }
        int[] s = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            s[i] = list.get(i);
        }
        return  s;
    }

    public int[] intersect2(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0 ) {
            return new int[]{};
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        List<Integer> list = new LinkedList<Integer>();
        while (true) {
            if (i == nums1.length || j == nums2.length) {
                break;
            }
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
                continue;
            }
            if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        if (list.size() == 0) {
            return new int[]{};
        }
        int[] result = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            result[k] = list.get(k);
        }
        return result;
    }

    /*给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
    最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
    你可以假设除了整数 0 之外，这个整数不会以零开头。

    示例 1:
    输入: [1,2,3]
    输出: [1,2,4]
    解释: 输入数组表示数字 123。

    示例 2:
    输入: [4,3,2,1]
    输出: [4,3,2,2]
    解释: 输入数组表示数字 4321。*/
    public int[] plusOne(int[] digits) {
        int index = digits.length - 1;
        while (index != -1) {
            if (digits[index] != 9) {
                digits[index]++;
                return digits;
            } else {
                digits[index] = 0;
                index--;
            }
        }
        if (index == -1) {
            digits = Arrays.copyOf(digits,digits.length + 1);
            digits[0] = 1;
        }
        return digits;
    }


    /*给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

    示例:
    输入: [0,1,0,3,12]
    输出: [1,3,12,0,0]

    说明:
    必须在原数组上操作，不能拷贝额外的数组。
    尽量减少操作次数。*/
    public void moveZeroes(int[] nums) {
        int zeroLength = 0;
        int zeroFirstindex = 0;
        while (zeroFirstindex + zeroLength != nums.length) {
            if (nums[zeroFirstindex + zeroLength] == 0) {
                zeroLength++;
                continue;
            }
            if (zeroLength != 0) {
                nums[zeroFirstindex] = nums[zeroFirstindex + zeroLength];
                nums[zeroFirstindex + zeroLength] = 0;
            }
            zeroFirstindex ++;
        }
    }

    /*给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
    你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。

    示例:
    给定 nums = [2, 7, 11, 15], target = 9

    因为 nums[0] + nums[1] = 2 + 7 = 9
    所以返回 [0, 1]*/
    public int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])){
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    /*判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。

    数字 1-9 在每一行只能出现一次。
    数字 1-9 在每一列只能出现一次。
    数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
    数独部分空格内已填入了数字，空白格用 '.' 表示。

    示例 1:

    输入:
            [
            ["5","3",".",".","7",".",".",".","."],
            ["6",".",".","1","9","5",".",".","."],
            [".","9","8",".",".",".",".","6","."],
            ["8",".",".",".","6",".",".",".","3"],
            ["4",".",".","8",".","3",".",".","1"],
            ["7",".",".",".","2",".",".",".","6"],
            [".","6",".",".",".",".","2","8","."],
            [".",".",".","4","1","9",".",".","5"],
            [".",".",".",".","8",".",".","7","9"]
            ]
    输出: true
    示例 2:

    输入:
            [
            ["8","3",".",".","7",".",".",".","."],
            ["6",".",".","1","9","5",".",".","."],
            [".","9","8",".",".",".",".","6","."],
            ["8",".",".",".","6",".",".",".","3"],
            ["4",".",".","8",".","3",".",".","1"],
            ["7",".",".",".","2",".",".",".","6"],
            [".","6",".",".",".",".","2","8","."],
            [".",".",".","4","1","9",".",".","5"],
            [".",".",".",".","8",".",".","7","9"]
            ]
    输出: false
    解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
    但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
    说明:

    一个有效的数独（部分已被填充）不一定是可解的。
    只需要根据以上规则，验证已经填入的数字是否有效即可。
    给定数独序列只包含数字 1-9 和字符 '.' 。
    给定数独永远是 9x9 形式的。*/
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<Character>();
        Set<Character> set2 = new HashSet<Character>();
        Set<Character> set3 = new HashSet<Character>();
        int cij = 0;
        while (cij < 9){
            for (int i = 0; i < 9; i++) {
                if (!".".equals(board[cij][i]) && !set.add(board[cij][i])) {
                    return false;
                }
                if (!".".equals(board[i][cij]) && !set2.add(board[i][cij])) {
                    return false;
                }
                if (!isSudoku(board, cij, i, set3) || !isSudoku(board, i, cij, set3)) {
                    return false;
                }
            }
            set.clear();
            set2.clear();
            cij ++;
        }
        return true;
    }

    public boolean isSudoku(char[][] board, int i, int j, Set<Character> set) {
        set.clear();
        if (i % 3 == 1 && j % 3 == 1) {
            for (int k = 0; k < 3; k++) {
                for (int l = 0; l < 3; l++) {
                    if (!".".equals(board[i - 1 + k][j - 1 + l]) && !set.add(board[i - 1 + k][j - 1 + l])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2};
        int[] digits = {9,9,9};
        int[] nums = {};
        String[][] board= new String[][]{
                {"8","3",".",".","7",".",".",".","."},
                {"6",".",".","1","9","5",".",".","."},
                {".","9","8",".",".",".",".","6","."},
                {"8",".",".",".","6",".",".",".","3"},
                {"4",".",".","8",".","3",".",".","1"},
                {"7",".",".",".","2",".",".",".","6"},
                {".","6",".",".",".",".","2","8","."},
                {".",".",".","4","1","9",".",".","5"},
                {".",".",".",".","8",".",".","7","9"}
        };

        //System.out.println(Arrays.toString(s.intersect2(nums1, nums2)));
        //System.out.println(Arrays.toString(s.plusOne(digits)));
        //s.moveZeroes(nums);
        //System.out.println(Arrays.toString(s.twoSum(nums, 6)));
        System.out.println(s.isValidSudoku(board));
    }
}

package day1026;

/**
 * @author zkr123
 * @version 1.0
 * @ClassName Solution
 * @Description
 * @date 2018/10/26 10:02
 */
public class Solution {

    /*编写一个函数来查找字符串数组中的最长公共前缀。
    如果不存在公共前缀，返回空字符串 ""。

    示例 1:
    输入: ["flower","flow","flight"]
    输出: "fl"

    示例 2:
    输入: ["dog","racecar","car"]
    输出: ""
    解释: 输入不存在公共前缀。

    说明:
    所有输入只包含小写字母 a-z 。*/
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length <= 1) {
            if (strs.length == 1) {
                return strs[0];
            }
            return "";
        }
        int index = strs[0].length() - 1;
        if (index == -1) {
            return "";
        }
        for (int i = 1; i < strs.length; i++) {
            for (int j = 0; j < index + 1 && j < strs[i].length(); j++) {
                if (strs[0].charAt(j) != strs[i].charAt(j)) {
                    index = index <= j - 1 ? index : j - 1;
                }
            }
            if (index + 1 >= strs[i].length()) {
                index = strs[i].length() - 1;
            }
            if (index == -1) {
                return "";
            }
        }
        return strs[0].substring(0, index + 1);
    }


    /*请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
    现有一个链表 -- head = [4,5,1,9]，它可以表示为:
            4 -> 5 -> 1 -> 9
    示例 1:
    输入: head = [4,5,1,9], node = 5
    输出: [4,1,9]
    解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
    示例 2:
    输入: head = [4,5,1,9], node = 1
    输出: [4,5,9]
    解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
    说明:
    链表至少包含两个节点。
    链表中所有节点的值都是唯一的。
    给定的节点为非末尾节点并且一定是链表中的一个有效节点。
    不要从你的函数中返回任何结果。*/

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = new String[]{"cc","c"};
        System.out.println(solution.longestCommonPrefix(strs));
    }
}

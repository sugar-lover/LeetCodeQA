package day1025;

/**
 * @author zkr123
 * @version 1.0
 * @ClassName Solution
 * @Description
 * @date 2018/10/25 15:07
 */
public class Solution {
    /*实现 strStr() 函数。
    给定一个 haystack 字符串和一个 needle 字符串，
    在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

    示例 1:
    输入: haystack = "hello", needle = "ll"
    输出: 2

    示例 2:
    输入: haystack = "aaaaa", needle = "bba"
    输出: -1

    说明:
    当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
    对于本题而言，当 needle 是空字符串时我们应当返回 0 。
    这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。*/
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;
        }
        if ("".equals(needle)) {
            return 0;
        }
        char[] haystackChars = haystack.toCharArray();
        char[] needleChars = needle.toCharArray();
        for (int i = 0; i < haystackChars.length; i++) {
            if (haystackChars.length - i < needleChars.length) {
                break;
            }
            if (haystackChars[i] == needleChars[0]) {
                boolean flag = false;
                for (int j = 0; j < needleChars.length; j++) {
                    if (i + j < haystackChars.length && haystackChars[i + j] != needleChars[j]) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    return i;
                }
            }
        }
        return -1;
    }


    /*报数
    报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
            1.     1
            2.     11
            3.     21
            4.     1211
            5.     111221
            1 被读作  "one 1"  ("一个一") , 即 11。
            11 被读作 "two 1s" ("两个一"）, 即 21。
            21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
    给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
    注意：整数顺序将表示为一个字符串。

    示例 1:

    输入: 1
    输出: "1"
    示例 2:

    输入: 4
    输出: "1211"*/

    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder("1");
        return countAndSay(n - 1, sb);
    }

    public String countAndSay(int n, StringBuilder sb) {
        if (n == 0) {
            return sb.toString();
        }
        char[] sChars = sb.toString().toCharArray();
        int i = 0;
        int count = 1;
        char value = '0';
        sb = new StringBuilder("");
        count = 1;
        while (i < sChars.length) {
            value = sChars[i];
            if (i + 1 < sChars.length && sChars[i] == sChars[i + 1]) {
                count ++;
                i++;
            } else {
                sb.append(count).append(value);
                count = 1;
                i++;
            }
            System.out.println(sb.toString());
        }
        return countAndSay(n - 1, sb);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String haystack = "ooppllkkii";
        String needle = "op";
        //System.out.println(solution.strStr(haystack, needle));

        System.out.println(solution.countAndSay(3));
    }
}

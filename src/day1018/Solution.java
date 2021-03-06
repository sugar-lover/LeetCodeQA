package day1018;

/**
 * @author zkr123
 * @version 1.0
 * @ClassName Solution
 * @Description
 * @date 2018/10/18 10:43
 */
public class Solution {
    /*给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

    说明：本题中，我们将空字符串定义为有效的回文串。

    示例 1:

    输入: "A man, a plan, a canal: Panama"
    输出: true
    示例 2:

    输入: "race a car"
    输出: false*/
    public boolean isPalindrome(String s) {
        char[] sChar = s.toLowerCase().toCharArray();
        int i = 0;
        int j = sChar.length - 1;
        while (i < j) {
            if (!((sChar[i] >= '0' && sChar[i] <= '9') || (sChar[i] >= 'a' && sChar[i] <= 'z'))) {
                i++;
                continue;
            }
            if (!((sChar[j] >= '0' && sChar[j] <= '9') || (sChar[j] >= 'a' && sChar[j] <= 'z'))) {
                j--;
                continue;
            }
            if (sChar[i] != sChar[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /*实现 atoi，将字符串转为整数。
    该函数首先根据需要丢弃任意多的空格字符，直到找到第一个非空格字符为止。
    如果第一个非空字符是正号或负号，选取该符号，并将其与后面尽可能多的连续的数字组合起来，这部分字符即为整数的值。
    如果第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
    字符串可以在形成整数的字符后面包括多余的字符，这些字符可以被忽略，它们对于函数没有影响。
    当字符串中的第一个非空字符序列不是个有效的整数；或字符串为空；或字符串仅包含空白字符时，则不进行转换。
    若函数不能执行有效的转换，返回 0。
    说明：
    假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。
    如果数值超过可表示的范围，则返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
    示例 1:
    输入: "42"
    输出: 42

    示例 2:
    输入: "   -42"
    输出: -42
    解释: 第一个非空白字符为 '-', 它是一个负号。
    我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。

    示例 3:
    输入: "4193 with words"
    输出: 4193
    解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。

    示例 4:
    输入: "words and 987"
    输出: 0
    解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
    因此无法执行有效的转换。

    示例 5:
    输入: "-91283472332"
    输出: -2147483648
    解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
    因此返回 INT_MIN (−231) 。*/
    public int myAtoi(String str) {
        if (str == null || "".equals(str.trim())) {
            return 0;
        }
        int startIndex = -1;
        int endIndex = -1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                continue;
            }
            if (startIndex == -1 && (str.charAt(i) == '-' || str.charAt(i) == '+' || (str.charAt(i) >= '0' && str.charAt(i) <= '9'))) {
                startIndex = i;
                endIndex = i;
                continue;
            }
            if (startIndex == -1 && !(str.charAt(i) == '-' || str.charAt(i) == '+' || (str.charAt(i) >= '0' && str.charAt(i) <= '9'))) {
                return 0;
            }
            if (endIndex == i - 1 && (str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
                endIndex = i;
            }
            if (endIndex != -1 && endIndex != i) {
                break;
            }
        }

        String s = str.substring(startIndex, endIndex + 1);
        s = s.startsWith("-") || s.startsWith("+") ? s : "+" + s;
        while (s.length() > 1 && s.charAt(1) == '0') {
            s = s.replaceFirst("0", "");
        }
        if (s.length() == 1) {
            return 0;
        }
        if (s.length() < 11) {
            return Integer.parseInt(s);

        }
        if (s.length() > 11) {
            int res = s.startsWith("-") ? Integer.MAX_VALUE + 1 : Integer.MAX_VALUE;
            return res;
        }
        if (s.length() == 11) {
            int p = Integer.parseInt(s.substring(0, s.length() - 1));
            int p1 = Math.abs(p);
            if (p1 < Integer.MAX_VALUE / 10) {
                return Integer.parseInt(s);
            } else if (p1 > Integer.MAX_VALUE / 10) {
                int res = s.startsWith("-") ? Integer.MAX_VALUE + 1 : Integer.MAX_VALUE;
                return res;
            } else {
                int last = p > 0 ? '7' : '8';
                if (s.charAt(s.length() - 1) <= last) {
                    return Integer.parseInt(s);
                } else {
                    int res = s.startsWith("-") ? Integer.MAX_VALUE + 1 : Integer.MAX_VALUE;
                    // return
                    return res;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        //String s = "A man, a plan, a canal: P danama";
        //System.out.println(solution.isPalindrome(s));

        String s = "2147483648";
        System.out.println(solution.myAtoi(s));


    }
}

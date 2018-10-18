package day1017;

import java.util.Arrays;

/**
 * @author zkr123
 * @version 1.0
 * @ClassName Solution
 * @Description
 * @date 2018/10/17 9:27
 */
public class Solution {
    /*给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
    案例:
    s = "leetcode"
    返回 0.
    s = "loveleetcode",
    返回 2.
    注意事项：您可以假定该字符串只包含小写字母。*/
    public int firstUniqChar(String s) {
        if (s.length() == 1) {
            return 0;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars.length; j++) {
                if (chars[i] == chars[j] && j != i) {
                    break;
                }
                if (j == chars.length - 1) {
                    return i;
                }
                if (j == i) {
                    continue;
                }
            }
        }
        return -1;
    }

    public int firstUniqChar2(String s) {
        int index = -1;
        for (int i = 'a'; i <= 'z'; i++) {
            int firstIndex = s.indexOf(i);
            int lastIndex = s.lastIndexOf(i);
            if (firstIndex != -1 && firstIndex == lastIndex) {
                index = index == -1 ? firstIndex : Math.min(index, firstIndex);
            }
        }
        return index;
    }


    /*给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。

    示例 1:
    输入: s = "anagram", t = "nagaram"
    输出: true
    示例 2:
    输入: s = "rat", t = "car"
    输出: false
    说明:
    你可以假设字符串只包含小写字母。
    进阶:
    如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？*/
    public boolean isAnagram(String s, String t) {
        while (s.length() > 0 && t.length() > 0) {
            if (s.length() != t.length()) {
                return false;
            }
            t = t.replaceAll(s.charAt(0) + "", "");
            s = s.replaceAll(s.charAt(0) + "", "");
            System.out.println("s: " + s);
            System.out.println("t: " + t);
        }
        if (s.length() == 0 && t.length() == 0) {
            return true;
        }
        return false;
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() == t.length()) {
            int[] sCount = new int[26];
            int[] tCount = new int[26];
            for (int i = 0; i < s.length(); i++) {
                sCount[s.charAt(i) - 'a']++;
                tCount[t.charAt(i) - 'a']++;
            }
            for (int i = 0; i < sCount.length; i++) {
                if (sCount[i] != tCount[i]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String s = "";
        String t = "";
        System.out.println(solution.isAnagram2(s, t));

    }
}

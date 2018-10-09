package day0927;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
/**
 * @author zkr123
 * @version 1.0
 * @ClassName ListNode
 * @Description
 * @date 2018/10/9 15:06
 */
public class Solution {
    public boolean is (int[] hand, int w) {
        if (hand.length % w != 0) {
            return false;
        }
        Arrays.sort(hand);
        LinkedList<Integer> al = new LinkedList<Integer>();
        double start = System.nanoTime();
        for (int i = 0; i < hand.length; i++) {
            al.add(hand[i]);
        }
        System.out.println(System.nanoTime() - start);
        start = System.nanoTime();
        int value = 0;
        while (al.size() > 0) {
            value = al.get(0);
            al.remove(Integer.valueOf(value));
            for (int i = 0; i < w - 1; i++) {
                value ++;
                if (!al.remove(Integer.valueOf(value))) {
                    return false;
                }
            }
        }
        System.out.println(System.nanoTime() - start);
        return true;
    }
    public static void main(String[] args) {
        int[] hand = {1,2,3,7,1,2,3,5,6};
        Solution s = new Solution();

        //Arrays.sort(hand);
        //ArrayList<Integer> al = new ArrayList<>();
        //for (int i = 0; i < hand.length; i++) {
        //    al.add(hand[i]);
        //}
        //System.out.println(al.toString());
        //al.remove(al.lastIndexOf(3));
        //System.out.println(al.toString());
        System.out.println(s.is(hand, 3));
        System.out.println("Hello World!");
        System.out.println();
        System.out.println();

    }
}

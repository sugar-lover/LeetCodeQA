package day0920;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * @author zkr123
 * @version 1.0
 * @ClassName Solution
 * @Description TODO
 * @date 2018/10/9 15:06
 */
public class Solution {
	
	
	public int[] twoSum(int[] nums, int target){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(){};
		for (int i = 0; i < nums.length; i++) {
			if (map.get(target - nums[i]) != null) {
				return new int[]{map.get(target - nums[i]), i};
			} else {
				map.put(nums[i], i);
			}
		}
		return null;
	}
	
	
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	/**
    	 * Definition for singly-linked list.
    	 * public class ListNode {
    	 *     int val;
    	 *     ListNode next;
    	 *     ListNode(int x) { val = x; }
    	 * }
    	 */
    	ListNode resultNode = new ListNode(0);
    	ListNode curr = resultNode;
    	int c = 0;
    	while (l1 != null || l2 != null) {
    		int x = l1 != null ? l1.val : 0;
    		int y = l2 != null ? l2.val : 0;
    		int num = x + y + c;
    		c = num / 10;
    		curr.next = new ListNode(num % 10);
    		curr = curr.next;
    		l1 = l1 == null ? null : l1.next;
    		l2 = l2 == null ? null : l2.next;
    		
    	}
    	if (c > 0) {
    		curr.next = new ListNode(c);
		}
    	return resultNode.next;
        
    }
    
    
    public int lengthOfLongestSubstring(String s) {
		int maxVal = 0;
		if (s == null || s.length() == 0) {
			return 0;
		}
		int length = s.length();
		ArrayList<String> unList = new ArrayList<String>();
		String nextVal = "";
		for (int i = 0; i < length; i++) {
			nextVal = s.substring(i, i + 1);
			if (!unList.contains(nextVal)) {
				unList.add(nextVal);
				maxVal = Math.max(maxVal, unList.size());
			} else {
				maxVal = Math.max(maxVal, unList.size());
				unList = new ArrayList<String>(unList.subList(unList.indexOf(nextVal) + 1, unList.size()));
				unList.add(nextVal);
			}
		}
		return maxVal;
    }
    
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {

		return 0;
    }
    
}

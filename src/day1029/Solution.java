package day1029;

import entity.ListNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zkr123
 * @version 1.0
 * @ClassName Solution
 * @Description
 * @date 2018/10/29 10:12
 */
public class Solution {
    /*给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

    示例：
    给定一个链表: 1->2->3->4->5, 和 n = 2.
    当删除了倒数第二个节点后，链表变为 1->2->3->5.

    说明：
    给定的 n 保证是有效的。

    进阶：
    你能尝试使用一趟扫描实现吗？*/
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        while (head != null) {
            if (head.next == null) {
                return null;
            }
            ListNode q = head;
            for (int i = 0; i < n + 1; i++) {
                if (q != null) {
                    q = q.next;
                }
                if (i != n && q == null) {
                    return p.next;
                }
                if (i == n && q == null) {
                    if (n == 1) {
                        head.next = null;
                        return p;
                    }
                    head.next.val = head.next.next.val;
                    head.next.next = head.next.next.next;
                    return p;
                }
            }
            head = head.next;
        }
        return p;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }
        List<ListNode> list = new LinkedList<ListNode>();
        ListNode p = head;
        int count = 0;
        while (head != null) {
            list.add(head);
            count++;
            head = head.next;
        }
        if (list.size() == n) {
            return p.next;
        }
        ListNode x = list.get(list.size() - n - 1);
        if (x.next.next == null) {
            x.next = null;
            return p;
        }
        x.next.val = x.next.next.val;
        x.next.next = x.next.next.next;
        return p;
    }


    /*反转一个单链表。
    示例:
    输入: 1->2->3->4->5->NULL
    输出: 5->4->3->2->1->NULL
    进阶:
    你可以迭代或递归地反转链表。你能否用两种方法解决这道题？*/
    public ListNode reverseList(ListNode head) {
        return head;
    }
}

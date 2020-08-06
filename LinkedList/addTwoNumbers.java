package LinkedList;

import java.util.List;

public class addTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        helpMethod(l1,l2, result, 0);
        return result.next;
    }

    private static void helpMethod(ListNode l1, ListNode l2, ListNode tempResult, int carry) {
        if (l1 == null && l2 == null) {
            // End
            if (carry != 1) {
                tempResult.next = new ListNode(carry);
            }
            return;
        }
        if (l1 == null) {
            int value_next = (l2.val + carry) % 10;
            int carry_next = (l2.val + carry) / 10;
            tempResult.next = new ListNode(value_next);
            helpMethod(null, l2.next, tempResult.next, carry_next);
        } else if (l2 == null) {
            int value_next = (l1.val + carry) % 10;
            int carry_next = (l1.val + carry) / 10;
            tempResult.next = new ListNode(value_next);
            helpMethod(l1.next, null, tempResult.next, carry_next);
        } else {
            int value_fir = l1.val;
            int value_sec = l2.val;
            int value_next = (value_fir + value_sec + carry) % 10;
            int carry_next = (value_fir + value_sec + carry) / 10;
            tempResult.next = new ListNode(value_next);
            helpMethod(l1.next, l2.next, tempResult.next, carry_next);
        }
    }


    public static ListNode iterate(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        ListNode cur = result;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int value_first = (l1 == null) ? 0 : l1.val;
            int value_sec = (l2 == null) ? 0 : l2.val;
            int sum = carry + value_first + value_sec;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (l1!= null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        if (carry > 0)
            cur.next = new ListNode(carry);
        return result.next;
    }

    public static void main(String[] args) {
        ListNode first = new ListNode(2);
        first.next = new ListNode(4);
        first.next.next = new ListNode(3);
        ListNode sec = new ListNode(5);
        sec.next = new ListNode(6);
        sec.next.next = new ListNode(4);
        addTwoNumbers(first, sec);
    }
}

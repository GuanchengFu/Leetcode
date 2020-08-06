package LinkedList;

public class removeNthFromEnd {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode[] temp = null;
        int length = n + 1;
        ListNode cur = head;
        boolean removeFirst = false;
        boolean f = true;
        while (f) {
            ListNode ref = cur;
            ListNode[] another = new ListNode[n + 1];
            for (int i = 0; i < length; i ++) {
                if (ref == null) {
                    f = false;
                    if (cur == head) {
                        removeFirst = true;
                    }
                    // break 后面得片段都不执行
                    break;
                } else {
                    another[i] = ref;
                    ref = ref.next;
                }
            }
            if (f) {
                temp = another;
            }
            cur = cur.next;
        }
        if (removeFirst) {
            return head.next;
        }
        if (temp.length > 2) {
            temp[0].next = temp[2];
        } else {
            temp[0].next = null;
        }
        return head;
    }

    public static ListNode aBetterApproach(ListNode head, int n) {
        ListNode prev = head;
        ListNode cur = head;
        int temp = n;
        while (temp > 0) {
            cur = cur.next;
            temp -= 1;
        }
        if (cur == null)
            return head.next;
        while (cur.next != null) {
            prev = prev.next;
            cur = cur.next;
        }
        prev.next = prev.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode test = new ListNode(1);
        test.next = new ListNode(2);
        removeNthFromEnd(test, 2);
    }
}

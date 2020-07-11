package LinkedList;

public class reverseList {



    // Recursion version
    /** General idea:
     *  1. 处理特殊情况，即head == null得时候
     *  2. 对整个递归得程序进行抽象得把握
     *  3. 写base case
     *  4. 完成程序。*/
    public static ListNode solution(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode result = solution(head.next);
        head.next.next = head;
        head.next = null;
        return result;
    }


    // Iterate version.
    /** 注意这里可以将指针挪到null这一项，这样得话可以不用处理特殊情况。
     *  反转链表一般需要3个指针。*/
    public static ListNode solution2(ListNode head) {
        ListNode p1 = null;
        ListNode p2 = head;
        while (p2 != null) {
            ListNode temp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = temp;
        }
        return p1;
    }

    public static void main(String[] args) {
        ListNode test = new ListNode(1);
        test.next = new ListNode(2);
        test.next.next = new ListNode(3);
        test.next.next.next = new ListNode(4);
        solution(test);
    }
}

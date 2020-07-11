package LinkedList;

public class reverseBetween {
    //Leetcode 92
    public static ListNode solution(ListNode head, int m, int n) {
        if (head == null)
            return null;
        if (m != 1) {
            head.next = solution(head.next, m - 1, n - 1);
            return head;
        } else {
            if (n > 1) {
                // head = 2 temp = 3
                ListNode temp = head.next;
                // temp2 = 4->3->5
                ListNode temp2 = solution(head.next, m, n - 1);
                // temp3 = 5
                ListNode temp3 = temp.next;
                temp.next = head;
                head.next = temp3;
                return temp2;
            } else {
                return head;
            }
        }
    }

    public static void main(String[] args) {
        ListNode test = new ListNode(1);
        test.next = new ListNode(2);
        test.next.next = new ListNode(3);
        test.next.next.next = new ListNode(4);
        test.next.next.next.next = new ListNode(5);
        solution(test, 2, 4);
    }
}

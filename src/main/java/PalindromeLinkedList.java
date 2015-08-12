/**
 * Created by longweiquan on 15/8/13.
 *
 * Solution : Cut list into two and reverse one of them, then compare one by one
 */
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {

        // at least two elements
        if(head == null || head.next == null){
            return true;
        }

        // find out the middle elements with fast and slow pointers
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // cut list at position slow
        ListNode second = slow.next;
        slow.next = null;

        // reverse second part
        ListNode p1 = second;
        ListNode p2 = second.next;
        while(p1!=null && p2 != null){
            ListNode temp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = temp;
        }
        // after reversion, second head become end
        second.next = null;

        second = p2 != null ? p2 : p1;

        while(head!=null && second!=null){
            if(head.val != second.val){
                return false;
            }
            head = head.next;
            second = second.next;
        }

        return true;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}

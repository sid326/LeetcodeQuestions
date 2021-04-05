/**
 * @author Siddhant Sharma
 * @date 06-Apr-2021 @time 12:45:40 am
 */
public class ReversLLUsingLoop {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		ReversLLUsingLoop obj = new ReversLLUsingLoop();
		head = obj.reverseList(head);
		while(head!=null) {
			System.out.print(head.val);
			head = head.next;
		}
	}
	
	public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode nextNode = head;
        
        while(current!=null){
            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        head = prev;
        return head;
    }

}

class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
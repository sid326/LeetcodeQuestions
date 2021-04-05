
/**
 * @author Siddhant Sharma
 * @date 06-Apr-2021 @time 12:43:34 am
 */
public class ReverseLLUsingRecursion {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		ReverseLLUsingRecursion obj = new ReverseLLUsingRecursion();
		head = obj.reverseList(head);
		while(head!=null) {
			System.out.print(head.val);
			head = head.next;
		}
	}

	public ListNode reverseList(ListNode head) {
		if(head == null || head.next== null){
			return head;
		}
		ListNode temp = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return temp;
	}
}
/**
 * 
 */

/**
 * @author Siddhant Sharma
 * @date 06-Apr-2021 @time 11:54:09 pm
 */
public class Merge2ListSol2 {

	/*
	 * Solution by using recursion
	 */
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);

		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);

		Merge2ListSol2 obj = new  Merge2ListSol2();
		ListNode result = obj.mergeTwoLists(l1, l2);
		while(result!=null) {
			System.out.println(result.val);
			result = result.next;
		}
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null)
			return l2;

		if(l2 == null)
			return l1;

		if(l1.val < l2.val) 
			return new ListNode(l1.val, mergeTwoLists(l1.next, l2));
		else
			return new ListNode(l2.val, mergeTwoLists(l1, l2.next));
	}
}
class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

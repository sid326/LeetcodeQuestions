import java.util.PriorityQueue;

/**
 * @author Siddhant Sharma
 * @date 06-Apr-2021 @time 11:39:48 pm
 */
public class Merge2List {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);

		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);

		Merge2List obj = new  Merge2List();
		ListNode result = obj.mergeTwoLists(l1, l2);
		while(result!=null) {
			System.out.println(result.val);
			result = result.next;
		}

	}
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		if(l1 == null && l2 ==null)
            return null;
		PriorityQueue<Integer> queue = new PriorityQueue<>();

		while(l1!=null) {
			queue.offer(l1.val);
			l1 = l1.next;
		}
		while(l2!=null) {
			queue.offer(l2.val);
			l2 = l2.next;
		}

		ListNode result = new ListNode(queue.isEmpty()?0:queue.poll());
		ListNode tempResult = result;
		while(!queue.isEmpty()) {
			tempResult.next = new ListNode(queue.poll());
			tempResult = tempResult.next;
		}
		tempResult = null;
		return result;
	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

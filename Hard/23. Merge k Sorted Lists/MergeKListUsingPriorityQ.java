import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 */

/**
 * @author Siddhant Sharma
 * @date 07-Apr-2021 @time 12:01:00 am
 */
public class MergeKListUsingPriorityQ {

	public static void main(String[] args) {

		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);

		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);

		ListNode l3 = new ListNode(1);
		l3.next = new ListNode(2);
		l3.next.next = new ListNode(4);

		ListNode l4 = new ListNode(1);
		l4.next = new ListNode(3);
		l4.next.next = new ListNode(4);

		ListNode l5 = new ListNode(1);
		l5.next = new ListNode(2);
		l5.next.next = new ListNode(4);

		ListNode l6 = new ListNode(1);
		l6.next = new ListNode(3);
		l6.next.next = new ListNode(4);

		MergeKListUsingPriorityQ obj = new MergeKListUsingPriorityQ();
		ListNode[] nodeArray = {l1,l2,l3,l4,l5,l6};
		ListNode result = obj.mergeKLists(nodeArray);
		while(result!=null) {
			System.out.println(result.val);
			result = result.next;
		}
	}
	public ListNode mergeKLists(ListNode[] lists) {
		Comparator<ListNode> listCOmp  =(ListNode l1, ListNode l2) -> (l1.val - l2.val);
		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(listCOmp);

		for(ListNode head :lists) {
			if(head!=null) {
				queue.offer(head);
			}
		}

		ListNode result = new ListNode(-1);
		ListNode temp = result;
		while(!queue.isEmpty()) {
			ListNode current = queue.poll();
			temp.next = current;
			temp = temp.next;
			if(current.next!=null) {
				queue.offer(current.next);
			}
		}

		return result.next;
	}
}
class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
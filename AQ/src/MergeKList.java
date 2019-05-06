import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * Example:
 *
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */
public class MergeKList {


    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null, last = null;
        Queue<ListNode> pq = new PriorityQueue<>((ListNode node1, ListNode node2) -> node1.val - node2.val);

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) pq.add(lists[i]);
        }

        while (!pq.isEmpty()) {
            ListNode top = pq.poll();
            if (top.next != null) pq.add(top.next);

            if (head == null) {
                head = top;
                last = top;
            }
            else {
                last.next = top;
                last = top;
            }
        }
        return head;
    }
}

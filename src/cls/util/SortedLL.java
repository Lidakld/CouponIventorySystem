package cls.util;

public class SortedLL<E extends Comparable<E>> extends LinkedList<E>{
	protected LLNode head;
	
	public SortedLL() {
		this.head = null;
	}
	
	public boolean isFull() {
		return false;
	}

	public void remove(E e) throws Exception {
		if (head == null)
			throw new Exception("Remove attemped on an empty Linkedlist!");
		else {
			if (head.info.equals(e)) {
				head = head.next;
			}
		}
		LLNode cur = head;
		LLNode pre = null;

		while (cur != null && !cur.info.equals(e)) {
			pre = cur;
			cur = cur.next;
		}

		if (cur == null)
			throw new Exception("Remove attemped on an empty Linkedlist!");

	}
	
	public void add(E e) {
		LLNode new_node = new LLNode(e, null);
		
		if(head == null || head.compareTo(e) == 1) {
			new_node.info = e;
			new_node.next = head;
			head = new_node;
		}
		else {
			LLNode current = head;
			LLNode pre = head;
			while(current!=null && current.compareTo(e) < 1) {
				pre = current;
				current = current.next;
				new_node.info = e;
			}
			pre.next  = new_node;
			new_node.next = current;
		}
	}
	
}

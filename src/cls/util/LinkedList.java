package cls.util;

import java.util.Iterator;
import java.lang.Comparable;

public class LinkedList<E extends Comparable<E>>{
	public LLNode<E> head;
	public LLNode<E> cursor;
	public int size;

	public LinkedList() {
		head = new LLNode<E>(null, null);
		head.next = head;
	}

	public void add(E e) {
		head.next = new LLNode<E>(e, head.next);
		size++;
	}

	public void remove(E e) throws Exception {
		if(size == 0) return;
		LLNode<E> pre = head;
		
		while(pre.next != head ) {
			if(pre.next.info.compareTo(e)  == 0) {
				LLNode<E> cur = pre.next;
				pre.next = cur.next;
				if(cur == head)
					head = cur;
				
				size--;
				break;
			}
			pre = pre.next;	
		} 
	}
	/**
	 * Search one E, return iteration number if found, -1 otherwise
	 * @param e
	 * @return #iteration
	 */
	public int search(E e) {
		if(size == 0) return -1;
		
		int num_ite = 0;
		Iterator<E> ite = this.iterator();
		
		while(ite.hasNext()) {
			E ne = ite.next();
			num_ite++;
			if(ne.equals(e)) {
				return num_ite;
			}
		}
		
		return -1;
	}
	
	
	public LinkedList<E> merge(LinkedList<E> li) {
		 LLNode<E> tail = head;
		 while(tail.next != head) {
			 tail = tail.next;
		 }
		 
		 tail.next = li.head.next;
		 li.head.next = head.next;
		 
		 return li;
	}
	
	public void iteratFromStart() {
		this.cursor = head;
	}
	
	public int size() {
		return size;
	}
	
	public E get(int index) {
		LLNode<E> curse = head.next;
		int find = 0;
		while(find != index && curse.next != head) {
			curse = curse.next;
			find++;
		}
		return curse.info;		
	}
	
	public LLIterator<E> iterator(){
		return new LLIterator<E>();
	}
	
	public class LLIterator<E> implements Iterator<E>{
		
		public LLIterator() {
			cursor = head;
		}
		@Override
		public boolean hasNext() {
			return cursor.next != head;
		}

		@Override
		public E next() {
			cursor = cursor.next;
			E element = (E) cursor.info;
			return element;
		}
		
	}

	
}

package cls.util;

public class LLNode<E extends Comparable<E>> {
	public LLNode<E> next;
	public E info;
	
	public LLNode(E e,LLNode<E> next) {
		this.next = next;
		this.info = e;
	}
	
	public void setLink(LLNode<E> n) {
		next = n;
	}
	
	public LLNode<E> getLink() {
		return next;
	}
	
	public void setInfo(E e) {
		info = e;
	}
	
	public E getInfo() {
		return info ;
	}

	public int compareTo(E e) {
		return this.info.compareTo(e);
	}
}

package cls.util;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class BST<E extends Comparable<E>> {
	protected Node<E> root = null;
	protected int size = 0;

	public BST() {
		size = 0;
	}

	public void add(E e) {
		Node<E> ne = new Node<>(e);
		if (root == null) {
			root = ne;
			size ++;
		} else {
			Node<E> curse = root;
			Node<E> pre = curse;
			while (curse != null) {
				pre = curse;
				if (e.compareTo(curse.data) > 0) {
					curse = curse.right;
				} else {
					curse = curse.left;
				}
			}

			if (ne.compareTo(pre) > 0) {
				pre.right = ne;
			} else {
				pre.left = ne;
			}
			ne.parent = pre;
			size ++;
		}
	}
	
	public int getSize() {return size;}

	public E remove(E e) {
		if(e == null || root == null)  return null;
		
		Node<E> curse = root;
		Node<E> pre = curse;

		Node<E> target = find(e);
		
		if(target == null) return null;
		else {
			Node<E> subn  =  finSubstituteNode(target);
			
			if(subn == null) return null; 
			else if(subn.equals(target)) {//subtitue is target itself
				if(subn == root) root = null;
				else {
					//cut relation of the subn
					if(subn.parent.right != null && subn.parent.right.equals(subn)){
						subn.parent.right = null;
					}else {
						subn.parent.left = null;
					}
					size --;
				}
			}else {// otherwise
				//cut relation of the subn
				if(subn.parent.right != null && subn.parent.right.equals(subn)){
					subn.parent.right = null;
				}else {
					subn.parent.left = null;
				}
				
				//swap with target's parent
				if(target != root) {
					if(target.parent.right != null && target.parent.right.equals(target)){
						target.parent.right = subn;
					}else {
						target.parent.left = subn;
					}
					
					subn.parent = target.parent;
				}else {
					root = subn;
					subn.parent = null;
				}
				
				//swap with target's right node
				subn.right = target.right;
				if(target.right != null) target.right.parent = subn;
				
				//swap with target's left node
				subn.left = target.left;
				if(target.left != null) target.left.parent = subn;
				
				//update size
				size = (size == 0)?size-1:0;
			}
			return subn.data;
		}
	}

	/**
	 * 
	 * @param e
	 * @return -1 not found, #numebr of iteration , I.E. 1 for 1 iteration.
	 */
	public int search(E e) {
		if(e == null || root == null) return -1;
		int ite = 0;
		Node<E> curse = root;

		while (curse != null) {
			ite++;
			if (e.compareTo(curse.data) > 0) {
				curse = curse.right;
			} else if (e.compareTo(curse.data) < 0) {
				curse = curse.left;
			} else {
				if(e.equals(curse.data)) return ite;
				else 
					curse = curse.left;	
			}
		}

		return -1;
	}

	/**
	 * Find node by data
	 * 
	 * @param e
	 * @return
	 */
	private Node<E> find(E e) {
		if(e == null || root == null)  return null;
		
		Node<E> curse = root;
		Node<E> pre = curse;

		while (curse != null) {
			pre = curse;
			if (e.compareTo(curse.data) > 0) {
				curse = curse.right;
			} else if (e.compareTo(curse.data) < 0) {
				curse = curse.left;
			} else {
				return curse;
			}
		}

		return null;
	}

	/**
	 * finSubstituteNode, return the largest element on the left subtree or smallest element on the right subtree, or null.
	 * 
	 * @param ne
	 * @return
	 */
	public Node<E> finSubstituteNode(Node<E> ne) {
		if (ne == null) {
			return null;
		} else {
			if (ne.left != null) {
				Node<E> curse = ne.left;
				Node<E> pre  = curse;
				
				while (curse != null) {
					pre = curse;
					curse = curse.right;
				}
				
				return pre;
			} else if(ne.right != null){
				Node<E> curse = ne.right;
				Node<E> pre  = curse;
				
				while (curse != null) {
					pre = curse;
					curse = curse.left;
				}
				
				return pre;
			}else {
				return ne;
			}
		}
	}
	
	
	public void inorder() {
		vinorder(root);
	}
	
	public void vinorder(Node<E> ne) {
		if(ne != null) System.out.print(ne.data.toString()+", ");
		else return;
		vinorder(ne.left);
		vinorder(ne.right);
	}

	/**
	 * Searching target's parent
	 */
	

	class Node<E extends Comparable<E>> implements Comparable<Node<E>> {
		protected Node<E> parent;
		protected Node<E> left;
		protected Node<E> right;
		protected E data;

		public Node(E data) {
			this.left = null;
			this.right = null;
			this.parent = null;
			this.data = data;
		}

		@Override
		public int compareTo(Node<E> o) {
			return this.data.compareTo(o.data);
		}
		
	}
}

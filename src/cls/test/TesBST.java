package cls.test;

import cls.util.BST;

public class TesBST {
	
	public static void main(String[] ars) {
		BST<Integer> bst = new BST<>();
		
		bst.add(1);
		bst.add(2);
		bst.add(3);
		bst.add(4);
		bst.add(-1);
		bst.add(0);
		bst.add(-10);

		
		System.out.println(bst.search(-10));
	}

}

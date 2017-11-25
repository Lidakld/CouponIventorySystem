package cls.test;
import java.util.Date;

import cls.beans.CouponProvider;
import cls.beans.Product;
import cls.dao.Constant;
import cls.util.LLNode;
import cls.util.LinkedList;
import cls.util.LinkedList.LLIterator;

public class testLinkedList {
	public static void main(String[] args) {
		LinkedList<Integer> tl = new LinkedList<>();
		
		tl.add(5);
		tl.add(1);
		tl.add(3);
		tl.add(2);
		tl.add(4);
		
	
		
			System.out.println(tl.search(1));
		
	}
}

package cls.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;

import cls.beans.Coupon;
import cls.beans.CouponProvider;
import cls.beans.Msg;
import cls.beans.Product;
import cls.dao.Constant;
import cls.dao.DataManager;
import cls.util.LLNode;
import cls.util.LinkedList;
import cls.util.LinkedList.LLIterator;

public class Test {
	public static void main(String[] args) throws ParseException {
		//SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM-dd-yyyy");
		
		DataManager dm = new DataManager();
		Coupon c1 = new  Coupon(
				new CouponProvider("Gropon"), 
				new Product("new", (float)0.5), 
				(float)0.5, 
				100,				
				Constant.Cstatus.unused);
		Coupon c2 = new  Coupon(
				new CouponProvider("Walmart"), 
				new Product("food", (float)12.07), 
				(float)0.88, 
				50,				
				Constant.Cstatus.redeemed);
		Coupon c3 = new  Coupon(
				new CouponProvider("Whole Foods"), 
				new Product("food", (float)100.00), 				
				(float)0.7, 
				30,				
				Constant.Cstatus.redeemed);
		Coupon c4 = new  Coupon(
				new CouponProvider("Macy's"), 
				new Product("food", (float)30.00), 
				(float)0.6, 
				73,
				Constant.Cstatus.unused);
		Coupon c5 = new  Coupon(
				new CouponProvider("Macy's"), 
				new Product("shoes", (float)500.00), 
				(float)0.6, 
				32,
				Constant.Cstatus.unused);
		
		dm.addCoupon(c3);
		dm.addCoupon(c1);
		dm.addCoupon(c4);
		dm.addCoupon(c2);
		dm.addCoupon(c5);
		
		dm.addForBST(c3);
		dm.addForBST(c1);
		dm.addForBST(c4);
		dm.addForBST(c2);
		dm.addForBST(c5);
		
		/**
		 * add function implement
		 */
		LinkedList<Coupon> ll = dm.getCouponList();
		Iterator<Coupon> itr = ll.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
		/**
		 * search function implement
		 */
		System.out.println("\n"+"Search [ 0.6, food, 30.0, 73, Macy's, unused]");
		Msg<Coupon> msg = dm.line_searchCoupon(c4);
			System.out.println(msg.getMessage());
		Msg<Coupon> msg2 = dm.BST_searchCoupon(c4);
		System.out.println(msg2.getMessage());
		
		/**
		 * list function implement
		 */
		System.out.println("\n"+"List by discount:");
		LinkedList<Coupon> dl = dm.listByDiscount().getData();
		Iterator<Coupon> ite = dl.iterator();
		while(ite.hasNext())
			System.out.println(ite.next());
		
		System.out.println("\n"+"List by Price:");
		LinkedList<Coupon> pl = dm.listByPrice().getData();
		Iterator<Coupon> iter = dl.iterator();
		while(iter.hasNext())
			System.out.println(ite.next());
		
		System.out.println("\n"+"List by expire Period:");
		LinkedList<Coupon> el = dm.listByExpirePeriod().getData();
		Iterator<Coupon> ier = dl.iterator();
		while(ier.hasNext())
			System.out.println(ite.next());
		
		System.out.println("\n"+"List by 'Macy's'(provider name):");
		LinkedList<Coupon> vl = dm.listByProvider("Macy's").getData();
		Iterator<Coupon> ir = vl.iterator();
		while(ir.hasNext())
			System.out.println(ir.next());
		
		System.out.println("\n"+"List by 'food'(product name):");
		LinkedList<Coupon> prol = dm.listByProduct("food").getData();
		Iterator<Coupon> i = prol.iterator();
		while(i.hasNext())
			System.out.println(i.next());
		
		System.out.println("\n"+"List by 'unused'(status):");
		LinkedList<Coupon> sl = dm.listByStatus(Constant.Cstatus.unused).getData();
		Iterator<Coupon> it = sl.iterator();
		while(it.hasNext())
			System.out.println(it.next());
	}
}

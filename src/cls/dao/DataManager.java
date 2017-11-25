package cls.dao;

import java.util.Iterator;
import java.util.List;

import cls.beans.Coupon;
import cls.beans.CouponProvider;
import cls.beans.Msg;
import cls.beans.Product;
import cls.beans.Transaction;
import cls.beans.User;
import cls.util.BST;
import cls.util.CS401ArrayImpl;
import cls.util.CSVUtil;
import cls.util.LLNode;
import cls.util.LinkedList;
import cls.util.LinkedList.LLIterator;

public class DataManager {
	protected LinkedList<Coupon> coupons;
	protected BST<Coupon> bcoupons;
	protected User user;
	protected CS401ArrayImpl<Product> product;
	protected CS401ArrayImpl<CouponProvider> couponProvider;
	protected CS401ArrayImpl<Transaction> transaction;
	protected CSVUtil csvUtil;

	public DataManager() {
		coupons = new LinkedList<>();
		bcoupons = new BST<>();
		user = new User(Constant.userName);
		product = new CS401ArrayImpl<>(10);
		couponProvider = new CS401ArrayImpl<>(10);
		transaction = new CS401ArrayImpl<>(10);
		csvUtil = new CSVUtil(Constant.readpath, Constant.writepath);
	}
	
//////////////////ADD COUPON///////////////////////////////////////
	
	/////////////Add by Importing File/////////////////
	public Msg<Coupon> addCouponsWithCSV(String filename) {
		Msg<Coupon> msg = new Msg<>();
		LinkedList<Coupon> data = csvUtil.readCoupon(filename);
		coupons = coupons.merge(data);
		// update product
		// update couponProvider
		msg.setMessage("Get the data");
		msg.setError(1);
		msg.setData(data);

		return msg;
	}
	//////////ADD MANUALLY///////////////////////////////
	public Msg<Coupon> addCoupon(Coupon coupon) {
		coupons.add(coupon);
		Msg<Coupon> msg = new Msg<>();
		msg.setMessage("Success");
		msg.setError(1);
		msg.setData(coupons);
		return msg;
	}
	
//////////////////LIST ALL COUPON///////////////////////////////////////////////////
	public Msg<Coupon> listAllCoupon() {
		Msg<Coupon> msg = new Msg<>();
		msg.setMessage("Success");
		msg.setError(1);
		msg.setData(coupons);
		return msg;
	}
	/**
	 * following types of list functions are required  to list by ASCENDING ORDER!!!
	 * @param coupon
	 * @return
	 */
	//////////////By Price////////////////////////
	public Msg<Coupon> listByPrice(){
		if(coupons.size > 1) {
			for(int i=0; i<coupons.size;i++) {
				LLNode<Coupon> pre = coupons.head;
				LLNode<Coupon> cur =pre.next;
				LLNode<Coupon> nextn = cur.next;
				for(int j=0;j<coupons.size-1;j++) {
					if(cur.info.comparePrice(nextn.info)>0) {
						cur.next = nextn.next;
						nextn.next = cur;
						pre.next = nextn;		
					}
					pre = cur;
					cur = nextn;
					nextn = nextn.next;
				}
			}
		}
		Msg<Coupon> msg = new Msg<>();
		msg.setMessage("Sorted by Price");
		msg.setError(1);
		msg.setData(coupons);
		return msg;
	}
	
	//////////////By Discount////////////////////////
	public Msg<Coupon> listByDiscount(){
		if(coupons.size > 1) {
			for(int i=0; i<coupons.size;i++) {
				LLNode<Coupon> pre = coupons.head;
				LLNode<Coupon> cur =pre.next;
				LLNode<Coupon> nextn = cur.next;
				for(int j=0;j<coupons.size-1;j++) {
					if(cur.info.compareDiscount(nextn.info)>0) {
						cur.next = nextn.next;
						nextn.next = cur;
						pre.next = nextn;		
					}
					pre = cur;
					cur = nextn;
					nextn = nextn.next;
				}
			}
		}
		Msg<Coupon> msg = new Msg<>();
		msg.setMessage("Sorted by Discount");
		msg.setError(1);
		msg.setData(coupons);
		return msg;
	}
	
	////////////////By Expire Period/////////////////////////
	public Msg<Coupon> listByExpirePeriod(){
		if(coupons.size > 1) {
			for(int i=0; i<coupons.size;i++) {
				LLNode<Coupon> pre = coupons.head;
				LLNode<Coupon> cur =pre.next;
				LLNode<Coupon> nextn = cur.next;
				for(int j=0;j<coupons.size-1;j++) {
					if(cur.info.getExpirePeroid() > nextn.info.getExpirePeroid()) {
						cur.next = nextn.next;
						nextn.next = cur;
						pre.next = nextn;		
					}
					pre = cur;
					cur = nextn;
					nextn = nextn.next;
				}
			}
		}
		Msg<Coupon> msg = new Msg<>();
		msg.setMessage("Sorted by Expire Period");
		msg.setError(1);
		msg.setData(coupons);
		return msg;
	}
	

	///////////////////////By Status////////////////////////////
	public Msg<Coupon> listByStatus(Constant.Cstatus status){
		LinkedList<Coupon> newco = new LinkedList<>();
		
		if(coupons.size > 1) {
			Iterator<Coupon> itr = coupons.iterator();
			
			while(itr.hasNext()) {
				Coupon c = itr.next();
				
				if(status == Constant.Cstatus.redeemed) {
					if(c.getStatus() == Constant.Cstatus.redeemed) {
						LLNode<Coupon> newnode = new LLNode<Coupon>(c, newco.head.next);
						newco.head.next = newnode;
					}
				}
				else if(status == Constant.Cstatus.unused) {
					if(c.getStatus() == Constant.Cstatus.unused) {
						LLNode<Coupon> newnode = new LLNode<Coupon>(c, newco.head.next);
						newco.head.next = newnode;
					}
				}
				else;
			}
		}
		
		Msg<Coupon> msg = new Msg<>();
		msg.setMessage("Sorted by Status");
		msg.setError(1);
		msg.setData(newco);
		return msg;
	}
	
	////////////////////////////By ProviderName//////////////////////
	public Msg<Coupon> listByProvider(String findP){
		Msg<Coupon> msg = new Msg<>();
		LinkedList<Coupon> pl = new LinkedList<>();		
		Iterator<Coupon> itr = coupons.iterator();
		while(itr.hasNext()) {
			Coupon c = itr.next();
			
			if(c.getCouponProvider().getName() == findP) {
				LLNode<Coupon> newnode = new LLNode<>(c,pl.head.next);
				pl.head.next = newnode;
				msg.setMessage("Sorted by Provider");
				msg.setError(1);
				msg.setData(pl);
			}
			else {
				msg.setMessage("not found");
				msg.setError(-1);
			}
		}
		
		return msg;
	}
	
	/////////////////////By Product Name/////////////////////
	public Msg<Coupon> listByProduct(String findPro){
		LinkedList<Coupon> pl = new LinkedList<>();
		
		Iterator<Coupon> itr = coupons.iterator();
		while(itr.hasNext()) {
			Coupon c = itr.next();
			
			if(c.getProduct().getName() == findPro) {
				LLNode<Coupon> newnode = new LLNode<>(c,pl.head.next);
				pl.head.next = newnode;
			}
		}
		Msg<Coupon> msg = new Msg<>();
		msg.setMessage("Sorted by Product");
		msg.setError(1);
		msg.setData(pl);
		return msg;
	}
	
//////////////////SEARCH COUPON ///////////////////////////////////////
	
	//////////////////Linear Search ///////////////////
	public Msg<Coupon> line_searchCoupon(Coupon coupon){
		Msg<Coupon> msg = new Msg<>();
		int cou = coupons.search(coupon);
		if(cou  == -1) {
			msg.setError(-1);
			msg.setMessage("not found");
		}else {
			msg.setMessage("Search at: "+cou+"th, by Linear Search");
			msg.setError(1);
			LinkedList<Coupon> data =  new LinkedList<>();
			data.add(coupon);
			msg.setData(data);
		}
		//msg.setMessage("Success");
		//msg.setError(1);
		//msg.setData(coupons);
		return msg;
	}
	
	/////////////////BST Search ////////////////////
	public Msg<Coupon> addForBST(Coupon coupon) {
		bcoupons.add(coupon);
		Msg<Coupon> msg = new Msg<>();
		msg.setMessage("Success");
		msg.setError(1);
		msg.setData(coupons);
		return msg;
	}
	
	public Msg<Coupon> BST_searchCoupon(Coupon coupon){
		Msg<Coupon> msg = new Msg<>();
		int cou = bcoupons.search(coupon);
		if(cou  == -1) {
			msg.setError(-1);
			msg.setMessage("not found");
		}else {
			msg.setMessage("Search at: "+cou+"th, by BST");
			msg.setError(1);
			LinkedList<Coupon> data =  new LinkedList<>();
			data.add(coupon);
			msg.setData(data);
		}
		//msg.setMessage("Success");
		//msg.setError(1);
		//msg.setData(coupons);
		return msg;
	}

	
	public LinkedList<Coupon> getCouponList(){
		return this.coupons;
	}
	
	
}

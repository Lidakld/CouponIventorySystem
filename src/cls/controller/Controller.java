package cls.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import cls.beans.Coupon;
import cls.beans.CouponProvider;
import cls.beans.Msg;
import cls.beans.Product;
import cls.dao.Constant;
import cls.dao.DataManager;
import cls.gui_new.FormEvent;
import cls.gui_new.ResultEvent;
import cls.gui_new.ResultListener;
import cls.util.LinkedList;


public class Controller {
	private ResultListener resultListener;
	
	DataManager dm = new DataManager();
	
	public Controller() {
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
	}
	public LinkedList<Coupon> listAll(){
		return dm.getCouponList();
	}
	
	public void addCoupon(FormEvent ev){
		CouponProvider provider = new CouponProvider(ev.getProvider());
		
		Product product = new Product(ev.getProdName(),Float.valueOf(ev.getProdPrice()));
		
		float dRate = Float.valueOf(ev.getdRate());
		
		int expirePeriod = Integer.valueOf(ev.getExpirePeriod());
		Constant.Cstatus status = Constant.Cstatus.valueOf(ev.getStatus());
	
		Coupon coupon = new Coupon(provider, product, dRate, expirePeriod, status);
		
		dm.addCoupon(coupon);
	}
	public void searchCoupon(FormEvent ev){
		CouponProvider provider = new CouponProvider(ev.getProvider());
		
		Product product = new Product(ev.getProdName(),Float.valueOf(ev.getProdPrice()));
		
		float dRate = Float.valueOf(ev.getdRate());
		
		int expirePeriod = Integer.valueOf(ev.getExpirePeriod());
		Constant.Cstatus status = Constant.Cstatus.valueOf(ev.getStatus());
	
		Coupon coupon = new Coupon(provider, product, dRate, expirePeriod, status);
		
		String msg1 = dm.line_searchCoupon(coupon).getMessage();
		String msg2 = dm.BST_searchCoupon(coupon).getMessage();
		String msg = msg1 + "\n" + msg2;
		
		ResultEvent re = new ResultEvent(this,msg);
		if(resultListener != null) {
			resultListener.ResultEventsOccured(re);
		}
	}
	public void setResultListener(ResultListener listener) {
		this.resultListener = listener;
	}
	public LinkedList<Coupon> listByPrice() {
		return dm.listByPrice().getData();
	}
	public LinkedList<Coupon> listByDiscount() {
		return dm.listByDiscount().getData();
	}
	public LinkedList<Coupon> listByExpireP() {
		return dm.listByExpirePeriod().getData();
	}
	public LinkedList<Coupon> listByStatus(Constant.Cstatus status) {
		return dm.listByStatus(status).getData();
	}
	public LinkedList<Coupon> listByProvider(String findP) {
		return dm.listByProvider(findP).getData();
	}
	public LinkedList<Coupon> listByProductN(String findPro) {
		return dm.listByProduct(findPro).getData();
	}
}

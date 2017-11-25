package cls.test;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Iterator;

import cls.beans.Coupon;
import cls.dao.DataManager;
import cls.util.CSVUtil;
import cls.util.LinkedList;

public class testCSV {
	public static void main(String[] args) {
//		CSVUtil csv = new CSVUtil("/Users/lidakuang/workspace/cs401/data/", "/Users/lidakuang/workspace/cs401/data/");
//		LinkedList<Coupon> out = csv.readCoupon("coupons.csv");
		DataManager dataM = new DataManager();
		LinkedList<Coupon> out = dataM.addCouponsWithCSV("coupons.csv").getData();
		
		Iterator<Coupon> itr = out.iterator();
		while (itr.hasNext()) {
			Coupon coupon = itr.next();
			System.out.println(coupon);
		}

	}

}

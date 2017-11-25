package cls.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import cls.beans.Coupon;
import cls.beans.CouponProvider;
import cls.beans.Product;
import cls.dao.Constant;

public class CSVUtil {
	private String readpath = "";
	private String wirtepath = "";

	public CSVUtil(String readpath, String wirtepath) {
		super();
		this.readpath = readpath;
		this.wirtepath = wirtepath;
	}

	public LinkedList<Coupon> readCoupon(String filename) {
		filename = readpath + filename;
		FileInputStream inputStream = null;
		Scanner sc = null;
		LinkedList<Coupon> coupons = new LinkedList<>();

		try {
			inputStream = new FileInputStream(filename);
			sc = new Scanner(inputStream, "UTF-8");
			SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy");

			String rev = "";
			sc.nextLine();
			while (sc.hasNextLine()) {
				rev = sc.nextLine();
				String[] tokens = rev.split("\t");
				Coupon coupon;

				coupon = new Coupon(new CouponProvider(tokens[5]),new Product(tokens[1], Float.valueOf(tokens[2])), 
						Float.valueOf(tokens[3]), Integer.valueOf(tokens[1]),
						(tokens[6].equals("redeemed")) ? Constant.Cstatus.redeemed : Constant.Cstatus.unused);

				coupons.add(coupon);
			}

		} catch (Exception e) {
			sc.close();
			return null;
		}

		return coupons;
	}

	public String getReadpath() {
		return readpath;
	}

	public void setReadpath(String readpath) {
		this.readpath = readpath;
	}

	public String getWirtepath() {
		return wirtepath;
	}

	public void setWirtepath(String wirtepath) {
		this.wirtepath = wirtepath;
	}

}

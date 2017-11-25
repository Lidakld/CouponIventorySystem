package cls.beans;

import java.text.SimpleDateFormat;
import java.util.Date;

import cls.dao.Constant;

public class Coupon implements Comparable<Coupon> {
	// private String name;
	private Float discount;
	//private Date expireDate;
	private int expirePeroid;
	private Constant.Cstatus status;
	private Product product;
	private CouponProvider couponProvider;

	//private SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM-dd-yyyy");

	//public Coupon(Float discount, Date date, Product product, CouponProvider couponProvider, Constant.Cstatus status) {
		//super();
		// this.name = name;
		//this.discount = discount;
		//this.expireDate = date;
		//this.status = status;
		//this.product = product;
		//this.couponProvider = couponProvider;
	//}

	public Coupon(CouponProvider couponProvider,Product product, Float discount, int expirePeroid, Constant.Cstatus status) {
		
		super();
		// this.name = name;
		this.discount = discount;
		this.status = status;
		this.product = product;
		this.couponProvider = couponProvider;
		this.expirePeroid = expirePeroid;
	}

	public int getExpirePeroid() {
		return expirePeroid;
	}

	public void setExpirePeroid(int expirePeroid) {
		this.expirePeroid = expirePeroid;
	}

	public Constant.Cstatus getStatus() {
		return status;
	}

	public void setStatus(Constant.Cstatus status) {
		this.status = status;
	}

	// public String getName() {
	// return name;
	// }

	// public void setName(String name) {
	// this.name = name;
	// }

	public Float getDiscount() {
		return discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

	//public Date getExpireDate() {
		//return expireDate;
	//}

	//public void setExpireDate(Date expireDate) {
		//this.expireDate = expireDate;
	//}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public CouponProvider getCouponProvider() {
		return couponProvider;
	}

	public void setCouponProvider(CouponProvider couponProvider) {
		this.couponProvider = couponProvider;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Coupon) {
			Coupon o = (Coupon) obj;
			if (this.discount.equals(o.getDiscount()))
				if(this.expirePeroid == o.getExpirePeroid())
					if(this.status.equals(o.getStatus()))
						if( this.product.equals(o.getProduct()))
							if(this.couponProvider.equals(o.getCouponProvider())) {

				return true;
			}
		}
		return false;
	}

	@Override
	public int compareTo(Coupon o) {
		return comparePrice(o);
	}

	public int compareDiscount(Coupon o) {
		if (this.discount == o.getDiscount()) {
			return 0;
		}else if(this.discount > o.getDiscount()) {
			return 1;
		}else {
			return -1;
		}
	}
	
	
	
	public int comparePrice(Coupon o) {
		if (this.discount*this.product.getPrice() == o.getDiscount()*o.getProduct().getPrice()) {
			return 0;
		}else if(this.discount*this.product.getPrice() > o.getDiscount()*o.getProduct().getPrice()) {
			return 1;
		}else {
			return -1;
		}
	}

	@Override
	public String toString() {
		return "[ " + discount + ", " + product.getName() + ", " + product.getPrice() + ", "
				+ expirePeroid + ", " + couponProvider.getName() + ", " + status + "]";
	}
}

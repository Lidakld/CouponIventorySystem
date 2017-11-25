package cls.beans;

import java.sql.Date;

public class Transaction {
	private User user;
	private Coupon coupon;
	private Date date;

	public Transaction(User user, Coupon coupon, Date date) {
		super();
		this.user = user;
		this.coupon = coupon;
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Coupon getCoupon() {
		return coupon;
	}

	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}

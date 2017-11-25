package cls.gui_new;
import javax.swing.table.AbstractTableModel;
import cls.beans.Coupon;
import cls.util.LLNode;
import cls.util.LinkedList;

public class CouponTableModel extends AbstractTableModel {
	private LinkedList<Coupon> db;

	private String[] colNames = { "Coupon Provider", "Product Name", "Product Price", "Discount Rate", "Expire Period",
			"Status" };

	public CouponTableModel() {
	};

	@Override
	public String getColumnName(int column) {
		return colNames[column];
	}

	public void setData(LinkedList<Coupon> db) {
		this.db = db;
	}

	@Override
	public int getRowCount() {
		return db.size();
	}

	@Override
	public int getColumnCount() {
		return 6;
	}

	@Override
	public Object getValueAt(int row, int col) {
		Coupon coupon = db.get(row);

		switch (col) {
		case 0:
			return coupon.getCouponProvider().getName();
		case 1:
			return coupon.getProduct().getName();
		case 2:
			return coupon.getProduct().getPrice();
		case 3:
			return coupon.getDiscount();
		case 4:
			return coupon.getExpirePeroid();
		case 5:
			return coupon.getStatus();

		}
		return "Null";
	}

}

package cls.gui_new;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;

import cls.beans.Coupon;
import cls.util.LinkedList;

public class TablePanel extends JPanel {
	private JTable table;
	private CouponTableModel tableModel;
	private JScrollPane scrollpane;
	
	public TablePanel() {
		tableModel = new CouponTableModel();
		table = new JTable(tableModel);
		scrollpane = new JScrollPane(table);
		
		//table.setFillsViewportHeight(true);
		
		setLayout(new BorderLayout());
		
		//Border outer = BorderFactory.createTitledBorder("table");
		//setBorder(outer);
		
		add(scrollpane, BorderLayout.CENTER);
	
	}
	public void setData(LinkedList<Coupon> db) {
		tableModel.setData(db);
	}
	
	public void refresh() {
		tableModel.fireTableDataChanged();
	}
}



package cls.gui_new;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Apply {
	 public static void main(String[] args) {
		 
		 SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new JFrame("Coupon Inventory System");
				new Mainframe();
				
			}
			 
		 });
	 }
}

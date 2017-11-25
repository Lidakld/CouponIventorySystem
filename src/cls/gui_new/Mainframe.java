package cls.gui_new;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import cls.beans.Coupon;
import cls.beans.CouponProvider;
import cls.beans.Product;
import cls.controller.Controller;
import cls.dao.Constant;
import cls.util.LinkedList;


public class Mainframe extends JFrame {
	private JFileChooser fileChooser;
	private AddPanel addPanel;
	private SearchPanel searchPanel;
	private ListPanel listPanel;
	private JTabbedPane tabbedPane;
	private TablePanel tablePanel;
	private Controller controller;
	
	public Mainframe() {
		super("Coupon Inventory System");
		
		fileChooser = new JFileChooser();                                   /////////////////////Instantion //////////////
		addPanel = new AddPanel();
		searchPanel = new SearchPanel();
		listPanel = new ListPanel();
		tabbedPane = new JTabbedPane();
		tablePanel = new TablePanel();
		controller = new Controller();
		
		setLayout(new BorderLayout());  
		
		
		setJMenuBar(createMenuBar());                                       //////////////////////Insert Menu///////////////
		
		
		addPanel.setAddPanelListener(new FormListener() {

			public void FormEventsOccured(FormEvent ev) {
				controller.addCoupon(ev);
				tablePanel.refresh();			
			}
			
		});
		searchPanel.setSearchPanelListener(new FormListener() {

			public void FormEventsOccured(FormEvent ev) {
				controller.searchCoupon(ev);
				//tablePanel.refresh();	
			}
			
	
		});
		
		controller.setResultListener(new ResultListener() {
			public void ResultEventsOccured(ResultEvent re) {
				JOptionPane.showMessageDialog(Mainframe.this, re.toString(), 
						"Search Result", JOptionPane.INFORMATION_MESSAGE);
				
			}
			
		});
		
		//LinkedList<Coupon> lis = new  LinkedList<>();
		
		// Test for Jtable
//		Coupon c2 = new  Coupon(
//				new CouponProvider("Walmart"), 
//				new Product("food", (float)12.07), 
//				(float)0.95, 
//				50,				
//				Constant.Cstatus.redeemed);
//		lis.add(c2);
		
		//System.out.println("table size: out: "+ lis.size());
		
		tablePanel.setData(controller.listAll());//
		
		listPanel.setListPanelListener(new RequestListener() {
			public void RequestEventOccured(RequestEvent rq) {
				tablePanel.invalidate();
				switch(rq.type) {
				case 1:
					tablePanel.setData(controller.listByPrice());
					break;
				case 2:
					tablePanel.setData(controller.listByDiscount());
					break;
				case 3:
					tablePanel.setData(controller.listByExpireP());
					break;
				}
				tablePanel.refresh();
			}
			
		});
		listPanel.setListListener(new ListListener() {
			public void ListEventOccured(ListEvent le) {
				switch(le.type) {
				case 4:
					tablePanel.setData(controller.listByProvider(le.info));
					break;
				case 5:
					tablePanel.setData(controller.listByProductN(le.info));
					break;
				case 6:
					tablePanel.setData(controller.listByStatus(Constant.Cstatus.valueOf(le.info)));
					break;
				}
				tablePanel.refresh();
			}
			
		});
		
		tabbedPane.addTab("Add Coupon", addPanel);
	    tabbedPane.addTab("Search Coupon", searchPanel);
	    tabbedPane.addTab("List Coupon", listPanel);
		
	    addPanel.setSize(new Dimension(300,400));
	   
		add(tablePanel,BorderLayout.CENTER);
		add(tabbedPane, BorderLayout.WEST); 
		                                 
		setMinimumSize(new Dimension(800,650));                                  /////////////////Whole Layout of the frame/////////
		setSize(1000, 850);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);	
		
	}
	
	public JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("File");
		JMenuItem importItem = new JMenuItem("Import...");
		JMenuItem exportItem = new JMenuItem("Export...");
		JMenuItem exitItem = new JMenuItem("Exit");
		fileMenu.add(importItem);
		fileMenu.add(exportItem);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);
		
		menuBar.add(fileMenu);
		
		importItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fileChooser.showOpenDialog(Mainframe.this) == JFileChooser.APPROVE_OPTION) {
					System.out.println(fileChooser.getSelectedFile());
				}
			}
		});
		
		exportItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(fileChooser.showSaveDialog(Mainframe.this) == JFileChooser.APPROVE_OPTION) {
					System.out.println(fileChooser.getSelectedFile());
				}	
			}
		});
		
		exitItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int action = JOptionPane.showConfirmDialog(Mainframe.this,
						"Do you really want to exit?","Confirm Exit",JOptionPane.OK_CANCEL_OPTION);
				if(action == JOptionPane.OK_OPTION)
					System.exit(0);
			}	
		});
		return menuBar;
	}
	
}

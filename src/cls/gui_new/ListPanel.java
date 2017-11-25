package cls.gui_new;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class ListPanel extends JPanel {
	private JRadioButton pricebtn;
	private JRadioButton discountbtn;
	private JRadioButton expirePbtn;
	private JRadioButton unusedbtn;
	private JRadioButton redeemedbtn;
	
	private JLabel providerL;
	private JLabel prodNameL;
	private JLabel statusL;
	
	private JTextField providerF;
	private JTextField prodNameF;
	
	private JButton listbtn;

	
	private ButtonGroup group1;
	private RequestListener requestListener;
	private ListListener listListener;
	
	public ListPanel() {
		pricebtn = new JRadioButton("Price ");
		discountbtn = new JRadioButton("Discount");
		expirePbtn = new JRadioButton("Expire Period ");
		unusedbtn = new JRadioButton("Unused");
		redeemedbtn = new JRadioButton("Redeemed");
		
		listbtn = new JButton("LIST");
		
		group1 = new ButtonGroup();
		
		providerL = new JLabel("Provider List");
		prodNameL = new JLabel("Product Name List");
		statusL = new JLabel("Status List");
		
		providerF = new JTextField(10);
		prodNameF = new JTextField(10);
		
		providerL.setLabelFor(providerF);
		prodNameL.setLabelFor(prodNameF);
		
		unusedbtn.setActionCommand("unused");
		redeemedbtn.setActionCommand("redeemed");
		group1.add(discountbtn);
		group1.add(pricebtn);
		group1.add(expirePbtn);
		group1.add(unusedbtn);
		group1.add(redeemedbtn);
		
		listbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pricebtn.isSelected()) {
					RequestEvent rq = new RequestEvent(this,1);
					if(requestListener != null)
						requestListener.RequestEventOccured(rq);
				}
				else if(discountbtn.isSelected()) {
					RequestEvent rq = new RequestEvent(this,2);
					if(requestListener != null)
						requestListener.RequestEventOccured(rq);
				}
				else if(expirePbtn.isSelected()) {
					RequestEvent rq = new RequestEvent(this,3);
					if(requestListener != null)
						requestListener.RequestEventOccured(rq);
				}
				else;	
				
				//String provider = providerF.getText();
				//String prodName = prodNameF.getText();
				//String status = group1.getSelection().getActionCommand();
				//if(providerF.getText()!=null) {
					//ListEvent le = new ListEvent(this, providerF.getText(),4);
					//if(listListener != null) {
						//listListener.ListEventOccured(le);
					//}
				//}
				//else if(prodNameF.getText()!= null) {
					//ListEvent le = new ListEvent(this, prodNameF.getText(),5);
					//if(listListener != null) {
					//	listListener.ListEventOccured(le);
					//}
				//}
				//else if(group1.getSelection().getActionCommand()!=null) {
				//	ListEvent le = new ListEvent(this, group1.getSelection().getActionCommand(),6);
				//	if(listListener != null) {
				//		listListener.ListEventOccured(le);
				//	}
			//	}
			//	else;
			}
		});
				
		
		Border outerBorder = BorderFactory.createTitledBorder("List Coupon");
		Border innerBorder = BorderFactory.createEmptyBorder(6, 6, 6, 6);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		/////////////////First Row/////////////////////////////
		gc.gridy = 0;

		gc.weightx = 1;
		gc.weighty = 0.3;

		gc.gridx = 0;
		gc.insets = new Insets(0,0,0,5);
		gc.fill = GridBagConstraints.NONE;

		gc.anchor = GridBagConstraints.LINE_END;
		add(providerL,gc);

		gc.gridx = 1;
		gc.insets = new Insets(0,0,0,0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(providerF,gc);

		////////////Second Row////////////////////

		gc.gridy ++;

		gc.weightx = 1;
		gc.weighty = 0.3;

		gc.gridx = 0;
		gc.insets = new Insets(0,0,0,5);
		gc.anchor = GridBagConstraints.LINE_END;
		add(prodNameL,gc);

		gc.gridx = 1;
		gc.insets = new Insets(0,0,0,0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(prodNameF,gc);
	
		////////////Next Row///////////////////
		
		gc.gridy ++;
		
		gc.weightx = 1;
		gc.weighty = 0.3;

		gc.gridx = 0;
		gc.insets = new Insets(0,0,0,5);
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(pricebtn,gc);

	//gc.gridx = 1;
	//gc.anchor = GridBagConstraints.FIRST_LINE_START;
	//gc.insets = new Insets(0,0,0,0);
	//add(proPriceF,gc);
	
		////////////Next Row///////////////////
	
		gc.gridy ++;

		gc.weightx = 1;
		gc.weighty = 0.3;

		gc.gridx = 0;
		gc.insets = new Insets(0,0,0,5);
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(discountbtn,gc);

	//gc.gridx = 1;
	//gc.insets = new Insets(0,0,0,0);
	//gc.anchor = GridBagConstraints.FIRST_LINE_START;
	//add(dRateF,gc);	
	
	////////////Next Row///////////////////
	
		gc.gridy ++;

		gc.weightx = 1;
		gc.weighty = 0.3;

		gc.gridx = 0;
		gc.insets = new Insets(0,0,0,5);
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(expirePbtn,gc);

	//gc.gridx = 1;
	//gc.insets = new Insets(0,0,0,0);
	//gc.anchor = GridBagConstraints.FIRST_LINE_START;
	//add(expirePF,gc);	
	
		////////////Next Row///////////////////
	
		gc.gridy ++;

		gc.weightx = 1;
		gc.weighty = 0.05;
	
		gc.gridx = 0;
		gc.insets = new Insets(0,0,0,5);
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(statusL,gc);

		gc.gridx = 1;
		gc.insets = new Insets(0,0,0,0);
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(unusedbtn,gc);	

		////////////Next Row//////////////////

		gc.gridy ++;

		gc.weightx = 1;
		gc.weighty = 0.3;

		gc.gridx = 1;
		gc.insets = new Insets(0,0,0,0);
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(redeemedbtn,gc);	

		////////////Next Row///////////////////		

		gc.gridy ++;

		gc.weightx = 1;
		gc.weighty = 4.0;

		gc.gridx = 1;	
		gc.insets = new Insets(0,0,0,0);
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(listbtn,gc);
		
		Dimension dim = getPreferredSize();
		dim.width = 330;
		setPreferredSize(dim);
		}
		public void setListPanelListener(RequestListener listener) {
			this.requestListener = listener;
		}
		public void setListListener(ListListener listener) {
			this.listListener = listener;
		}
		
		
	}

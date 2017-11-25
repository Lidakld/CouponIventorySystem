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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;


public class AddPanel extends JPanel {
	private JLabel providerL;
	private JLabel proNameL;
	private JLabel proPriceL;
	private JLabel dRateL;
	private JLabel expirePL;
	private JLabel statusL;

	private JTextField providerF;
	private JTextField proNameF;
	private JTextField proPriceF;
	private JTextField dRateF;
	private JTextField expirePF;

	private JButton addbtn;
	private FormListener formListener;

	private JRadioButton unusedbtn;
	private JRadioButton redeemedbtn;
	private ButtonGroup group;

	public AddPanel() {
		providerL = new JLabel("Coupon Provider");
		proNameL = new JLabel("Product Name");
		proPriceL = new JLabel("Product Price");
		dRateL = new JLabel("Discount Rate");
		expirePL = new JLabel("Expire Period");
		statusL = new JLabel("Status");
		
		providerF = new JTextField(10);
		proNameF = new JTextField(10);
		proPriceF = new JTextField(10);
		dRateF = new JTextField(10);
		expirePF = new JTextField(10);
		
		addbtn = new JButton("ADD");
		unusedbtn = new JRadioButton("Unused");
		redeemedbtn = new JRadioButton("Redeemed");
		group = new ButtonGroup();
		
		providerL.setLabelFor(providerF);
		proNameL.setLabelFor(proNameF);
		proPriceL.setLabelFor(proPriceF);
		dRateL.setLabelFor(dRateF);
		expirePL.setLabelFor(expirePF);
		statusL.setLabelFor(statusL);
		
		unusedbtn.setActionCommand("unused");
		redeemedbtn.setActionCommand("redeemed");
		group.add(unusedbtn);
		group.add(redeemedbtn);
		
		addbtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				String provider = providerF.getText();
				String proName = proNameF.getText();
				String proPrice = proPriceF.getText();
				String dRate = dRateF.getText();
				String expirePeriod = expirePF.getText();
				String status;
				try {
					status  = group.getSelection().getActionCommand();
				} catch (Exception e2) {
					status = "unused";
				}
				try {
					provider = providerF.getText();
				}catch(Exception e2) {
					JOptionPane.showMessageDialog(AddPanel.this, "Please input correct provider name",
							"Input Error", JOptionPane.ERROR_MESSAGE);
				}
				
				try {
					proName = proNameF.getText();
				}catch(Exception e2) {
					JOptionPane.showMessageDialog(AddPanel.this, "Please input correct product name",
							"Input Error", JOptionPane.ERROR_MESSAGE);
				}
				
				try {
					float a = Float.parseFloat(proPrice);	
				}catch(NumberFormatException e2){
					JOptionPane.showMessageDialog(AddPanel.this, "Please input correct price(.00)", 
							"Input Error",JOptionPane.ERROR_MESSAGE);
				}
	
				try {
					float a = Float.parseFloat(dRate);
					System.out.println(dRate + " is a valid number");
				}catch(Exception e2) {
					System.out.println(dRate + " is not a valid number");
					JOptionPane.showMessageDialog(AddPanel.this, "Please input correct discount(.00)", 
							"Input Error",JOptionPane.ERROR_MESSAGE);
				}
			
					Float rate  = Float.parseFloat(dRate);
					if(rate > 0 && rate < 0.9) {
						float a = rate;
					}else {
						JOptionPane.showMessageDialog(AddPanel.this, "Please input correct discount(0<discount<0.9)", 
								"Input Error",JOptionPane.ERROR_MESSAGE);
						return;
					}
				
				
				try {
					int a = Integer.parseInt(expirePeriod);
		            System.out.println(expirePeriod + " is a valid integer number");

				}catch(Exception e2) {
					System.out.println(expirePeriod + " is not a valid integer number");
					JOptionPane.showMessageDialog(AddPanel.this, "Please input correct expirePeriod(int)", 
							"Input Error",JOptionPane.ERROR_MESSAGE);
				}
				
				FormEvent fe = new FormEvent(this,provider,proName,proPrice,dRate,expirePeriod,status);
				
				if(formListener != null) {
						formListener.FormEventsOccured(fe);
				}
			
			}
		});
		
		
		Border outerBorder = BorderFactory.createTitledBorder("Add Coupon");
		Border innerBorder = BorderFactory.createEmptyBorder(6, 6, 6, 6);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		
		layoutComponents();
	}

	///////////////// First Row/////////////////////////////
	public void layoutComponents() {

		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		gc.gridy = 0;

		gc.weightx = 1;
		gc.weighty = 0.1;

		gc.gridx = 0;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.fill = GridBagConstraints.NONE;

		gc.anchor = GridBagConstraints.LINE_END;
		add(providerL, gc);

		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(providerF, gc);

		//////////// Second Row////////////////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 0.1;

		gc.gridx = 0;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor = GridBagConstraints.LINE_END;
		add(proNameL, gc);

		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(proNameF, gc);

		//////////// Next Row///////////////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 0.2;

		gc.gridx = 0;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(proPriceL, gc);

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(proPriceF, gc);

		//////////// Next Row///////////////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 0.2;

		gc.gridx = 0;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(dRateL, gc);

		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(dRateF, gc);

		//////////// Next Row///////////////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 0.2;

		gc.gridx = 0;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(expirePL, gc);

		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(expirePF, gc);

		//////////// Next Row///////////////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 0.05;

		gc.gridx = 0;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(statusL, gc);

		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(unusedbtn, gc);

		//////////// Next Row//////////////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 0.2;

		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(redeemedbtn, gc);

		//////////// Next Row///////////////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 2.0;

		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(addbtn, gc);
	}

	public void setAddPanelListener(FormListener listener) {
		this.formListener = listener;
	}
}

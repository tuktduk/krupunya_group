package layout;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;

import data.*;
import process.DatabaseHandler;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JTable;

public class SellBilling {

	JFrame frame;
	
	JMenuBar menuBar = new JMenuBar();
	JMenu mnLanguage = new JMenu(language.mnLanguage);
	JMenuItem mntmEnglish = new JMenuItem(language.mntmEnglish);
	JMenuItem mntmThai = new JMenuItem(language.mntmThai);
	JLabel lbDate = new JLabel("Date");
	DefaultTableModel model = new DefaultTableModel();
	private JTextField textField_Name;
	private JTextField textField_Address;
	Object[] SecretNumber = new Object[] {"A","11","22","33","44","55","6","7","O","1","111","2","3","4","5","8","88","888","other"}; 
	JComboBox comboBox_SecretNumber = new JComboBox(SecretNumber);
	private JTextField textField_SecretNumber;
	private JTextField textField_Size;
	private JTextField textField_TotalWeight;
	private JTextField textField_Price;
	private JTable table;
	private JTextField textField_Phonenumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SellBilling window = new SellBilling();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SellBilling() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		frame = new JFrame();
		frame.setBounds(0, 0, 970, 950);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		setText();
		menuBar.setBounds(0, 0, screenSize.width, 30);
		menuBar.add(mnLanguage);
		mnLanguage.add(mntmEnglish);
		mntmEnglish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				language.getEng();
				setText();
			}
		});
		mnLanguage.add(mntmThai);
		mntmThai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				language.getThai();
				setText();
			}
		});
		
		frame.getContentPane().add(menuBar);
		
		Dimension windowSize = frame.getSize();
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 31, windowSize.width-20, 1500);
		panel.setPreferredSize(new Dimension(windowSize.width-20,1500));
		
		JScrollPane scrollPane = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		panel.setLayout(null);
		
		JLabel SellBilling = new JLabel("Sell Billing");
		SellBilling.setHorizontalAlignment(SwingConstants.CENTER);
		SellBilling.setBounds(435, 30, 100, 30);
		panel.add(SellBilling);
		
		lbDate.setHorizontalAlignment(SwingConstants.CENTER);
		lbDate.setBounds(800, 20, 100, 20);
		panel.add(lbDate);
		
		JLabel lbMember = new JLabel("Member");
		lbMember.setHorizontalAlignment(SwingConstants.CENTER);
		lbMember.setBounds(50, 100, 100, 20);
		panel.add(lbMember);
		
		JLabel lbStatus = new JLabel("status");
		lbStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lbStatus.setBounds(300, 100, 100, 20);
		panel.add(lbStatus);
		
		JLabel lbCustomerName = new JLabel("Name");
		lbCustomerName.setHorizontalAlignment(SwingConstants.CENTER);
		lbCustomerName.setBounds(50, 150, 100, 20);
		panel.add(lbCustomerName);
		
		JLabel lbType = new JLabel("Type");
		lbType.setHorizontalAlignment(SwingConstants.CENTER);
		lbType.setBounds(550, 100, 100, 20);
		panel.add(lbType);
		
		JLabel lbPhoneNumber = new JLabel("Phone number");
		lbPhoneNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lbPhoneNumber.setBounds(550, 150, 100, 20);
		panel.add(lbPhoneNumber);
		
		JLabel lbAddress = new JLabel("Address");
		lbAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lbAddress.setBounds(300, 150, 100, 20);
		panel.add(lbAddress);
		
		JComboBox comboBox_Member = new JComboBox();
		comboBox_Member.setBounds(150, 100, 100, 20);
		comboBox_Member.addItem("-");
		comboBox_Member.addItem("...");
		panel.add(comboBox_Member);
		
		JComboBox comboBox_Status = new JComboBox();
		comboBox_Status.setBounds(400, 100, 100, 20);
		comboBox_Status.addItem("paid");
		comboBox_Status.addItem( "pending");
		panel.add(comboBox_Status);
		
		textField_Name = new JTextField();
		textField_Name.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Name.setBounds(150, 150, 100, 20);
		panel.add(textField_Name);
		textField_Name.setColumns(10);
		
		JComboBox comboBox_Type = new JComboBox();
		comboBox_Type.setBounds(650, 100, 100, 20);
		comboBox_Type.addItem("white shrimp");
		comboBox_Type.addItem("Lobster");
		panel.add(comboBox_Type);
		
		textField_Phonenumber = new JTextField();
		textField_Phonenumber.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Phonenumber.setBounds(650, 150, 100, 20);
		panel.add(textField_Phonenumber);
		textField_Phonenumber.setColumns(10);
		
		textField_Address = new JTextField();
		textField_Address.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Address.setBounds(400, 150, 100, 20);
		panel.add(textField_Address);
		textField_Address.setColumns(10);
		
		JButton btnFinishBilling = new JButton("Finish billing");
		btnFinishBilling.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Sellbill sellbill = new Sellbill(); 
				sellbill.id = "UNSAVE";
				sellbill.name = textField_Name.getText();
				sellbill.address = textField_Address.getText();
				sellbill.phone_number = textField_Phonenumber.getText();
				sellbill.issue_date = dateIn.year+dateIn.month+dateIn.day;
				sellbill.product_type = comboBox_Type.getSelectedItem().toString();
				
				//push product to the bill
				for (int count = 0; count < model.getRowCount(); count++){
					Product ptemp = new Product();
					ptemp.secret_number=model.getValueAt(count, 0).toString();
					ptemp.size=Integer.parseInt(model.getValueAt(count, 1).toString());
					ptemp.weight=Double.parseDouble(model.getValueAt(count, 2).toString());
					ptemp.price=Double.parseDouble(model.getValueAt(count, 3).toString());
		            sellbill.product.add(ptemp);
		        }
				
				if(comboBox_Status.getSelectedItem().toString() == "paid")
					{sellbill.status = true;sellbill.paid_date = sellbill.issue_date;}
				else
					{sellbill.status = false;sellbill.paid_date = null;BillCollections.pending_sellbill.add(sellbill);}
				
				BillCollections.sellbill.add(sellbill);
				DatabaseHandler.PushData();
				General.fetchData();
				frame.setVisible(false);
				
			}
		});
		btnFinishBilling.setBounds(700, 900, 200, 60);
		panel.add(btnFinishBilling);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(50, 250, 850, 160);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String 	c1="",
						c2=textField_Size.getText(),
						c3=textField_TotalWeight.getText(),
						c4=textField_Price.getText();
				if(comboBox_SecretNumber.getSelectedItem().toString()=="other")
					c1=textField_SecretNumber.getText();
				else
					c1=comboBox_SecretNumber.getSelectedItem().toString();
				model.addRow(new Object[]{c1,c2,c3,c4});
			
			}
		});
		btnSubmit.setBounds(720, 110, 100, 30);
		panel_1.add(btnSubmit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int numRows = table.getSelectedRows().length;
				for(int i=0; i<numRows ; i++ ) {

					model.removeRow(table.getSelectedRow());
				}
				/*for (int count = 0; count < model.getRowCount(); count++){		//check object
					System.out.println(model.getValueAt(count, 0).toString());
		        }*/
			}
		});
		btnDelete.setBounds(600, 110, 100, 30);
		panel_1.add(btnDelete);
		
		comboBox_SecretNumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBox_SecretNumber.getSelectedItem().toString()=="other")
					textField_SecretNumber.setVisible(true);
				else
					textField_SecretNumber.setVisible(false);
			}
		});
		comboBox_SecretNumber.setBounds(50, 75, 100, 20);
		
		panel_1.add(comboBox_SecretNumber);
		
		textField_SecretNumber = new JTextField();
		textField_SecretNumber.setHorizontalAlignment(SwingConstants.CENTER);
		textField_SecretNumber.setBounds(50, 100, 100, 20);
		textField_SecretNumber.setVisible(false);
		panel_1.add(textField_SecretNumber);
		textField_SecretNumber.setColumns(10);
		
		textField_Size = new JTextField();
		textField_Size.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Size.setBounds(200, 75, 100, 20);
		panel_1.add(textField_Size);
		textField_Size.setColumns(10);
		
		textField_TotalWeight = new JTextField();
		textField_TotalWeight.setHorizontalAlignment(SwingConstants.CENTER);
		textField_TotalWeight.setBounds(350, 75, 100, 20);
		panel_1.add(textField_TotalWeight);
		textField_TotalWeight.setColumns(10);
		
		textField_Price = new JTextField();
		textField_Price.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Price.setBounds(500, 75, 100, 20);
		panel_1.add(textField_Price);
		textField_Price.setColumns(10);
		
		JLabel lbSecretNumber = new JLabel("Secret number");
		lbSecretNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lbSecretNumber.setBounds(50, 50, 100, 20);
		panel_1.add(lbSecretNumber);
		
		JLabel lbSize = new JLabel("Size");
		lbSize.setHorizontalAlignment(SwingConstants.CENTER);
		lbSize.setBounds(200, 50, 100, 20);
		panel_1.add(lbSize);
		
		JLabel lbTotalWeight = new JLabel("Total weight");
		lbTotalWeight.setHorizontalAlignment(SwingConstants.CENTER);
		lbTotalWeight.setBounds(350, 50, 100, 20);
		panel_1.add(lbTotalWeight);
		
		JLabel lbPrice = new JLabel("Price per kg");
		lbPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lbPrice.setBounds(500, 50, 100, 20);
		panel_1.add(lbPrice);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setPreferredScrollableViewportSize(new Dimension(850,400));
		table.setBounds(50, 450, 850, 400);
		table.setModel(model);
        model.addColumn("Secret number");
        model.addColumn("Size");
        model.addColumn("Total weight");
        model.addColumn("Price per kg");
        JScrollPane table_sp = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        table_sp.setBounds(50, 450, 850, 400);
        table_sp.setVisible(true);
		panel.add(table_sp);
		
		scrollPane.setBounds(0, 31, windowSize.width-20, windowSize.height-70);
		frame.getContentPane().add(scrollPane);
	}
	
	private void setText() {
		mnLanguage.setText(language.mnLanguage);
		mntmEnglish.setText(language.mntmEnglish);
		mntmThai.setText(language.mntmThai);
		lbDate.setText(language.lbdate);
		
	}
}

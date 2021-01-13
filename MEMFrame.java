import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.html.HTMLDocument.Iterator;

public class MEMFrame extends JFrame implements ListSelectionListener{
	
	private final int FRAME_HEIGHT=800;
	private final int FRAME_WIDTH=800;
	
	JLabel nameLabel;
	JLabel surnameLabel;
	JLabel phoneNumberLabel;
	JLabel emailLabel;
	JLabel addrLabel;
	JLabel postalCodeLabel;
	JLabel sendEmailLabel;
	JLabel toEmailLabel;
	
	JTextField nameText;
	JTextField surnameText;
	JTextField phoneNumberText;
	JTextField emailText;
	JTextField addrText;
	JTextField postalCodeText;
	JTextField sendEmailText;
	JTextField toEmailText;
	
	JButton addMemberButton;
	JButton deleteMemberButton;
	JButton checkStandingButton;
	JButton missedPaymentButton;
	JButton sendButton;
	
	JLabel yearLabel;
	JLabel dateLabel;
	JLabel revenueLabel;
	JLabel expensesLabel;
	JLabel resultsLabel;
	JLabel januaryLabel;
	JLabel febuaryLabel;
	JLabel marchLabel;
	JLabel aprilLabel;
	JLabel mayLabel;
	JLabel juneLabel;
	JLabel julyLabel;
	JLabel augustLabel;
	JLabel septemberLabel;
	JLabel octoberLabel;
	JLabel novemberLabel;
	JLabel decemberLabel;
	
	int[] yearList = new int[12];
	
	JButton createStatementButton;
	
	JTextField dateText;
	JTextField revenueText;
	JTextField expensesText;
	
	
	JComboBox listOptionsComboBox;
	
	
	
	ArrayList<Members> members;
	private JList list;
	private DefaultListModel listModel;
	private DefaultListModel listModel2;
	
	public MEMFrame()
	{
		setSize(FRAME_WIDTH,FRAME_HEIGHT);
		setLayout(new GridLayout(2,2));
		setResizable(true);
		
		
		members = new ArrayList<Members>();
		listModel = new DefaultListModel();
		listModel2 = new DefaultListModel();
		list = new JList(listModel);
		list.addListSelectionListener(this);
		 
		sendMessagePanel();
		memberListView();
		incomeStatementSubPanel();
		addMemberSubPanel();
	}
	
	private void sendMessagePanel() {
		JPanel addMsg = new JPanel(new BorderLayout());
		
		JPanel innerPan = new JPanel(new GridLayout(1,1));
		toEmailLabel = new JLabel("Gym membership owner program");
		toEmailLabel.setFont(new Font("Serif", Font.PLAIN, 24));
		innerPan.add(toEmailLabel);

		

		
		addMsg.add(innerPan, BorderLayout.CENTER);

		add(addMsg);
		
		
	}
	
	private void addMemberSubPanel() {
		JPanel addMemberPanel=new JPanel();
		addMemberPanel.setLayout(new GridLayout(7,1));
		addMemberPanel.setBorder(new TitledBorder(new EtchedBorder(), "Add Member"));
		
		JPanel namePanel=new JPanel(new BorderLayout());
		nameLabel = new JLabel("Name");
		namePanel.add(nameLabel, BorderLayout.NORTH);
		nameText = new JTextField();
		nameText.setColumns(20);
		namePanel.add(nameText, BorderLayout.SOUTH);
		
		JPanel surnamePanel = new JPanel(new BorderLayout());
		surnameLabel = new JLabel("Surname");
		surnamePanel.add(surnameLabel,BorderLayout.NORTH);
		surnameText = new JTextField();
		surnameText.setColumns(10);
		surnamePanel.add(surnameText, BorderLayout.SOUTH);
		
		JPanel phoneNumberPanel = new JPanel(new BorderLayout());		
		phoneNumberLabel = new JLabel("Phone Number");
		phoneNumberPanel.add(phoneNumberLabel,BorderLayout.NORTH);
		phoneNumberText = new JTextField();
		phoneNumberText.setColumns(10);
		phoneNumberPanel.add(phoneNumberText, BorderLayout.SOUTH);
		
		JPanel emailPanel = new JPanel(new BorderLayout());		
	    emailLabel = new JLabel("Email");
		emailPanel.add(emailLabel,BorderLayout.NORTH);
		emailText = new JTextField();
		emailText.setColumns(10);
		emailPanel.add(emailText, BorderLayout.SOUTH);
		
		JPanel addrsPanel = new JPanel(new BorderLayout());
		addrLabel = new JLabel("Address");
		addrsPanel.add(addrLabel,BorderLayout.NORTH);
		addrText = new JTextField();
		addrText.setColumns(10);
		addrsPanel.add(addrText, BorderLayout.SOUTH);
		
		JPanel postalCodePanel = new JPanel(new BorderLayout());
		postalCodeLabel = new JLabel("Postal code");
		postalCodePanel.add(postalCodeLabel,BorderLayout.NORTH);
		postalCodeText = new JTextField();
		postalCodeText.setColumns(10);
		postalCodePanel.add(postalCodeText, BorderLayout.SOUTH);
		
		JPanel buttonPanel = new JPanel(new BorderLayout());
		addMemberButton = new JButton("Add Member");
		addMemberButton.addActionListener(new CreateMember());
		buttonPanel.add(addMemberButton, BorderLayout.SOUTH);
		
		addMemberPanel.add(namePanel);
		addMemberPanel.add(surnamePanel);
		addMemberPanel.add(phoneNumberPanel);
		addMemberPanel.add(emailPanel);
		addMemberPanel.add(addrsPanel);
		addMemberPanel.add(postalCodePanel);
		addMemberPanel.add(buttonPanel);
		add(addMemberPanel);
	}
	
	class CreateMember implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e) 
			{				
				Members currentMember;
				currentMember = createMember(nameText.getText(),surnameText.getText(),phoneNumberText.getText(),emailText.getText(),addrText.getText(), postalCodeText.getText());
				listModel.addElement(currentMember);
				members.add(currentMember);
				deleteMemberButton.setEnabled(true);
				
			}

		
	}
	
	public Members createMember(String name, String surname, String phoneNumber, String email, String address, String postalCode)
	{
				Members currentAddedMember = new Members(name, surname, phoneNumber,email,address,postalCode);
				return currentAddedMember;
				//members.sort(null);	
				
				
				
	
	}
	
	private void memberListView() {
		
		JPanel memberListPanel = new JPanel(new BorderLayout());
		
		JPanel topLayout = new JPanel();
		listOptionsComboBox = new JComboBox();
		listOptionsComboBox.addItem("All Members");
		listOptionsComboBox.addItem("Good Standing");
		listOptionsComboBox.addItem("Missed Payment");
		listOptionsComboBox.addItemListener(new changeList());
		topLayout.add(listOptionsComboBox);
		memberListPanel.add(topLayout, BorderLayout.NORTH);
		
		JPanel memberListButtonsPanel = new JPanel(new GridLayout(3, 1));
		deleteMemberButton = new JButton("Delete Member");
		deleteMemberButton.setEnabled(false);
		deleteMemberButton.addActionListener(new deleteMember());
		checkStandingButton = new JButton("Check Standing");
		checkStandingButton.addActionListener(new checkStanding());
		missedPaymentButton = new JButton("Missed Payment");
		missedPaymentButton.addActionListener(new memberMissedPayment());
		memberListButtonsPanel.add(deleteMemberButton);
		memberListButtonsPanel.add(checkStandingButton);
		memberListButtonsPanel.add(missedPaymentButton);
		memberListPanel.add(memberListButtonsPanel, BorderLayout.EAST);
		
		//memberListPanel.add(memberListButtonsPanel, BorderLayout.SOUTH);
		
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setVisibleRowCount(-1);
		JScrollPane listScroller = new JScrollPane(list);
		listScroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		listScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		memberListPanel.add(listScroller, BorderLayout.CENTER);
		add(memberListPanel);
		
	}
	
	class changeList implements ItemListener
	{
		

		@Override
		public void itemStateChanged(ItemEvent arg0) {
			// TODO Auto-generated method stub
			if(listOptionsComboBox.getSelectedIndex() == 2) listChangedUnpaid();
			if(listOptionsComboBox.getSelectedIndex() == 1) listChangedPaid();
			if(listOptionsComboBox.getSelectedIndex() == 0) {
				list.setModel(listModel);
			}
		}

		
	}

	
	private void listChangedUnpaid() {
		listModel2.clear();
		Members currentMem;
		for (int i = 0; i < members.size(); i++) {
			currentMem = members.get(i);
			
			if (currentMem.getNumberOfMissedPayments() > 0 ) {
				listModel2.addElement(currentMem);
			}
		}
		
		list.setModel(listModel2);
	}
	
	private void listChangedPaid() {
		listModel2.clear();
		Members currentMem;
		for (int i = 0; i < members.size(); i++) {
			currentMem = members.get(i);
			
			if (currentMem.getNumberOfMissedPayments() == 0 ) {
				listModel2.addElement(currentMem);
			}
		}
		
		list.setModel(listModel2);
	}
	
	class deleteMember implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e) 
			{				
			
			int index = list.getSelectedIndex();
			listModel.removeElementAt(index);
			members.remove(index);
				
				if (listModel.isEmpty()) deleteMemberButton.setEnabled(false);
				
			}

		
	}
	
	class checkStanding implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e) 
			{				
			
			int index = list.getSelectedIndex();
			
			Members memberStanding = (Members) list.getModel().getElementAt(index);
				
				if (memberStanding.getNumberOfMissedPayments() > 0) {
					checkStandingButton.setBackground(Color.RED);
				} else {
					checkStandingButton.setBackground(Color.GREEN);
				}
				
			}

		
	}
	
	class memberMissedPayment implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e) 
			{				
			
			int index = list.getSelectedIndex();
			
			Members memberStanding = (Members) list.getModel().getElementAt(index);
				
			memberStanding.memberMissedPayment();
				
			}

		
	}
	
	
	//Creates the GUI for the income statement
		private void incomeStatementSubPanel() {
			JPanel incomeStatementPanel = new JPanel();
			incomeStatementPanel.setLayout(new GridLayout(2,1));
			incomeStatementPanel.setBorder(new TitledBorder(new EtchedBorder(), "Check/Manage finances"));
			
			//Creates two sub panels that help with formatting/sizing
			//topPanel handles entered user input and buttons (+ years profit / debt)
			//bottomPanel handles the JList that displays the months profit/debt
			JPanel topPanel = new JPanel();
			topPanel.setLayout(new GridLayout(5,1));
			JPanel bottomPanel = new JPanel();
			bottomPanel.setLayout(new GridLayout(6,2));
			
			//Creates the panel that allows the user to enter the desired month
			JPanel datePanel = new JPanel(new BorderLayout());
			dateLabel = new JLabel("Date MM");
			datePanel.add(dateLabel, BorderLayout.NORTH);
			dateText = new JTextField();
			dateText.setColumns(2);
			datePanel.add(dateText, BorderLayout.SOUTH);
			
			//Creates the panel that allows the user to enter the total monthly revenue
			JPanel revenuePanel = new JPanel(new BorderLayout());
			revenueLabel = new JLabel("Revenue:");
			revenuePanel.add(revenueLabel, BorderLayout.NORTH);
			revenueText = new JTextField();
			revenueText.setColumns(8);
			revenuePanel.add(revenueText, BorderLayout.SOUTH);
			
			//Creates the panel that allows the user to enter the total monthly expenses
			JPanel expensesPanel = new JPanel(new BorderLayout());
			expensesLabel = new JLabel("Expenses:");
			expensesPanel.add(expensesLabel, BorderLayout.NORTH);
			expensesText = new JTextField();
			expensesText.setColumns(8);
			expensesPanel.add(expensesText, BorderLayout.SOUTH);
			
			//Creates the panel that holds the create income statement button
			JPanel incomeButtonPanel = new JPanel(new BorderLayout());
			createStatementButton = new JButton("Create monthly income statement");
			createStatementButton.addActionListener(new CreateIncomeStatement());
			incomeButtonPanel.add(createStatementButton, BorderLayout.SOUTH);
			
			//Creates the basic labels that will display the profit/debt for each month
			januaryLabel = new JLabel("January: ");
			febuaryLabel = new JLabel("Febuary: ");
			marchLabel = new JLabel("March: ");
			aprilLabel = new JLabel("April: ");
			mayLabel = new JLabel("May: ");
			juneLabel = new JLabel("June: ");
			julyLabel = new JLabel("July: ");
			augustLabel = new JLabel("August: ");
			septemberLabel = new JLabel("September: ");
			octoberLabel = new JLabel("October: ");
			novemberLabel = new JLabel("November: ");
			decemberLabel = new JLabel("December: ");
			
			yearLabel = new JLabel("Years Proft / Debt:   $");

			//Adds all the sub panels
			topPanel.add(datePanel);
			topPanel.add(revenuePanel);
			topPanel.add(expensesPanel);
			topPanel.add(incomeButtonPanel);
			topPanel.add(yearLabel);
			bottomPanel.add(januaryLabel);
			bottomPanel.add(febuaryLabel);
			bottomPanel.add(marchLabel);
			bottomPanel.add(aprilLabel);
			bottomPanel.add(mayLabel);
			bottomPanel.add(juneLabel);
			bottomPanel.add(julyLabel);
			bottomPanel.add(augustLabel);
			bottomPanel.add(septemberLabel);
			bottomPanel.add(octoberLabel);
			bottomPanel.add(novemberLabel);
			bottomPanel.add(decemberLabel);
			incomeStatementPanel.add(topPanel);
			incomeStatementPanel.add(bottomPanel);
			add(incomeStatementPanel);
			
		}
		
		class CreateIncomeStatement implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				try
				{
					//Some local variables used to display value and convert from int-string and vice versa
					int date;
					int revenue;
					int expenses;
					int net;
					int yearProfitDebt = 0;
					String temp;
					
					//Assigns entered values with variables
					date = Integer.parseInt(dateText.getText());
					revenue = Integer.parseInt(revenueText.getText());
					expenses = Integer.parseInt(expensesText.getText());
					net = (revenue-expenses);
					
					
					//Displays the correct (revenue - expenses) value next to the corresponding month and adds the value to yearList
					//////////////////////////////////////////////////////////////////////
					if(date==1) {
						temp = januaryLabel.getText();

						yearList[date-1] = net;
						
						temp = "January: $" + Integer.toString(net);
						januaryLabel.setText(temp);
					}
					
					if(date==2) {
						temp = febuaryLabel.getText();
						
						yearList[date-1] = net;
						
						temp = "Febuary: $" + Integer.toString(net);
						febuaryLabel.setText(temp);
					}
					
					if(date==3) {
						temp = marchLabel.getText();
						
						yearList[date-1] = net;
						
						temp = "March: $" + Integer.toString(net);
						marchLabel.setText(temp);
					}
					
					if(date==4) {
						temp = aprilLabel.getText();
						
						yearList[date-1] = net;
						
						temp = "April: $" + Integer.toString(net);
						aprilLabel.setText(temp);
					}
					
					if(date==5) {
						temp = mayLabel.getText();
						
						yearList[date-1] = net;
						
						temp = "May: $"+ Integer.toString(net);
						mayLabel.setText(temp);
					}
					
					if(date==6) {
						temp = juneLabel.getText();
						
						yearList[date-1] = net;
						
						temp = "June: $" + Integer.toString(net);
						juneLabel.setText(temp);
					}
					
					if(date==7) {
						temp = julyLabel.getText();
						
						yearList[date-1] = net;
						
						temp = "July: $" + Integer.toString(net);
						julyLabel.setText(temp);
					}
					
					if(date==8) {
						temp = augustLabel.getText();
						
						yearList[date-1] = net;
						
						temp = "August: $" + Integer.toString(net);
						augustLabel.setText(temp);
					}
					
					if(date==9) {
						temp = septemberLabel.getText();
						
						yearList[date-1] = net;
						
						temp = "September: $" + Integer.toString(net);
						septemberLabel.setText(temp);
					}
					
					if(date==10) {
						temp = octoberLabel.getText();
						
						yearList[date-1] = net;
						
						temp = "October: $" + Integer.toString(net);
						octoberLabel.setText(temp);
					}
					
					if(date==11) {
						temp = novemberLabel.getText();
						
						yearList[date-1] = net;
						
						temp = "November: $" + Integer.toString(net);
						novemberLabel.setText(temp);
					}
					
					if(date==12) {
						temp = decemberLabel.getText();	
						
						yearList[date-1] = net;
						
						temp = "Decmber: $" + Integer.toString(net);
						decemberLabel.setText(temp);
					}
					//////////////////////////////////////////////////////////////////////
					if(date>12) {
						System.out.println("Invalid input: Please use any month from 01 to 12");
					}
					
					
					//Totals all the values for each month and stores the total + or - int yearProfitDebt variable
					for(int i=0;i<12;i++) {
						yearProfitDebt += yearList[i];
					}
					
					//Checks if the years total is profit(+) or debt(-)
					//Updates the labels to display the total
					if(yearProfitDebt >= 0) {
						temp = "Yearly Profit:   $" + Integer.toString(yearProfitDebt);
						yearLabel.setText(temp);
					}
					if(yearProfitDebt < 0) {
						temp = "Yearly Debt:     $" + Integer.toString(yearProfitDebt);
						yearLabel.setText(temp);
					}
					
					
				}
				catch (NumberFormatException except)
				{
					System.out.println("Date or revenue/expenses input is invalid");
				}
			}
		}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		checkStandingButton.setBackground(null);
	}
	


}

/*Author: Aaron Bermingham
Student number: C17738539*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.MaskFormatter;

import net.miginfocom.swing.MigLayout;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

public class HouseApplication extends JFrame implements ActionListener {

    ArrayList<House> houseList = new ArrayList<House>();
    String[][] records = { { "113 The Maltings", "Dublin 8", "2", "1", "155500.00", "House1.jpg", "(087) 9011135" },
	    { "78 Newington Lodge", "Dublin 14", "3", "2", "310000.00", "House2.jpg", "(087) 9010580" },
	    { "62 Bohernabreena Road", "Dublin 24", "3", "1", "220000.00", "House3.jpg", "(087) 6023159" },
	    { "18 Castledevitt Park", "Dublin 15", "3", "3", "325000.00", "House4.jpg", "(087) 9010580" },
	    { "40 Dunsawny Road", "Swords", "3", "19", "245000.00", "House5.jpg", "(087) 9011135" } };
    // Variable to keep track of the current house being viewed
    int currentItem;
    // Variable to keep count number of times the edit button is clicked
    int num = 0;
    //
    HouseSummaryDialog houseSummaryDialog;
    CreateHouseDialog createHouseDialog;

    // Panels
    private JPanel parentPanel = new JPanel(new BorderLayout());
    private JPanel pnlTop = new JPanel(new MigLayout("wrap 2"));
    private JPanel pnlBtn = new JPanel(new GridLayout(1, 5));
    private JPanel pnlBottom = new JPanel(new FlowLayout());
    // Labels
    private Icon house = new ImageIcon();
    private JLabel lblPic = new JLabel(house);
    private JLabel lblID = new JLabel("House ID: ");
    private JLabel lblAddrss1 = new JLabel("Addresss Line 1: ");
    private JLabel lblAddrss2 = new JLabel("Address Line 2: ");
    private JLabel lblBedrms = new JLabel("Number of bedrooms:");
    private JLabel lblBathrms = new JLabel("Number of bathrooms:");
    private JLabel lblPrice = new JLabel("Price:");
    private JLabel lblPriceChng = new JLabel("Price Change");
    private JLabel lblPNum = new JLabel("Contact Number:");
    // TextFields
    private JTextField txtID = new JTextField(20);
    private JTextField txtAddrss1 = new JTextField(20);
    private JTextField txtAddrss2 = new JTextField(20);
    private JTextField txtBedrms = new JTextField(20);
    private JTextField txtBathrms = new JTextField(20);
    // private JFormattedTextField txtPrice = new JFormattedTextField(new
    // DecimalFormat("€###,###"));
    private JTextField txtPrice = new JTextField(20);
    private JTextField txtPriceChng = new JTextField(20);
    private JTextField txtPNum = new JTextField(20);
    // private JFormattedTextField txtPNum = new JFormattedTextField(new
    // MaskFormatter("(###) ### ####"));

    // Button icons
    private Icon first = new ImageIcon("first.png");
    private Icon last = new ImageIcon("last.png");
    private Icon next = new ImageIcon("next.png");
    private Icon prev = new ImageIcon("prev.png");
    // Buttons
    private JButton btnFirst = new JButton(first);
    private JButton btnPrev = new JButton(prev);
    private JButton btnEdit = new JButton("Edit");
    private JButton btnNext = new JButton(next);
    private JButton btnLast = new JButton(last);
    // Menu
    private JMenu display = new JMenu("Display");
    private JMenuItem mFirst = new JMenuItem("First");
    private JMenuItem mPrev = new JMenuItem("Previous");
    private JMenuItem mEdit = new JMenuItem("Edit");
    private JMenuItem mNext = new JMenuItem("Next");
    private JMenuItem mLast = new JMenuItem("Last");
    private JMenu modify = new JMenu("Modify");
    private JMenuItem create = new JMenuItem("Create");
    private JMenuItem delete = new JMenuItem("Delete");
    private JMenu report = new JMenu("Reports");
    private JMenuItem search = new JMenuItem("Search");
    private JMenuItem summary = new JMenuItem("Summary report");
    private JMenu close = new JMenu("Close");
    private JMenuItem exit = new JMenuItem("Exit");
    private JMenuBar bar = new JMenuBar();

    public HouseApplication() {
	super("Estate Agent Application");
	// Transform the array of data into Houses on the ArrayList
	for (int i = 0; i < records.length; i++) {
	    houseList.add(new House(records[i][0], records[i][1], Integer.parseInt(records[i][2]),
		    Integer.parseInt(records[i][3]), Double.parseDouble(records[i][4]), records[i][5], records[i][6]));
	}

	initComponents();
	displayDetails(0);
    }

    public void initComponents() {

	// Add menu items to menu
	display.add(mFirst);
	display.add(mPrev);
	display.add(mEdit);
	display.add(mNext);
	display.add(mLast);
	modify.add(create);
	modify.add(delete);
	report.add(search);
	report.add(summary);
	close.add(exit);
	// Adding menu headings to menu bar
	bar.add(display);
	bar.add(report);
	bar.add(modify);
	bar.add(close);
	setJMenuBar(bar);
	// Adding components to panel
	pnlTop.add(lblPic, "wrap, dock north, gapbottom 30, pushx, growx,pushy,growy, span 2");
	pnlTop.add(lblID);
	pnlTop.add(txtID, "pushx, growx");
	txtID.setEditable(false);
	pnlTop.add(lblAddrss1);
	pnlTop.add(txtAddrss1, "pushx, growx");
	txtAddrss1.setEditable(false);
	pnlTop.add(lblAddrss2);
	pnlTop.add(txtAddrss2, "pushx, growx");
	txtAddrss2.setEditable(false);
	pnlTop.add(lblBedrms);
	pnlTop.add(txtBedrms, "pushx, growx");
	txtBedrms.setEditable(false);
	pnlTop.add(lblBathrms);
	pnlTop.add(txtBathrms, "pushx, growx");
	txtBathrms.setEditable(false);
	pnlTop.add(lblPrice);
	pnlTop.add(txtPrice, "pushx, growx");
	txtPrice.setEditable(false);
	pnlTop.add(lblPriceChng);
	pnlTop.add(txtPriceChng, "pushx, growx");
	txtPriceChng.setEditable(false);
	pnlTop.add(lblPNum);
	pnlTop.add(txtPNum, "pushx, growx, gapbottom 30");
	txtPNum.setEditable(false);
	// Add buttons
	pnlBtn.add(btnFirst);
	pnlBtn.add(btnPrev);
	pnlBtn.add(btnEdit);
	pnlBtn.add(btnNext);
	pnlBtn.add(btnLast);
	pnlBottom.add(pnlBtn);
	// Action Listeners
	btnNext.addActionListener(this);
	btnPrev.addActionListener(this);
	btnFirst.addActionListener(this);
	btnLast.addActionListener(this);
	btnEdit.addActionListener(this);
	create.addActionListener(this);
	delete.addActionListener(this);
	search.addActionListener(this);
	summary.addActionListener(this);
	report.addActionListener(this);
	modify.addActionListener(this);
	exit.addActionListener(this);

	// Add panels to parent panel
	parentPanel.add(pnlTop, BorderLayout.CENTER);
	parentPanel.add(pnlBottom, BorderLayout.SOUTH);
	add(parentPanel);
	setSize(500, 630);
	setVisible(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /*
     * Method to display house details in textfields and labels index passed in as a
     * parameter to show which element of the arraylist should be displayed
     * Used info from this link for this method
     * https://www.youtube.com/watch?v=WkPWPuGHTTI
     */
    public void displayDetails(int index) {
	String pic = houseList.get(index).getImageLocation();
	Icon image = new ImageIcon(pic);
	lblPic.setIcon(image);
	txtID.setText(String.valueOf(houseList.get(index).getId()));
	txtAddrss1.setText(houseList.get(index).getStreet());
	txtAddrss2.setText(houseList.get(index).getCity());
	txtBedrms.setText(String.valueOf(houseList.get(index).getBedrooms()));
	txtBathrms.setText(String.valueOf(houseList.get(index).getBedrooms()));
	txtPrice.setText(String.valueOf(houseList.get(index).getPrice()));
	txtPriceChng.setText(String.valueOf(houseList.get(index).getChange()));
	txtPNum.setText(String.valueOf(houseList.get(index).getContactNo()));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	/*Next button iterates through arraylist one at a time
	  Used info from this link for to move through list, ie next,first,last,previous
	  https://www.youtube.com/watch?v=WkPWPuGHTTI*/	
	if (e.getSource() == btnNext) {
	    currentItem++; // increment current item each time the button is pressed
	    if (currentItem < houseList.size()) {
		displayDetails(currentItem); // Passes current item to displayDetails method
		txtPrice.setEditable(false); // When next is clicked, edit button is reset
		btnEdit.setText("Edit"); // When next is clicked, edit button text is reset
		num = 0; // Set num to zero, edit button has a counter
	    } else {
		currentItem = houseList.size() - 1; // If the current item is the last item
		displayDetails(currentItem); // Passes current item to displayDetails method
		JOptionPane.showMessageDialog(null, "This is the last house in the list"); // Message displayed to show it is the last in the list
		txtPrice.setEditable(false);
		btnEdit.setText("Edit");
		num = 0;
	    }

	} else if (e.getSource() == btnFirst) {
	    currentItem = 0; // Sets current item to 0, i.e. the first element
	    displayDetails(currentItem); // Passes current item to displayDetails method
	    txtPrice.setEditable(false);
	    btnEdit.setText("Edit");
	    num = 0;
	} else if (e.getSource() == btnLast) {
	    currentItem = houseList.size() - 1; // Set current item to the last item in the list
	    displayDetails(currentItem); // Passes current item to displayDetails method
	    txtPrice.setEditable(false);
	    btnEdit.setText("Edit");
	    num = 0;
	} else if (e.getSource() == btnPrev) {
	    currentItem--; // decrement current item each time the button is pressed
	    txtPrice.setEditable(false);
	    if (currentItem > 0) { // Ensure current item is greater than 0
		displayDetails(currentItem); // Passes current item to displayDetails method
		txtPrice.setEditable(false);
		btnEdit.setText("Edit");
		num = 0;
	    } else { // When the current item is zero
		currentItem = 0;
		displayDetails(currentItem);
		JOptionPane.showMessageDialog(null, "This is the first house in the list");
		txtPrice.setEditable(false);
		btnEdit.setText("Edit");
		num = 0;
	    }
	} else if (e.getSource() == btnEdit) { // Button that allows price to be edited
	    double nPrice, oPrice; // variables for old & new price
	    oPrice = houseList.get(currentItem).getPrice(); // Setting old price to the price of the currently viewed
							    // item
	    num++; // Increment num, to keep track of number of clicks of edit
	    if (num == 1) {
		// When edit is clicked once
		btnEdit.setText("Save"); // Edit button text changed to save
		txtPrice.setEditable(true); // Price textfield is now editable
	    }
	    if (num == 2) {
		// When edit is clicked a second time
		for (House h : houseList) {
		    // Checking that the element is in the arraylist
		    if (h.getId() == (Integer.parseInt(txtID.getText()))) {
			nPrice = Double.parseDouble(txtPrice.getText()); // new price variable set to user input
			h.setPrice(nPrice); // arraylist element set to the new price variable
			JOptionPane.showMessageDialog(null, "Record Updated"); // Message box to tell user that the
									       // record is updated
			btnEdit.setText("Edit"); // edit button text is reset
			txtPrice.setEditable(false); // Price textfield is now uneditable
			num = 0; // num variable set to zero again

		    }

		}
		double currPrice = houseList.get(currentItem).getPrice(); // retrieving current price
		// if the old price is greater than the old price
		if (oPrice > currPrice) {
		    double change = (oPrice - currPrice); // variable change set to the difference between the two
							  // prices
		    houseList.get(currentItem).setChange(change); // set the price change variable for current item to
								  // change
		    txtPriceChng.setText(String.valueOf(change)); // set the price change textfield for current item to
								  // change
		} else {
		    double change = (currPrice - oPrice);
		    houseList.get(currentItem).setChange(change);
		    txtPriceChng.setText(String.valueOf(change));
		}

	    }

	} else if (e.getSource() == exit) {
	    System.out.println("closeclick");
	    System.exit(0); // Closes the program
	} else if (e.getSource() == create) {
	    if (getPassword() == true) {
		/*
		 * new instance of CreateHouseDialog class Opens new window to allow user to
		 * input new house details and add it to the list
		 */
		createHouseDialog = new CreateHouseDialog(houseList);
	    } 

	} else if (e.getSource() == search) {
	    cbo(); // Launches a combobox to allow user to select which house to view

	} else if (e.getSource() == summary) {
	    /*
	     * new instance of HouseSummaryDialog class Opens new window which displays a
	     * summary of all houses and the average price of all houses, houseList is
	     * passed as parameter
	     */
	    houseSummaryDialog = new HouseSummaryDialog(houseList);
	}

	else if (e.getSource() == delete) {
	    int dialogResult = JOptionPane.showConfirmDialog(null, "This will delete the record. Are you sure you wish to continue?", "Warning",JOptionPane.ERROR_MESSAGE );
	    if(dialogResult == JOptionPane.YES_OPTION)
	    if (getPassword() == true) {
		houseList.remove(currentItem); // removes the current item if the password is inputted correctly
		displayDetails(currentItem); // Display the next item in the list

	    }
	}
    }

    // Password method
    public boolean getPassword() {
	boolean match = false; // return variable
	String pass = "3157"; // password is set as 3157
	String userPass;
	userPass = JOptionPane.showInputDialog(null, null, "Enter Password", JOptionPane.PLAIN_MESSAGE); // User inputs the password in an option pane
	// if the user inputted password and the password match
	if (userPass.equals(pass)) {
	    match = true; // match is set to true
	} else {
	    match = false; // if not, match is set to false
	    JOptionPane.showMessageDialog(null, "Incorrect password"); // Option pane tells user that the password was
								       // incorrect
	}
	return match;
    }

    /*
     * Used this link to help create this method
     * https://docs.oracle.com/javase/tutorial/displayCode.html?code=
     * https://docs.oracle.com/javase/tutorial/uiswing/examples/components/
     * ComboBoxDemoProject/src/components/ComboBoxDemo.java
     */
    public void cbo() {

	JComboBox<String> cboID = new JComboBox<String>();
	for (int i = 0; i < houseList.size(); i++) {
	    cboID.addItem(String.valueOf(houseList.get(i).getId())); // Loop adds house IDs to combobox
	}
	JOptionPane.showMessageDialog(null, cboID, "Input", JOptionPane.INFORMATION_MESSAGE);
	cboID.addActionListener(this); // combobox action listener
	for (House h : houseList) { // Enhanced for each loop to iterate through list
	    if (houseList.indexOf(h) == (cboID.getSelectedIndex())) {
		displayDetails(houseList.indexOf(h)); // if the id and the combobox selection match, display the house
						      // details

	    }
	}

    }

    // main method
    public static void main(String[] args) {
	HouseApplication ha = new HouseApplication();

    }

}

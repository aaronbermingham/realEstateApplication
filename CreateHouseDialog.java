
/*Author: Aaron Bermingham
Student number: C17738539*/

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class CreateHouseDialog extends JFrame implements ActionListener {
    // Reference variable for house arrayList
    private ArrayList<House> myrefHouse = new ArrayList<House>();
    // Panels
    private JPanel parentPanel = new JPanel(new BorderLayout());
    private JPanel panelTop = new JPanel(new MigLayout("wrap 2"));
    private JPanel panelBtn = new JPanel(new FlowLayout());
    // Labels and Textfields
    private JLabel lblPhoto = new JLabel("Photograph file name");
    private JTextField txtPhoto = new JTextField(20);
    private JLabel lblAddrss1 = new JLabel("Address Line 1");
    private JTextField txtAddrss1 = new JTextField(20);
    private JLabel lblAddrss2 = new JLabel("Address Line 2");
    private JTextField txtAddrss2 = new JTextField(20);
    private JLabel lblBathrms = new JLabel("Number of Bathrooms");
    private JTextField txtBathrms = new JTextField(20);
    private JLabel lblBedrms = new JLabel("Number of Bedrooms");
    private JTextField txtBedrms = new JTextField(20);
    private JLabel lblPrice = new JLabel("Price");
    //private JFormattedTextField txtPrice = new JFormattedTextField(new DecimalFormat("€###,###"));
    private JTextField txtPrice = new JTextField(20);
    private JLabel lblPNum = new JLabel("Contact Number:");
    private JTextField txtPNum = new JTextField(20);

    // Buttons
    private JButton btnAdd = new JButton("Add");
    private JButton btnCancel = new JButton("Cancel");
    
    //Contructor - arrayList of type House is a parameter for the constructor
    public CreateHouseDialog(ArrayList<House> houses) {
	myrefHouse = houses;
	// Adding labels and text fields
	panelTop.add(lblPhoto);
	panelTop.add(txtPhoto);
	panelTop.add(lblAddrss1);
	panelTop.add(txtAddrss1);
	panelTop.add(lblAddrss2);
	panelTop.add(txtAddrss2);
	panelTop.add(lblBedrms);
	panelTop.add(txtBedrms);
	panelTop.add(lblBathrms);
	panelTop.add(txtBathrms);
	panelTop.add(lblPrice);
	panelTop.add(txtPrice);
	panelTop.add(lblPNum);
	panelTop.add(txtPNum);
	// Adding buttons
	panelBtn.add(btnAdd);
	panelBtn.add(btnCancel);
	// Adding action listeners
	btnAdd.addActionListener(this);
	btnCancel.addActionListener(this);
	// Adding panels
	parentPanel.add(panelTop, BorderLayout.CENTER);
	parentPanel.add(panelBtn, BorderLayout.SOUTH);
	add(parentPanel);

	setTitle("Add House Details");
	setSize(400, 300);
	setVisible(true);

    }
    
    // 
    public void actionPerformed(ActionEvent e) {
	// Adding a new house
	if (e.getSource() == btnAdd) {
	    if (txtPhoto.getText().isEmpty() || txtAddrss1.getText().isEmpty() || txtAddrss2.getText().isEmpty()
		    || txtBedrms.getText().isEmpty() || txtBathrms.getText().isEmpty() || txtPrice.getText().isEmpty()
		    || txtPNum.getText().isEmpty())
		JOptionPane.showMessageDialog(panelTop, "Please add information to all fields"); // If any field is empty, dispay a warning message
	    else {
		String photo = txtPhoto.getText();
		String addrss1 = txtAddrss1.getText();
		String addrss2 = txtAddrss2.getText();
		int bed = Integer.parseInt(txtBedrms.getText());
		int bath = Integer.parseInt(txtBathrms.getText());
		double price = Double.parseDouble(txtPrice.getText());
		String pNum = txtPNum.getText();
		House aHouse = new House(addrss1, addrss2, bed, bath, price, photo, pNum); // Creating an instance of House, using user inputted values
		myrefHouse.add(aHouse); // object added to the arraylist 
		JOptionPane.showMessageDialog(null, "House added successfully");
		this.dispose(); // Closes window
	    }
	}

	else if (e.getSource() == btnCancel) {
	    this.dispose(); // Closes window
	}
    }

    /*
     * Used info from the following link to create this class/methods
     * https://docs.oracle.com/javase/tutorial/uiswing/examples/components/
     * PasswordDemoProject/src/components/PasswordDemo.java Does not work as I
     * intended!
     */
    /*
     * public static class Password extends JFrame implements ActionListener {
     * private ArrayList<House> myrefHouse = new ArrayList<House>();
     * CreateHouseDialog createHouseDialog; private JPanel parentPanel = new
     * JPanel(new GridLayout(0,1)); private JPanel passPanel = new JPanel(); private
     * JPanel btnPanel = new JPanel();
     * 
     * private JButton btnOk = new JButton("Ok"); private JButton btnCancel = new
     * JButton("Cancel");
     * 
     * private JTextField txtPass = new JTextField(20);
     * 
     * public Password(ArrayList<House> houses) { btnOk.addActionListener(this);
     * btnCancel.addActionListener(this); passPanel.add(txtPass);
     * btnPanel.add(btnOk); btnPanel.add(btnCancel); parentPanel.add(passPanel);
     * parentPanel.add(btnPanel); add(parentPanel); setTitle("Enter Password");
     * setSize(1000, 250); setVisible(true);
     * 
     * }
     * 
     * public boolean getPassword() { boolean match = false; String password =
     * "3157"; String userInput = txtPass.getText(); if (password.equals(userInput))
     * { System.out.println("matcg"); match = true; } else if
     * (!password.equals(userInput)) { System.out.println("no match"); match =
     * false; } return match; }
     * 
     * @Override public void actionPerformed(ActionEvent e) { if(e.getSource()==
     * btnOk) { getPassword(); if (getPassword() == true) { createHouseDialog = new
     * CreateHouseDialog(myrefHouse); this.dispose(); } } else if(e.getSource() ==
     * btnCancel) { this.dispose(); }
     * 
     * }
     * 
     * }
     */

}
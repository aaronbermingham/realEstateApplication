
/*Author: Aaron Bermingham
Student number: C17738539*/

import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.*;

import net.miginfocom.swing.MigLayout;

import java.awt.*;
import java.awt.event.*;

public class HouseSummaryDialog extends JFrame {
    // Reference variable for house arrayList
    private ArrayList<House> myrefHouse = new ArrayList<House>();
    // Panels
    private JPanel parentPanel = new JPanel(new GridLayout(2, 0));
    private JPanel headerPanel = new JPanel(new GridLayout(0, 7));
    private JPanel txtPanel = new JPanel(new GridLayout(0, 7));
    // private JTextArea txtHouse = new JTextArea();
    // Labels
    private JLabel lblID = new JLabel("ID");
    private JLabel lblAddrss1 = new JLabel("Addresss Line 1");
    private JLabel lblAddrss2 = new JLabel("Addresss Line 2");
    private JLabel lblBedrms = new JLabel("Number of Bedrooms");
    private JLabel lblBathrms = new JLabel("Number of Bathrooms");
    private JLabel lblPrice = new JLabel("Price");
    private JLabel lblPNum = new JLabel("Contact Number");
    private JLabel lblAvg = new JLabel("Average Price: ");
    private JLabel lblSpace1 = new JLabel();
    private JLabel lblSpace2 = new JLabel();
    private JLabel lblSpace3 = new JLabel();
    private JLabel lblSpace4 = new JLabel();
    
    // Constructor
    public HouseSummaryDialog(ArrayList<House> houses) {
	myrefHouse = houses;
	// Adding labels to panel
	txtPanel.add(lblID);
	txtPanel.add(lblAddrss1);
	txtPanel.add(lblAddrss2);
	txtPanel.add(lblBedrms);
	txtPanel.add(lblBedrms);
	txtPanel.add(lblBathrms);
	txtPanel.add(lblPrice);
	txtPanel.add(lblPNum);
	// headerPanel.add(txtHouse);
	// txtPanel.add(txtHouse);
	// Adding panels to parent panel
	parentPanel.add(headerPanel);
	parentPanel.add(txtPanel);
	// Call houseSummary method
	houseSummary();
	add(parentPanel);
	setTitle("Summary");
	setSize(1000, 250);
	setVisible(true);

    }

    public void houseSummary() {
	// String houses = "";
	for (House h : myrefHouse) {
	    // Iterate through list and get info for each element
	    JLabel lblID = new JLabel(String.valueOf(h.getId()));
	    JLabel lblStreet = new JLabel(h.getStreet());
	    JLabel lblCity = new JLabel(h.getCity());
	    JLabel lblRooms = new JLabel(String.valueOf(h.getBedrooms()));
	    JLabel lblBath = new JLabel(String.valueOf(h.getBathrooms()));
	    JLabel lblPrice = new JLabel("€" + String.valueOf(h.getPrice()));
	    JLabel lblContact = new JLabel(h.getContactNo());
	    // Add labels to panel
	    txtPanel.add(lblID);
	    txtPanel.add(lblStreet);
	    txtPanel.add(lblCity);
	    txtPanel.add(lblRooms);
	    txtPanel.add(lblBath);
	    txtPanel.add(lblPrice);
	    txtPanel.add(lblContact);
	    txtPanel.add(lblAvg);
	    txtPanel.add(lblSpace1);
	    txtPanel.add(lblSpace2);
	    txtPanel.add(lblSpace3);
	    txtPanel.add(lblSpace4);

	}
	String avgPrice = String.valueOf(avgPrice());
	JLabel lblAvgPrice = new JLabel("€" + avgPrice);
	txtPanel.add(lblAvgPrice);
    }
    
    // Method to calculate average house price
    public double avgPrice() {
	double priceTotal = 0, avg;
	int total = 0;
	for (House h : myrefHouse) {
	    priceTotal += h.getPrice();
	    total++;
	}
	avg = priceTotal / total;
	System.out.println(avg);
	return avg;

    }
}

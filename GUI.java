import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionListener;

public class GUI extends JPanel implements PropertyChangeListener {

	private String fnameVal, lnameVal, depVal, numVal;
	private boolean maleVal = false;
	private boolean femaleVal = false;
	private boolean otherVal = false;
	
	private JLabel fname;
    private JLabel lname;
    private JLabel dep;
    private JLabel num;
    private JLabel picture;
    
    private String fnamestring = "First name: ";
    private String lnamestring = "Last name: ";
    private String depstring = "Department: ";
    private String numstring = "Phone number: ";
    private String malestring = "Male";
    private String femalestring = "Female";
    private String otherstring = "Other";
    
    private JFormattedTextField fnameField;
    private JFormattedTextField lnameField;
    private JFormattedTextField depField;
    private JFormattedTextField numField;
    private JRadioButton maleButton = new JRadioButton(malestring);
    private JRadioButton femaleButton = new JRadioButton(femalestring);
    private JRadioButton otherButton = new JRadioButton(otherstring);
    
    public GUI() {
        super(new BorderLayout());
 
        //Create the labels.
        fname = new JLabel(fnamestring);
        lname = new JLabel(lnamestring);
        dep = new JLabel(depstring);
        num = new JLabel(numstring);
 
        //Create the text fields and set them up.
        fnameField = new JFormattedTextField();
        fnameField.setValue(fname);
        fnameField.setColumns(10);
        fnameField.addPropertyChangeListener("value", this);
 
        lnameField = new JFormattedTextField();
        lnameField.setValue(lname);
        lnameField.setColumns(10);
        lnameField.addPropertyChangeListener("value", this);
 
        depField = new JFormattedTextField();
        depField.setValue(dep);
        depField.setColumns(10);
        depField.addPropertyChangeListener("value", this);
 
        numField = new JFormattedTextField();
        numField.setValue(numField);
        numField.setColumns(10);
 
        //Tell accessibility tools about label/textfield pairs.
        fname.setLabelFor(fnameField);
        lname.setLabelFor(lnameField);
        dep.setLabelFor(depField);
        num.setLabelFor(numField);
        
        
      //Create the radio buttons.
        maleButton.setMnemonic(KeyEvent.VK_B);
        maleButton.setActionCommand(malestring);
        maleButton.setSelected(true);
 
        femaleButton.setMnemonic(KeyEvent.VK_C);
        femaleButton.setActionCommand(femalestring);
 
        otherButton.setMnemonic(KeyEvent.VK_D);
        otherButton.setActionCommand(otherstring);
        
      //Group the radio buttons.
        ButtonGroup group = new ButtonGroup();
        group.add(maleButton);
        group.add(femaleButton);
        group.add(otherButton);
        

        //Register a listener for the radio buttons.
        maleButton.addPropertyChangeListener("value", this);
        femaleButton.addPropertyChangeListener("value", this);
        otherButton.addPropertyChangeListener("value", this);
 
        //Lay out the labels in a panel.
        JPanel labelPane = new JPanel(new GridLayout(0,1));
        labelPane.add(fname);
        labelPane.add(lname);
        labelPane.add(dep);
        labelPane.add(num);
        labelPane.add(maleButton);
        labelPane.add(femaleButton);
        labelPane.add(otherButton);
 
        //Layout the text fields in a panel.
        JPanel fieldPane = new JPanel(new GridLayout(0,1));
        fieldPane.add(fnameField);
        fieldPane.add(lnameField);
        fieldPane.add(depField);
        fieldPane.add(numField);
        fieldPane.add(maleButton);
        fieldPane.add(femaleButton);
        fieldPane.add(otherButton);
 
        //Put the panels in this panel, labels on left,
        //text fields on right.
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(labelPane, BorderLayout.CENTER);
        add(fieldPane, BorderLayout.LINE_END);
    }
    
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Item Selection");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Add contents to the window.
        frame.add(new GUI());
        
      //Create and set up the content pane.
        JComponent newContentPane = new GUI();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
            UIManager.put("swing.boldMetal", Boolean.FALSE);
                createAndShowGUI();
            }
        });
    }
    
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		 Object source = evt.getSource();
	        if (source == numField) {
	            numVal = (String) numField.getValue();
	        } else if (source == fnameField) {
	            fnameVal = (String) fnameField.getValue();
	        } else if (source == lnameField) {
	            lnameVal = (String) lnameField.getValue();
	        } else if (source == depField) {
	        		depVal = (String) depField.getValue();
	        } else if (source == maleButton) {
	        		maleVal = true;
	        } else if (source == femaleButton) {
	        		femaleVal = true;
	        } else if (source == otherButton) {
	        		otherVal = true;
	        }
	}

}

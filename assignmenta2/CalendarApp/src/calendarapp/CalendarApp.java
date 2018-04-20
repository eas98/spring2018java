package calendarapp;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.*;
import org.jdesktop.swingx.JXMonthView;
import org.jdesktop.swingx.calendar.DateSelectionModel.SelectionMode;


public class CalendarApp {
    private static void addControls(JFrame frame) {
        JPanel panelMain = new JPanel(new GridBagLayout());
        
        GridBagConstraints c1 = new GridBagConstraints();
        c1.fill = GridBagConstraints.HORIZONTAL;
        //c.anchor = GridBagConstraints.CENTER;
        c1.gridx = 1;
        
        JPanel subPanelTop = new JPanel(new GridBagLayout());
        
        JLabel label = new JLabel("Save your Appointments");
        
        subPanelTop.add(label,c1);
    
    	JPanel subPanelMiddle = new JPanel(new GridBagLayout());
    	
    	JXMonthView  monthView = new JXMonthView();
        monthView.setTraversable(true);
        monthView.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent e) {
                if ("firstDisplayedDay".equals(e.getPropertyName())) {
                    System.out.println("updated");
                }
            }
        });
        monthView.setSelectionMode(SelectionMode.SINGLE_INTERVAL_SELECTION);    	
        //c.anchor = GridBagConstraints.WEST;
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        
        
        
    	JTextArea textField = new JTextArea(12,15);
    	textField.setText("Enter\nYour Appointment Note");
    	//c.anchor = GridBagConstraints.EAST;
    	c.fill = GridBagConstraints.HORIZONTAL;
    	
        c.weightx = 0.4;
        c.gridy = 0;
    	c.gridx = 1;
    	
    	subPanelMiddle.add(monthView,c);
    	
        c.weightx = .4;
        c.gridy = 0;
        c.gridx = 4;
    	
    	subPanelMiddle.add(textField,c);
    	
    	GridBagConstraints c2 = new GridBagConstraints();
    	c2.fill = GridBagConstraints.VERTICAL;
    	
    	
    	JPanel subPanelBottom = new JPanel(new GridBagLayout());
    	
        
    	c.anchor = GridBagConstraints.WEST;
    	c.fill = GridBagConstraints.HORIZONTAL;
    	c.weighty=0.3;
    	c.weightx=0.4;
    	c.gridy = 2;
    	c.gridx = 1;
    	
    	JButton okButton = new JButton("Ok");
    	subPanelBottom.add(okButton,c);
    	
    	c.fill = GridBagConstraints.HORIZONTAL;
    	c.anchor = GridBagConstraints.EAST;
    	c.weighty=.3;
    	c.weightx=.4;
    	c.gridy = 2;
    	c.gridx = 4;
    	
    	JButton cancelButton = new JButton("Cancel");
    	subPanelBottom.add(cancelButton,c);
    	
    	GridBagConstraints cmain = new GridBagConstraints();
    	cmain.fill = GridBagConstraints.VERTICAL;
    	cmain.anchor = GridBagConstraints.NORTH;
    	cmain.gridy=1;
    	panelMain.add(subPanelTop,cmain);
    	cmain.anchor = GridBagConstraints.CENTER;
    	cmain.gridy=2;
    	panelMain.add(subPanelMiddle,cmain);
    	cmain.anchor = GridBagConstraints.SOUTH;
    	cmain.gridy=3;
    	panelMain.add(subPanelBottom,cmain);
    	
    	frame.getContentPane().add(panelMain);
    }
	private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Assignment 2 Calendar Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //minimum resolution on a modern monitor 1024*.768
        //This size seems reasonable.
        Dimension d = new Dimension(400,400);
        Container c = frame.getContentPane();
        c.setPreferredSize(d);
        
        addControls(frame);
        
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

	public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
	}

}

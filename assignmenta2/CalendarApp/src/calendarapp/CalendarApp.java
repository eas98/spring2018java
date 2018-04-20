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
        JPanel panelTop = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 1;
        JLabel label = new JLabel("Save your Appointments");
    	panelTop.add(label,c);
    	c.weighty = 0.1;
    	c.gridy = 0;
    	
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
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.NONE;
        c.weighty = 0.6;
        c.weightx = .4;
    	c.gridy = 1;
    	c.gridx = 0;
        panelTop.add(monthView,c);

        
    	JTextArea textField = new JTextArea("Enter\nYour Appointment Note");
    	c.anchor = GridBagConstraints.EAST;
    	c.fill = GridBagConstraints.NONE;
        c.weighty = 0.6;
        c.weightx = 0.4;
    	c.gridy = 1;
    	c.gridx = 4;
    	panelTop.add(textField,c);
    	
    	c.anchor = GridBagConstraints.WEST;
    	c.fill = GridBagConstraints.NONE;
    	c.weighty=0.1;
    	c.weightx=0.4;
    	c.gridy = 2;
    	c.gridx = 0;
    	
    	JButton okButton = new JButton("Ok");
    	panelTop.add(okButton,c);
    	
    	c.fill = GridBagConstraints.NONE;
    	c.weighty=0;
    	c.weightx=.4;
    	c.gridy = 2;
    	c.gridx = 4;
    	c.anchor = GridBagConstraints.EAST;
    	JButton cancelButton = new JButton("Cancel");
    	panelTop.add(cancelButton,c);
    	
    	frame.getContentPane().add(panelTop);
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

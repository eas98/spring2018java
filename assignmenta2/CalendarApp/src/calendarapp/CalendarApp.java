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
        c.fill = GridBagConstraints.VERTICAL;

        JLabel label = new JLabel("Save your Appointments");
    	panelTop.add(label,c);
    	c.weighty = 0.2;
    	c.gridy = 1;
    	
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
        panelTop.add(monthView,c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weighty = 0.2;
        c.weightx = 0.6;
    	c.gridy = 1;
    	c.gridx = 1;
    	
    	JTextArea textField = new JTextArea("Enter\nYour Appointment Note");
    	panelTop.add(textField,c);
    	
    	c.fill = GridBagConstraints.VERTICAL;
    	c.weighty=0.8;
    	c.gridy = 2;
    	JButton okButton = new JButton("Ok");
    	panelTop.add(okButton,c);
    	
    	c.fill = GridBagConstraints.HORIZONTAL;
    	c.weighty=0.8;
    	c.gridx = 2;
    	
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

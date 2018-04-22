package calendarapp;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.*;
import org.jdesktop.swingx.JXMonthView;
import org.jdesktop.swingx.calendar.DateSelectionModel.SelectionMode;


public class CalendarApp {
	boolean appointmentNoteChanged =false; 
	JXMonthView  monthView;
	JTextArea textField;
	
	private Component addTopPanel() {
		
		GridBagConstraints c1 = new GridBagConstraints();
        c1.fill = GridBagConstraints.HORIZONTAL;
        c1.anchor = GridBagConstraints.LINE_START;
        c1.gridx = 2;
        c1.weighty = .1;
        
        JPanel subPanelTop = new JPanel(new GridBagLayout());
        subPanelTop.setLayout(new GridLayout(1, 1, 0, 0));
        
        JLabel label = new JLabel("Save your Appointments");
        
        subPanelTop.add(label,c1);
        return subPanelTop;
	}
	private Component addMiddlePanel() {
		GridBagConstraints c = new GridBagConstraints();
		JPanel subPanelMiddle = new JPanel(new GridBagLayout());
		subPanelMiddle.setLayout(new GridLayout(1, 3, 3, 3));
    	
    	monthView = new JXMonthView();
        monthView.setTraversable(true);
        monthView.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent e) {
            	HandleDateSelectionChanged();
            }
        });
        monthView.setSelectionMode(SelectionMode.SINGLE_INTERVAL_SELECTION);
        monthView.setBorder(BorderFactory.createCompoundBorder(
        		monthView.getBorder(), 
    	        BorderFactory.createEmptyBorder(10, 5, 10, 5)));
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.WEST;
        
        
    	textField = new JTextArea(12,15);
    	textField.setText("Enter\nYour Appointment Note");
    	textField.setBorder(BorderFactory.createCompoundBorder(
    			textField.getBorder(), 
    	        BorderFactory.createEmptyBorder(10, 5, 10, 5)));
    	textField.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent e) {
            	HandleAppointmentNoteChanged();
            }
        });
    	
    	c.anchor = GridBagConstraints.EAST;
    	c.fill = GridBagConstraints.HORIZONTAL;
    	
        c.weightx = 0.3;
        c.gridy = 0;
    	c.gridx = 1;
    	
    	subPanelMiddle.add(monthView,c);
    	
        c.weightx = .4;
        c.gridy = 0;
        c.gridx = 6;
    	
    	subPanelMiddle.add(textField,c);
    	
        return subPanelMiddle;
	}
	private Component addBottomPanel() {
		JPanel subPanelBottom = new JPanel(new GridBagLayout());
		subPanelBottom.setLayout(new GridLayout(1, 3, 2, 2));
		
		GridBagConstraints c = new GridBagConstraints();
        
    	c.anchor = GridBagConstraints.WEST;
    	c.fill = GridBagConstraints.HORIZONTAL;
    	c.weighty=0.3;
    	c.weightx=0.4;
    	c.gridy = 4;
    	c.gridx = 1;
    	
    	JButton okButton = new JButton("Ok");
    	okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				HandleOkButton();
			}
    	});
    	okButton.setToolTipText("Save Changes");
    	
    	subPanelBottom.add(okButton,c);
    	
    	c.fill = GridBagConstraints.HORIZONTAL;
    	c.anchor = GridBagConstraints.EAST;
    	c.weighty=.3;
    	c.weightx=.4;
    	c.gridy = 4;
    	c.gridx = 5;
    	
    	JButton cancelButton = new JButton("Cancel");
    	cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				HandleCancelButton();
			}
    	});
    	cancelButton.setToolTipText("Don't Save Changes");
    	
    	subPanelBottom.add(cancelButton,c);
    	
    	return subPanelBottom;
	}
	private void addControls(JFrame frame) {
        JPanel panelMain = new JPanel(new GridBagLayout());
        
        Component subPanelTop = addTopPanel();
        Component subPanelMiddle = addMiddlePanel();
        Component subPanelBottom = addBottomPanel();
            	
    	GridBagConstraints cmain = new GridBagConstraints();
    	cmain.fill = GridBagConstraints.NORTH;
    	cmain.gridy=0;
    	cmain.weighty=.1;
    	panelMain.add(subPanelTop,cmain);
    	cmain.gridy=1;
    	cmain.weighty=.6;
    	cmain.fill = GridBagConstraints.CENTER;
    	panelMain.add(subPanelMiddle,cmain);
    	cmain.gridy=2;
    	cmain.weighty=.1;
    	cmain.fill = GridBagConstraints.SOUTH;
    	panelMain.add(subPanelBottom,cmain);
    	
    	
    	frame.getContentPane().add(panelMain);
    }
	private void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Assignment 2 Calendar Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //minimum resolution on a modern monitor 1024*.768
        //This size seems reasonable.
        Dimension d = new Dimension(500,300);
        Container c = frame.getContentPane();
        c.setPreferredSize(d);
        
        addControls(frame);
        
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

	void HandleOkButton() {
		if(appointmentNoteChanged) {
			System.exit(0);	
		} else {
			JOptionPane.showMessageDialog(null, "You need to provide your appointment Note");
		}
	}
	void HandleCancelButton() {
		System.exit(0);	
	}
	void HandleDateSelectionChanged() {
		
	}
	
	void HandleAppointmentNoteChanged() {
		appointmentNoteChanged = true;		
	}
	public static void main(String[] args) {
		CalendarApp app = new CalendarApp();
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	app.createAndShowGUI();
            }
        });
	}

}

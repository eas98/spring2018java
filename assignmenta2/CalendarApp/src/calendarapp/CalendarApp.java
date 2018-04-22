package calendarapp;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.jdesktop.swingx.JXMonthView;
import org.jdesktop.swingx.calendar.DateSelectionModel.SelectionMode;
import org.jdesktop.swingx.event.DateSelectionEvent;
import org.jdesktop.swingx.event.DateSelectionListener;


public class CalendarApp {
	boolean appointmentNoteChanged =false; 
	JXMonthView  monthView;
	JTextArea textField;
	Hashtable<String, Appointment> mapDateToNote;
	final String defaultAppointmentNote = "Enter\nYour Appointment Note";
	
	public CalendarApp() {
		AppointmentReader reader = new XmlAppointmentReader();
		mapDateToNote = AppointmentHelper.convertAppointmentsToMap(reader.getAppointments());
	}
	private void setCurrentNote(LocalDate date) {
		Appointment appointment = mapDateToNote.get(Appointment.getDateAsString(date));
		if(appointment != null) {
			textField.setText(appointment.getAppointmentNote());	
		} else {
			textField.setText(defaultAppointmentNote);
		}
	}
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
        monthView.getSelectionModel().addDateSelectionListener(new DateSelectionListener() {
            public void valueChanged(DateSelectionEvent e) {
            	handleDateSelectionChanged();
            }
        });
        
        monthView.setSelectionMode(SelectionMode.SINGLE_SELECTION);
        monthView.setBorder(BorderFactory.createCompoundBorder(
        		monthView.getBorder(), 
    	        BorderFactory.createEmptyBorder(10, 5, 10, 5)));
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.WEST;
        
        
    	textField = new JTextArea(12,15);
    	
    	textField.setBorder(BorderFactory.createCompoundBorder(
    			textField.getBorder(), 
    	        BorderFactory.createEmptyBorder(10, 5, 10, 5)));
    	textField.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
            	handleAppointmentNoteChanged();
            }
            public void removeUpdate(DocumentEvent e) {
            	handleAppointmentNoteChanged();
            }
            public void changedUpdate(DocumentEvent e) {
                handleAppointmentNoteChanged();
            }
    	});
    	Date todayDate = new Date();
    	monthView.setSelectionDate(todayDate);
    	setCurrentNote(getCurrentLocalDate());
    	
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
				handleOkButton();
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
				handleCancelButton();
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

	void handleOkButton() {
		if(appointmentNoteChanged) {
			AppointmentWriter writer = new XmlAppointmentWriter();
			List<Appointment> listAppointments = AppointmentHelper.convertAppointmentMapToArray(mapDateToNote);
		
			if(!writer.write(listAppointments)){
				JOptionPane.showMessageDialog(null, "Failed to Save Appointments");	
			}			
			System.exit(0);	
		} else {
			JOptionPane.showMessageDialog(null, "There is nothing to Change");
			System.exit(0);	
		}
	}
	
	void handleCancelButton() {
		System.exit(0);	
	}
	
	void handleDateSelectionChanged() {
		LocalDate selectedLocalDate = getCurrentLocalDate();
		setCurrentNote(selectedLocalDate);
	}
	
	LocalDate getCurrentLocalDate() {
		Date selectedDate = monthView.getSelectionDate();
		if(selectedDate == null) {
			selectedDate = new Date();
		}
		LocalDate selectedLocalDate = selectedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return selectedLocalDate;
	
	}
	void handleAppointmentNoteChanged() {
		appointmentNoteChanged = true;
		LocalDate selectedLocalDate = getCurrentLocalDate();
		String appointmentNote = this.textField.getText();
		Appointment appointment = new Appointment(selectedLocalDate,appointmentNote);
		this.mapDateToNote.put(appointment.getAppointmentDateAsString(),appointment);
	
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

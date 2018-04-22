package calendarapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.stream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.CDATASection;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class AppointmentReader {
    private static final Logger log = Logger.getLogger(AppointmentReader.class.getName());
	public Iterable<Appointment> getAppointments() {
		ArrayList<Appointment> listAppointments = new ArrayList<Appointment>();
		try
		{
			Document doc = getDocument();
			if(doc != null) {
				NodeList nodelist = doc.getParentNode().getChildNodes();
				for(int i=0; i< nodelist.getLength(); i++) {
					Node elementAppointment = nodelist.item(i);
					Appointment appointment = getAppointment(elementAppointment);
					listAppointments.add(appointment);
				}
			}
		}
		catch(ParserConfigurationException e)
		{
			log.log(Level.CONFIG, "ParserConfigurationException"+e.toString());
		}
		catch(SAXException e)
		{
			log.log(Level.WARNING, "SAXException"+e.toString());	
		}
		catch(IOException e)
		{
			log.log(Level.WARNING, "IOException"+e.toString());	
		}
	    return listAppointments;
	}
	
	Appointment getAppointment(Node elementAppointment) {
		if(elementAppointment != null) {
			if(elementAppointment.getNodeName().equalsIgnoreCase("appointment")) {
				if(elementAppointment.hasAttributes()) {
					Node dateAttribute = elementAppointment.getAttributes().getNamedItem("date");
					if(dateAttribute != null) {
						String strAppointmentDate = dateAttribute.getNodeValue();
						Node elmentAppointmentNote = elementAppointment.getFirstChild();
						if(elmentAppointmentNote != null && 
						   elmentAppointmentNote.getNodeType() == Node.CDATA_SECTION_NODE) {
							CDATASection cdataNote = (CDATASection)elmentAppointmentNote;
							if(cdataNote != null) {
								String appointmentNote = cdataNote.getNodeValue();
							}
						}
					}
				}
			}
		}
		return null;
	}
	
	Document getDocument() throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	    DocumentBuilder db = null;
	    db = dbf.newDocumentBuilder();
	    Document doc = db.parse(new File("appointments.xml"));
	    return doc;
	}
}

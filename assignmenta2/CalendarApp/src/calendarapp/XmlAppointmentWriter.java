package calendarapp;

import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XmlAppointmentWriter implements AppointmentWriter {
    private static final Logger log = Logger.getLogger(XmlAppointmentWriter.class.getName());
    
    public boolean write(List<Appointment> appointments) {
    	try {
    		Document doc = initializeRoot();
    		Element rootElement = (Element)doc.getParentNode();
    		Element docElement = (Element)doc.getDocumentElement();
    		insertAppointments(doc,docElement,appointments);
    		saveFile(doc);
    		return true;
    	} catch (ParserConfigurationException e) {
    		log.log(Level.SEVERE, "ParserConfigurationException", e);
    	} catch (TransformerException e) {
    		log.log(Level.SEVERE, "TransformerException", e);
		}
    	return false;
	}
    private void insertAppointments(Document doc,Element rootElement,Iterable<Appointment> appointments) {
    	if(appointments != null) {
    		for(Appointment appointment:appointments) {
    			if(appointment == null)
    				continue;
    			Element appointmentElement = doc.createElement("appointment");
    			rootElement.appendChild(appointmentElement);

    			// set attribute to staff element
    			Attr attrDate = doc.createAttribute("date");
    			attrDate.setValue(appointment.getAppointmentDateAsString());
    			appointmentElement.setAttributeNode(attrDate);

    			CDATASection cDataNote = doc.createCDATASection(appointment.getAppointmentNote());
    			appointmentElement.appendChild(cDataNote);
    		}
    	}
    }
    private Document initializeRoot() throws ParserConfigurationException {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			
			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("appointments");
			doc.appendChild(rootElement);

			
			return doc;
    }
    
    private void saveFile(Document doc) throws TransformerException {
    	// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File("appointments.xml"));

		transformer.transform(source, result);

		System.out.println("File saved!");

    }
}

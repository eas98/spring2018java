package calendarapp;

import java.io.File;
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

public class AppointmentWriter {
    private static final Logger log = Logger.getLogger(AppointmentWriter.class.getName());
	void Write(Appointment[] appointments) {
		  try {

				DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

				
				// root elements
				Document doc = docBuilder.newDocument();
				Element rootElement = doc.createElement("appointmentbook");
				doc.appendChild(rootElement);

				for(Appointment appointment:appointments) {
					Element appointmentElement = doc.createElement("appointment");
					rootElement.appendChild(appointmentElement);

					// set attribute to staff element
					Attr attrDate = doc.createAttribute("date");
					attrDate.setValue(appointment.getAppointmentDateAsString());
					appointmentElement.setAttributeNode(attrDate);

					CDATASection cDataNote = doc.createCDATASection(appointment.getAppointmentNote());
					appointmentElement.appendChild(cDataNote);
				}
				
				// write the content into xml file
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				DOMSource source = new DOMSource(doc);
				StreamResult result = new StreamResult(new File("appointments.xml"));

				// Output to console for testing
				// StreamResult result = new StreamResult(System.out);

				transformer.transform(source, result);

				System.out.println("File saved!");

			  } catch (ParserConfigurationException pce) {
				  log.log(Level.SEVERE, "ParserConfigurationException", pce);
			  } catch (TransformerException tfe) {
				  log.log(Level.SEVERE, "TransformerException", tfe);
			  }
	}
}

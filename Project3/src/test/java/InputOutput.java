import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;


public class InputOutput {

    private static String fileFolder = "C:\\Users\\Inga\\IdeaProjects\\Project3\\";

    //getData reads data from xml file. It gets tag name and the name of XML file.
    public static String getData (String keyName, String fileName) throws ParserConfigurationException, IOException, SAXException {


        String location = fileFolder+fileName;

        File configXmlFile = new File(location);

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = null;

        dBuilder = dbFactory.newDocumentBuilder();

        Document doc = null;

        assert dBuilder != null;
        doc = dBuilder.parse(configXmlFile);

        if (doc != null) {
            doc.getDocumentElement().normalize();
        }
        assert doc != null;
        return doc.getElementsByTagName(keyName).item(0).getTextContent();
    }

}

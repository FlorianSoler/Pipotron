import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.File;
import java.io.IOException;

public class FileManager {

    //give the tag name to look for each tag
    private static final String XML_RULES_TAG = "regle";
    private static final String XML_PONCTUATION_TAG = "Ponct";
    private static final String XML_CONNECTOR_TAG = "Element";
    private static final String XML_REFERENCE_TAG = "Reference";
    private static final String XML_REFERENCE_PATH_FORMAT = "Data/Reference/";

    public FileManager() {
    }

    /** this fonction used to load a reference from a given txt file
     * @param refPath
     * @return Reference
     */
    private Reference loadReference(String refPath) {

        try {
            File file = new File(refPath);

            FileReader fr = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fr);

            List<String> Words = new ArrayList<>();

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Words.add(line);
            }
            fr.close();

            return new Reference(Words, 0);

        } catch (IOException error) {
            //stop the programm because it could not load a reference
            error.printStackTrace();
            System.exit(1);
        }
        return null;
    }

    // this fonction is used to load xml into a document for further processing
    private Document loadXML(String path) {
        try{
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            
            //parsing an normalizing xml file
            File file = new File(path);
            Document document = documentBuilder.parse(file);
            document.getDocumentElement().normalize();
            return document;
        }
        catch(ParserConfigurationException | SAXException | IOException | Error error){
            //stop the programm because it could not load the xml
            error.printStackTrace();
            System.exit(1);
        }
        return null;
    }

    //extractReference is used to transform a reference name and load it from the name file
    private Reference extractReference(int position, Element element) throws Exception {

        //get the path of the file
        String referenceFilename = element.getElementsByTagName(XML_REFERENCE_TAG).item(position).getTextContent();
        String referencePath = XML_REFERENCE_PATH_FORMAT + referenceFilename + ".txt";
        Reference reference = loadReference(referencePath);

        if (reference == null) {
            throw new Exception("Unable to Load Reference");
        }

        reference.setPosition(position + 1);

        return reference;
    }

    //extractRuleFromElement is used to creat the list of RuleElement in order to from rule
    private List<RuleElement> extractRuleFromElement(Element element) throws Exception {

        //creating the list of RuleElement and geting every connector xml tag
        List<RuleElement> ruleElements = new ArrayList<>();
        int elementLength = element.getElementsByTagName(XML_CONNECTOR_TAG).getLength();

        //iterate trough every xml tag
        for (int i = 0; i < elementLength; i++) {
            String connector = element.getElementsByTagName(XML_CONNECTOR_TAG).item(i).getTextContent();

            Reference reference;

            try {
                reference = extractReference(i, element);
                ruleElements.add(new Connecteur(connector));
                ruleElements.add(reference);
            } catch (Error err) {
                System.err.println(err);
                System.exit(1);
            }

        }

        String ponctuation = element.getElementsByTagName(XML_PONCTUATION_TAG).item(0).getTextContent();
        ruleElements.add(new Ponctuation(ponctuation));

        return ruleElements;

    }

    //load rule is used to transfrom xml to rules
    public List<Rule> loadRules(String rulePath) throws Exception {
        
        //load xml
        Document document = loadXML(rulePath);
        ArrayList<Rule> rules = new ArrayList<Rule>();

        NodeList list = document.getElementsByTagName(XML_RULES_TAG);

        //iterate over every rule tag
        for (int temp = 0; temp < list.getLength(); temp++) {
            Node ruleNode = list.item(temp);

            if (ruleNode.getNodeType() == Node.ELEMENT_NODE) {

                Element element = (Element) ruleNode;
                List<RuleElement> ruleElements = extractRuleFromElement(element);
                rules.add(new Rule(ruleElements));
            }
        }

        return rules;

    }

}

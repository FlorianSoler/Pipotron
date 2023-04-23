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

    private static final String XML_RULES_TAG = "regle";
    private static final String XML_PONCTUATION_TAG = "Ponct";
    private static final String XML_CONNECTOR_TAG = "Element";
    private static final String XML_REFERENCE_TAG = "Reference";
    private static final String XML_REFERENCE_PATH_FORMAT = "Data/Reference/";

    public FileManager() {
    }

    public Reference loadReference(String refPath) {

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

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Document loadXML(String path) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        Document document = documentBuilder.parse(new File(path));
        document.getDocumentElement().normalize();
        return document;

    }

    private Reference extractReference(int position, Element element) {
        String referenceFilename = element.getElementsByTagName(XML_REFERENCE_TAG).item(position).getTextContent();
        String referencePath = XML_REFERENCE_PATH_FORMAT + referenceFilename + ".txt";
        Reference reference = loadReference(referencePath);
        reference.setPosition(position);

        return reference;
    }

    private List<RuleElement> extractRuleFromElement(Element element) {
        List<RuleElement> ruleElements = new ArrayList<>();
        int elementLength = element.getElementsByTagName(XML_CONNECTOR_TAG).getLength();

        for (int i = 0; i < elementLength; i++) {
            String connector = element.getElementsByTagName(XML_CONNECTOR_TAG).item(i).getTextContent();
            Reference reference = extractReference(i, element);

            ruleElements.add(new Connecteur(connector));
            ruleElements.add(reference);

        }

        String ponctuation = element.getElementsByTagName(XML_PONCTUATION_TAG).item(0).getTextContent();
        ruleElements.add(new Ponctuation(ponctuation));


        return ruleElements;
    }

    public List<Rule> loadRules(String rulePath) throws ParserConfigurationException, SAXException, IOException {

        Document document = loadXML(rulePath);
        ArrayList<Rule> rules = new ArrayList<Rule>();

        NodeList list = document.getElementsByTagName(XML_RULES_TAG);

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


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
    public FileManager() {
    }

    public Reference loadReference(String refPath) {

        try {
            // Le fichier d'entrée
            File file = new File(refPath);

            String fname = file.getName();
            fname = fname.substring(0, fname.lastIndexOf("."));

            // Créer l'objet File Reader
            FileReader fr = new FileReader(file);
            // Créer l'objet BufferedReader
            BufferedReader br = new BufferedReader(fr);

            String line;

            List<String> listOfWords = new ArrayList<>();

            while ((line = br.readLine()) != null) {
                listOfWords.add(line);
            }
            fr.close();

            return new Reference(fname, listOfWords, 0);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Rule> loadRules(String rulePath) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        ArrayList<Rule> curRules = new ArrayList<Rule>();

        try {

            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc = db.parse(new File(rulePath));

            doc.getDocumentElement().normalize();

            NodeList list = doc.getElementsByTagName("regle");

            for (int temp = 0; temp < list.getLength(); temp++) {
                Node node = list.item(temp);

                List<RuleElement> myelement = new ArrayList<>();

                String ponct;

                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Element element = (Element) node;

                    int elemLength = element.getElementsByTagName("Element").getLength();

                    for (int i = 0; i < elemLength; i++) {
                        String curElem = element.getElementsByTagName("Element").item(i).getTextContent();
                        String curRef = element.getElementsByTagName("Reference").item(i).getTextContent();

                        String refPath = "Data/Reference/" + curRef + ".txt";

                        myelement.add(new Connecteur(curElem));

                        Reference Ref = loadReference(refPath);
                        Ref.setPosition(i);
                        myelement.add(Ref);
                    }

                    ponct = element.getElementsByTagName("Ponct").item(0).getTextContent();
                    myelement.add(new Ponctuation(ponct));

                }

                curRules.add(new Rule(myelement));

            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        return curRules;
    }

}

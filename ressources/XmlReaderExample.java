import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
 
public class XmlReaderExample{
 
    public static void main(String argv[]) {
 
        try {
            //Obtenir la configuration du sax parser
            SAXParserFactory spfactory = SAXParserFactory.newInstance();
            //Obtenir une instance de l'objet parser
            SAXParser saxParser = spfactory.newSAXParser();
 
            /*les trois méthodes sont déclarées dans le
            corp du DefaltHandler*/
            DefaultHandler handler = new DefaultHandler() {
 
                boolean bregle = false;
                boolean belement = false;
                boolean bref = false;
                boolean bponct = false;
                
                int nbRegles = 0;
 
                /*cette méthode est invoquée à chaque fois que parser rencontre
                une balise ouvrante '<' */
                public void startElement(String uri, String localName, String qName,Attributes attributes) throws SAXException{

                    if (qName.equalsIgnoreCase("regle")) {
                        bregle = true;
                        System.out.println("Lecture de la regle "+nbRegles);
                    }
 
                    if (qName.equalsIgnoreCase("Element")) {
                        belement = true;
                    }
 
                    if (qName.equalsIgnoreCase("Reference")) {
                        bref = true;
                    }
 
                    if (qName.equalsIgnoreCase("Ponct")) {
                        bponct = true;
                    }
                }
 
                /*cette méthode est invoquée à chaque fois que parser rencontre
                une balise fermante '>' */
                public void endElement(String uri, String localName, String qName) throws SAXException {
 
                    if (qName.equalsIgnoreCase("regle")) {
                        bregle = false;
                        nbRegles++;
                        System.out.println("Fin de la lecture d'une règle.");
                    }
 
                    if (qName.equalsIgnoreCase("Element")) {
                        belement = false;
                    }
    
                    if (qName.equalsIgnoreCase("Reference")) {
                        bref = false;
                    }
 
                    if (qName.equalsIgnoreCase("Ponct")) {
                        bponct = false;
                    }
                }

                /*imprime les données stockées entre '<' et '>' */
                public void characters(char ch[], int start, int length) throws SAXException {
 
                    if (belement) {
                        System.out.println("Element : " + new String(ch, start, length));
                        belement = false;
                    }
 
                    if (bref) {
                        System.out.println("Lien vers un fichier de portions de phrase : " + new String(ch, start, length));
                        bref = false;
                    }
 
                    if (bponct) {
                        System.out.println("Marque de ponctuation : " + new String(ch, start, length));
                        bponct = false;
                    } 
                }
 
           };  
 
            saxParser.parse("regles.xml", handler);
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

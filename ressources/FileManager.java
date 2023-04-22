import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class FileManager {

    private List<Reference> loadedReferences = new ArrayList<>();

    public FileManager(){

    };

    public void printRefs(){
        for (Reference element : loadedReferences) {
            element.print();
        }
    }

    public void loadMultipleRef(List<String> paths){
        for (String Path : paths) {
            fileToReference(Path);
        }
    }

    public void fileToReference(String refPath){

        try
        {
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
          

          while((line = br.readLine()) != null){
            listOfWords.add(line);  
          }
          fr.close();

          Reference reff = new Reference(fname, listOfWords);
          this.loadedReferences.add(reff);

        }
        catch(IOException e)
        {
          e.printStackTrace();
        }
    }

    public void fileToRule(String rulePath){
        
    }
    
}

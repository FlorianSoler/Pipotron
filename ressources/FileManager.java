import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
                System.out.println(line);
            }
            fr.close();

            return new Reference(fname, listOfWords, 0);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void loadRules(String rulePath) {

    }

}

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        FileManager fM = new FileManager();

        //fM.fileToReference("corpus/Couleur.txt");

        List<String> PATHS = new ArrayList<>();
        PATHS.add("corpus/Couleur.txt");
        PATHS.add("corpus/Anatomie.txt");

        fM.loadMultipleRef(PATHS);
        fM.fileToRule("corpus/refles.xml");
        
        fM.printRefs();

    }
}

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {

        FileManager fM = new FileManager();
        Reference ref = fM.loadReference("Data/Reference/Animal.txt");

        List<Element> myelement = new ArrayList<>();

        myelement.add(new Ponctuation("."));
        myelement.add(new Connecteur("Le"));
        myelement.add(ref);
        
        System.out.println(myelement.get(0).getClass());
        System.out.println(myelement.get(1).toString());
        System.out.println(myelement.get(2).toString());
        System.out.println(myelement.get(2).toString(false, true));
        System.out.println(myelement.get(2).toString(true, true));



    }
}

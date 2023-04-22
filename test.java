
import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {


        FileManager Fm = new FileManager();

        List<Rule> RULES;
        RULES = Fm.loadRules("Data/regles.xml");
        System.out.println(RULES.get(0).toString(false, true));

    }
}

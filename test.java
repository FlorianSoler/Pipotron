import java.util.List;

public class test {
    public static void main(String[] args) {
        FileManager Fm = new FileManager();

        List<Rule> RULES;
        try{
            RULES = Fm.loadRules("Data/regles.xml");
            System.out.println(RULES.get(2).toString(true, true));
            System.out.println(RULES.get(2).toString(false, true));
            RULES.get(2).changeSelectedReference(0);
            System.out.println(RULES.get(2).toString(false, true));
        }catch(Exception e){
            System.err.println("Unable to load rules");
        }

    }
}

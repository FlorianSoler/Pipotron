import java.nio.channels.SelectableChannel;
import java.nio.file.Path;
import java.util.List;

public class Sentence {
    private FileManager fileManager = new FileManager();
    private List<Rule> rules;
    private Rule selectedRule;
    private String rulesPath;

    public Sentence(){
    }

    public void setRulesPath(String path) {
        this.rulesPath = path;
    }

    private void loadRules(String path){
        try{
            this.rules = this.fileManager.loadRules(path);
        }
        catch(Exception e){
            System.err.println("Unable to load rules :" + e);
        }
    }



    
}

import java.util.List;
import java.util.Random;

public class Sentence {
    private FileManager fileManager = new FileManager();
    private List<Rule> rules;
    private Rule selectedRule;
    private String rulesPath;

    private Random random = new Random();

    //constructor
    public Sentence() {
    }


    
    /** 
     * @param path
     */
    public void setRulesPath(String path) {
        this.rulesPath = path;
    }

    //Load Rules Using FileManger
    void loadRules() {
        try {
            this.rules = this.fileManager.loadRules(rulesPath);
        } catch (Exception e) {
            System.err.println("Unable to load rules :" + e);
        }
    }

    //this fonction is use to select a random rule from the loaded rules
    public void selectRandomRule() {
        try {
            int randomNumber = this.random.nextInt(this.rules.size());
            if (this.rules.get(randomNumber) != this.selectedRule) {
                this.selectedRule = this.rules.get(randomNumber);
            } else {
                selectRandomRule();
            }

            if (this.rules.size() == 0) {
                throw new Exception("No rule loaded, please load one.");
            }
        } catch (Error | Exception error) {
            System.err.println(error);
        }
    }

    // generate a simple sentece from the selected rule
    public String generateSentence() {
        try {
            if (selectedRule != null) {
                return selectedRule.toString(false, false);
            } 
            else {
                throw new Exception("No rule selected, please select one.");
            }
        } catch (Error | Exception error) {
            System.err.println(error);
            return null;
        }
    }

    // generate a interactive sentece from the selected rule
    public String generateInteractiveSentence() {
        try {
            if (selectedRule != null) {
                return selectedRule.toString(false, true);
            } else {
                throw new Exception("No rule selected, please select one.");
            }
        }
        catch (Error | Exception error) {
            System.err.println(error);
            return null;
        }
    }

    //regenerate a interactive rule at a givven position in the sentence
    public String reGenerateInteractiveSentence(int position){
        selectedRule.changeSelectedReference(position);
        return generateInteractiveSentence();
    }

}

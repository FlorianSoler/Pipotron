public class FileManager {
    private String rulePath;
    private String referencePath;

    public FileManager(String rule, String reference){
        this.rulePath = rule;
        this.referencePath = reference;
    }

    public void setRulePath(String rulePath) {
        this.rulePath = rulePath;
    }

    public void setReferencePath(String referencePath) {
        this.referencePath = referencePath;
    }
    
}

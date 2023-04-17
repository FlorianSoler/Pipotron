import java.security.PublicKey;
import java.util.List;

public class Reference {

    private String referenceName;
    private List<String> referenceWords;
    private WordType type; // not implemented

    public Reference(String refName, List<String> words){
        this.referenceName = refName;
        this.referenceWords = words;
    }

    public void setReferenceName(String referenceName) {
        this.referenceName = referenceName;
    }

    public void setReferenceWords(List<String> referenceWords) {
        this.referenceWords = referenceWords;
    }

    public String getReferenceWord(int index) {
        return this.referenceWords.get(index);
    }

    public void print(){
        System.out.println(referenceName + referenceWords);
    }
    
}
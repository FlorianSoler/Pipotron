public class Rule {
    private int id;
    private String word;
    private String selectedReference;
    private Reference referenceSets;
    private WordType type;

    public Rule(int i, String w, Reference referenceSet){
        this.id = i;
        this.word = w;
        this.referenceSets = referenceSet;
    }

    public String toString(){
        return this.word + this.selectedReference;
    }

}

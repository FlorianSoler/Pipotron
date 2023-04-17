public class Rule {
    private int id;
    private String word;
    private String selectedReference;
    private Reference referenceSets;
    private String ponct;
    private WordType type;

    public Rule(){
    }

    public Rule(int i, String w, Reference referenceSet){
        this.id = i;
        this.word = w;
        this.referenceSets = referenceSet;
    }

    public Rule(int i, String pct){
        this.id = i;
        this.ponct = pct;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setSelectedReference(String selectedReference) {
        this.selectedReference = selectedReference;
    }

    public String toString(){
        return this.word + this.selectedReference;
    }

    public void print(){
        System.out.println(id + word + selectedReference + ponct);
    }

}

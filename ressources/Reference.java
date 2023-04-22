import java.util.List;
import java.util.Random;

public class Reference extends Element {

    // Propriétés spécifiques à la sous-classe Reference
    //private String referenceName;
    private List<String> referenceWords;
    private int selected;
    private int position;

    // Constructeur
    public Reference(String setsName, List<String> Words, int pos) {
        //this.referenceName = setsName;
        this.referenceWords = Words;
        this.position = pos;

        //select a random element
        selectRandom();
    }

    // Select a random int from the list element range
    public void selectRandom() {

        Random random = new Random();
        int randomNumber = random.nextInt(this.referenceWords.size());

        if (this.selected != randomNumber) {
            this.selected = randomNumber;
        }else{
            selectRandom();
        }
    }
    @Override
    public void setPosition(int pos){
        this.position = pos;
    }

    @Override
    public String toString() {
        return this.referenceWords.get(this.selected);
    }

    @Override
    public String toString(boolean rand, boolean selectable) {
        if(rand){
            selectRandom();
        }
        if(selectable){
            return "[ " + position + " - " + this.referenceWords.get(this.selected) + "]";
        }
        return this.referenceWords.get(this.selected);
    }

}
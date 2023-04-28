import java.util.List;
import java.util.Random;

public class Reference extends RuleElement {

    private List<String> words;
    private int selected;
    private int position;
    private Random random = new Random();

    //constructor
    public Reference(List<String> words, int pos) {

        this.words = words;
        this.position = pos;

        selectRandom();
    }

    //used to set the potion to a random index in the list
    @Override
    public void selectRandom() {
        int randomNumber = this.random.nextInt(this.words.size());

        if (this.selected != randomNumber) {
            this.selected = randomNumber;
        } else {
            selectRandom();
        }
    }

    
    /** used to give the potion of this element in the RuleElement list
     * @param pos position in the list from the other element
     */
    @Override
    public void setPosition(int pos) {
        this.position = pos;
    }

    @Override
    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return this.words.get(this.selected);
    }

    //use to the current selected string from the reference or a random one
    //and to give the string if its selecatable "[pos + selectedword]"
    @Override
    public String toString(boolean selectRandom, boolean isSelectable) {
        if (selectRandom) {
            selectRandom();
        }
        String result = this.words.get(this.selected);
        if (isSelectable) {
            result = String.format("[ %d - %s ]", position, result);
        }
        return result;
    }
    
    //cursed fonction but i have the right to OVERRIDE IT !
    //https://media.tenor.com/NYgw-6Q_LicAAAAd/funny-blades-and-sorcery.gif ;)

}
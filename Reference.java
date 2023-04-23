import java.util.List;
import java.util.Random;

public class Reference extends RuleElement {

    private List<String> words;
    private int selected;
    private int position;

    public Reference(List<String> words, int pos) {

        this.words = words;
        this.position = pos;

        selectRandom();
    }

    @Override
    public void selectRandom() {

        Random random = new Random();
        int randomNumber = random.nextInt(this.words.size());

        if (this.selected != randomNumber) {
            this.selected = randomNumber;
        } else {
            selectRandom();
        }
    }

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

}
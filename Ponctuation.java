public class Ponctuation extends RuleElement {

    private String ponctuation;

    public Ponctuation(String ponct) {
        this.ponctuation = ponct;
    }

    @Override
    public String toString(boolean rand, boolean selectable) {
        return this.ponctuation;

    }
}
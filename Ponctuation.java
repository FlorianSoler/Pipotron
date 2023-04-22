
public class Ponctuation extends RuleElement {
    // Propriété spécifique à la sous-classe Ponctuation
    private String ponctuation;

    // Constructeur
    public Ponctuation(String ponct) {
        this.ponctuation = ponct;
    }

    @Override
    public String toString(boolean rand, boolean selectable) {
        return this.ponctuation;

    }
}
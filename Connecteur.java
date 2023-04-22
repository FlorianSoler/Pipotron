
public class Connecteur extends RuleElement {
    // Propriété spécifique à la sous-classe Connecteur
    private String connecteur;

    // Constructeur
    public Connecteur(String connect) {
        this.connecteur = connect;
    }

    @Override
    public String toString(boolean rand, boolean selectable) {
        return this.connecteur;
    }
}

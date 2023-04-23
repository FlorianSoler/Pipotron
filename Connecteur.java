
public class Connecteur extends RuleElement {
    private String connecteur;

    public Connecteur(String connect) {
        this.connecteur = connect;
    }

    @Override
    public String toString(boolean rand, boolean selectable) {
        return this.connecteur;
    }
}

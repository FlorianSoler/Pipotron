// this class is used for connecting syntax
public class Connecteur extends RuleElement {
    private String connecteur;

    public Connecteur(String connect) {
        this.connecteur = connect;
    }
    
    /** return the string of the current connecteur element
     * @param rand enable random mode if suported
     * @param selectable enable section mode if suported by the class
     * @return String
     */
    @Override
    public String toString(boolean rand, boolean selectable) {
        return this.connecteur;
    }
}

public class Ponctuation extends RuleElement {

    private String ponctuation;

    public Ponctuation(String ponct) {
        this.ponctuation = ponct;
    }

    
    /** return the string of the pocutation element
     * @param rand
     * @param selectable
     * @return String
     */
    @Override
    public String toString(boolean rand, boolean selectable) {
        return this.ponctuation;

    }
}
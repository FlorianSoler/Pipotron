
import java.util.List;

public class Rule {
    List<RuleElement> ruleElements;

    public Rule(List<RuleElement> elements) {
        this.ruleElements = elements;
    }

    /**
     * @param position
     */
    public void changeSelectedReference(int position) {
        for (RuleElement ruleElement : this.ruleElements) {
            if (ruleElement instanceof Reference) {

                //if index din't change re roll
                if (ruleElement.getPosition() == position) {
                    ruleElement.selectRandom();
                    break;
                }
            }
        }

    }

    // this foction is use to generate a sentece based from every ruleElement
    public String toString(boolean selectRandom, boolean isSelectable) {
        StringBuilder recapBuilder = new StringBuilder();

        //iterate over all elements and convert to string
        for (RuleElement ruleElement : this.ruleElements) {
            if (ruleElement instanceof Ponctuation) {
                recapBuilder.append(ruleElement.toString(selectRandom, isSelectable));
            } else {
                recapBuilder.append(" ").append(ruleElement.toString(selectRandom, isSelectable));
            }
        }
        return recapBuilder.toString();
    }

}

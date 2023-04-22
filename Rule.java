
import java.util.List;

public class Rule {
    List<RuleElement> ruleElements;

    public Rule(List<RuleElement> elements) {
        this.ruleElements = elements;
    }

    public String toString(boolean rand, boolean selectable) {
        String recap = "";
        for (RuleElement ruleElement : ruleElements) {
            if (ruleElement instanceof Ponctuation) {
                recap += ruleElement.toString(rand, selectable);
                continue;
            }
            recap += " " + ruleElement.toString(rand, selectable);

        }

        return recap;
    }
}

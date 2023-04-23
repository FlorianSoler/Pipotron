
import java.util.List;

public class Rule {
    List<RuleElement> ruleElements;

    public Rule(List<RuleElement> elements) {
        this.ruleElements = elements;
    }

    public void changeSelectedReference(int position){
        for (RuleElement ruleElement : this.ruleElements) {
            if(ruleElement instanceof Reference){
                if(ruleElement.getPosition() == position){
                    ruleElement.selectRandom();
                    break;
                }
            }
        }
        // position++;
        // if(position <= this.ruleElements.size()){
        //     this.ruleElements.get(position).selectRandom();
        // }
        
    }

    public String toString(boolean selectRandom, boolean isSelectable) {
        StringBuilder recapBuilder = new StringBuilder();
        for (RuleElement ruleElement :  this.ruleElements) {
            if (ruleElement instanceof Ponctuation) {
                recapBuilder.append(ruleElement.toString(selectRandom, isSelectable));
            } else {
                recapBuilder.append(" ").append(ruleElement.toString(selectRandom, isSelectable));
            }

            
        }
        return recapBuilder.toString();
    }

}

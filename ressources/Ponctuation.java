public class Ponctuation extends Element {
    // Propriété spécifique à la sous-classe Ponctuation
    private String ponctuation;

    // Constructeur
    public Ponctuation(String ponct) {
        this.ponctuation = ponct;
    }

    @Override
    public String toString(){
        return this.ponctuation;
    }
}
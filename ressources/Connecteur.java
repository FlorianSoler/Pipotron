public class Connecteur extends Element{
        // Propriété spécifique à la sous-classe Connecteur
        private String connecteur;

        // Constructeur
        public Connecteur(String connect) {
            this.connecteur = connect;
        }
    
        @Override
        public String toString(){
            return this.connecteur;
        }
}

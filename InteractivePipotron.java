import java.util.Scanner;

public class InteractivePipotron {
    private Sentence sentence = new Sentence();
    private final String Rule_Path = "Data/regles.xml";
    private boolean isInitialized;

    private Scanner scanner = new Scanner(System.in);


    public InteractivePipotron() {
        initializePipotron();
    }

    public void initializePipotron() {
        this.sentence.setRulesPath(Rule_Path);
        this.sentence.loadRules();
        this.sentence.selectRandomRule();
        this.isInitialized = true;
    }

    public void startInteraction() {
        StringBuilder stringBuilder = new StringBuilder();
        if (isInitialized) {
            stringBuilder.append("This Is Pipotron !\n")
                .append("Pipotron is the best pipotron on the market !\n")
                .append("Here are the mode :\n");
            String output = stringBuilder.toString();
            System.out.print(output);

            interractionMode();
        }
    }

    private void interractionMode() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(" - 0 : generate a non interacable sentence.\n")
            .append(" - 1 : generate an interacable sentence.\n")
            .append(" - '-1' : kill pipotron :(\n")
            .append("Select a mode : ");

        String output = stringBuilder.toString();
        System.out.print(output);

        int inputInt = this.scanner.nextInt();

        switch (inputInt) {
            case -1:
                System.exit(0);
                break;
            case 0:
                this.sentence.selectRandomRule();
                System.out.println("");
                System.out.println(this.sentence.generateSentence());
                System.out.println("");
                interractionMode();
            case 1:

                System.out.println("");
                System.out.println(this.sentence.reGenerateInteractiveSentence(inputInt));
                System.out.println("");

                interactiveSentenceMode();
                break;
            default:
                System.out.print("Unsuported command.");
                interractionMode();
        }
    }

    private void interactiveSentenceMode() {

        System.out.print("Enter section to regenerate : ");
        int inputInt = this.scanner.nextInt();

        switch (inputInt) {
            case 0:
                System.out.println("");
                System.out.println(this.sentence.generateSentence());
                System.out.println("");
                interractionMode();
            default:
                if (inputInt > 0) {
                    System.out.println("");
                    System.out.println(this.sentence.reGenerateInteractiveSentence(inputInt));
                    System.out.println("");
                    interactiveSentenceMode();
                }
                else{
                    System.out.print("Unsuported command.");
                    interactiveSentenceMode();
                }
        }
    }

}

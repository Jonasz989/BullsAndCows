package mainPackage;

class Grader {

    private static int bulls = 0;
    private static int cows = 0;
    private static boolean Guessed = false;
    public static void setGuessed(boolean guessed) {
        Guessed = guessed;
    }
    public static boolean isGuessed() {
        return Guessed;
    }

    //Calculating how many bulls and cows are in the game
    public static void Calculating(String input, String secretCode) {
        String[] splittedInput = input.split("");
        String[] splittedSecretCode = secretCode.split("");
        for (int i = 0; i < GenerateRandomNumber.getSecretCode().length(); i++) {
            for (int j = 0; j < GenerateRandomNumber.getSecretCode().length(); j++) {
                if (splittedInput[i].equals(splittedSecretCode[j]) && i == j) {
                    bulls++;
                }
                if (splittedInput[i].equals(splittedSecretCode[j]) && i != j) {
                    cows++;
                }
            }
        }
    }
    //Method for grading answer
    public static void Grading() {
        if (bulls == 0 && cows == 0) {
            System.out.println("Grade: None.");
        }
        if (bulls != 0 && cows == 0) {
            System.out.println("Grade: " + bulls + " bull(s).");
        }
        if (bulls == 0 && cows != 0) {
            System.out.println("Grade: " + cows + " cow(s).");
        }
        if (bulls != 0 && cows != 0) {
            System.out.println("Grade: " + bulls + " bull(s) and " + cows + " cow(s)." );
        }
        if (bulls == GenerateRandomNumber.getHowBigNumber()) {
            boolean endTheGame = true;
            setGuessed(endTheGame);
        }
        bulls = 0;
        cows = 0;
    }
}
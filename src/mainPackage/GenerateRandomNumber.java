package mainPackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class GenerateRandomNumber {

    private static int howBigNumber = 0;
    private static int possibleSymbols = 0;
    private static boolean shouldStartGame = true;
    private static String secretCode;
    public static String getSecretCode() {
        return secretCode;
    }

    public static void setHowBigNumber(int howBigNumber) {
        GenerateRandomNumber.howBigNumber = howBigNumber;
    }

    public static void setPossibleSymbols(int possibleSymbols) {
        GenerateRandomNumber.possibleSymbols = possibleSymbols;
    }

    public static boolean isShouldStartGame() {
        return shouldStartGame;
    }

    public static int getHowBigNumber() {
        return howBigNumber;
    }

    public static int getPossibleSymbols() {
        return possibleSymbols;
    }

    public static void checkHowBigNumber() {
        if (howBigNumber > 36 || possibleSymbols > 36 || howBigNumber <= 0 || possibleSymbols <= 0) {
            System.out.println("Error: Number not in proper range. ");
            shouldStartGame = false;
        } else if (howBigNumber > possibleSymbols) {
            System.out.println("Error: it's not possible to generate a code with a length of " + getHowBigNumber() + " with " + getPossibleSymbols() + " unique symbols.");
            shouldStartGame = false;
        } else {
            generateAllSymbols();
        }
    }
    public static void generateAllSymbols() {
        List<Character> listForAddingChars = new ArrayList<>(List.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a',
                'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't','u',
                'v',  'w',  'x', 'y', 'z'));

        Collections.shuffle(listForAddingChars.subList(0, getPossibleSymbols()));
        StringBuilder builderString = new StringBuilder();

        for (char ch : listForAddingChars.subList(0, getHowBigNumber())) builderString.append(ch);

        secretCode = builderString.toString();
    }
}

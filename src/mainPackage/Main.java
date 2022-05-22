package mainPackage;

import java.util.*;

public class Main {
    static int codeLength;
    static int possibleSymbols;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input the length (1-36) of the secret code: ");
        try {
            codeLength = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Error: Wrong input");
        }
        System.out.println("Input the number of possible symbols (1-36) in the code: ");
        try {
            possibleSymbols = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Error: Wrong input");
        }
        GenerateRandomNumber.setPossibleSymbols(possibleSymbols);
        GenerateRandomNumber.setHowBigNumber(codeLength);
        GenerateRandomNumber.checkHowBigNumber();
        if(GenerateRandomNumber.isShouldStartGame()) {
            System.out.printf("The secret is prepared: %s ", "*".repeat(GenerateRandomNumber.getHowBigNumber()));
            if (GenerateRandomNumber.getPossibleSymbols() <= 10) {
                System.out.printf("(0-%d).\n", GenerateRandomNumber.getPossibleSymbols() - 1);
            } else {
                System.out.printf("(0-9, a-%s).\n", "abcdefghijklmnopqrstuvwxyz".charAt(GenerateRandomNumber.getPossibleSymbols() - 11));
            }
            System.out.println("Okay, let's start a game!");
            int i = 1;
            while (!Grader.isGuessed()) {
                System.out.println("Turn " + i++ + ":");
                String input = scanner.next();
                Grader.Calculating(input, GenerateRandomNumber.getSecretCode());
                Grader.Grading();
            }
        }
    }
}
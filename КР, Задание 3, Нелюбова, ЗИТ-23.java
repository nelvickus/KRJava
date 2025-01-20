import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final int CODE_LENGTH = 4; 
    private static final int MAX_ATTEMPTS = 20; 
    
    public static void main(String[] args) {
        Random random = new Random();
        int[] secretCode = generateSecretCode(random);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Загадан код из 4 цифр (от 0 до 9). Попробуйте угадать его за 20 попыток.");

        for (int attempt = 1; attempt <= MAX_ATTEMPTS; attempt++) {
            System.out.printf("Попытка %d: Введите 4 цифры через пробел: ", attempt);
            String input = scanner.nextLine();
            int[] userGuess = parseInput(input);

            if (userGuess == null) {
                System.out.println("Некорректный ввод. Убедитесь, что вы ввели 4 цифры.");
                attempt--; 
                continue;
            }

            int matches = countMatches(secretCode, userGuess);
            System.out.printf("Количество совпадений: %d\n", matches);

            if (matches == CODE_LENGTH) {
                System.out.println("Поздравляем! Вы угадали код!");
                return;
            }
        }

        System.out.println("Вы исчерпали все попытки. Загаданный код: " + arrayToString(secretCode));
    }

    private static int[] generateSecretCode(Random random) {
        int[] code = new int[CODE_LENGTH];
        for (int i = 0; i < CODE_LENGTH; i++) {
            code[i] = random.nextInt(10); 
        }
        return code;
    }

    private static int[] parseInput(String input) {
        String[] parts = input.split(" ");
        if (parts.length != CODE_LENGTH) {
            return null; 
        }

        int[] guess = new int[CODE_LENGTH];
        try {
            for (int i = 0; i < CODE_LENGTH; i++) {
                guess[i] = Integer.parseInt(parts[i]);
                if (guess[i] < 0 || guess[i] > 9) {
                    return null;
                }
            }
        } catch (NumberFormatException e) {
            return null; 
        }
        return guess;
    }

    private static int countMatches(int[] secretCode, int[] userGuess) {
        int matches = 0;
        for (int num : userGuess) {
            for (int codeNum : secretCode) {
                if (num == codeNum) {
                    matches++;
                    break;
                }
            }
        }
        return matches;
    }

    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int num : array) {
            sb.append(num).append(" ");
        }
        return sb.toString().trim();
    }
}

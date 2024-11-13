import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class Dena {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        StringBuilder cleanedInput = new StringBuilder();
        for (char ch : input.toCharArray()) {
            if (Character.isLetter(ch)) {
                cleanedInput.append(ch);
            }
        }

        char[] chars = cleanedInput.toString().toCharArray();
        for (int i = 0; i < chars.length - 1; i += 2) {
            char temp = chars[i];
            chars[i] = chars[i + 1];
            chars[i + 1] = temp;
        }

        List<String> words = new ArrayList<>();
        StringBuilder currentWord = new StringBuilder();
        
        for (char ch : chars) {
            if (Character.isUpperCase(ch) && currentWord.length() > 0) {
                words.add(currentWord.toString());
                currentWord = new StringBuilder();
            }
            currentWord.append(ch);
        }
        
        if (currentWord.length() > 0) {
            words.add(currentWord.toString());
        }

        List<String> validWords = new ArrayList<>();
        for (String word : words) {
            if (isValidTitleCase(word)) {
                validWords.add(word);
            }
        }

        if (validWords.isEmpty()) {
            System.out.println("empty");
        } else {
            for (int i = validWords.size() - 1; i >= 0; i--) {
                System.out.print(validWords.get(i));
                if (i > 0) {
                    System.out.print(" ");
                }
            }
        }
    }

    private static boolean isValidTitleCase(String word) {
        if (word.length() < 2) {
            return false;
        }
        if (!Character.isUpperCase(word.charAt(0))) {
            return false;
        }
        for (int i = 1; i < word.length(); i++) {
            if (!Character.isLowerCase(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}

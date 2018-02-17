import java.util.Scanner;

public class Shifter {
    private int[][] numbers;
    private String[][] letters;
    private Scanner holder = new Scanner(System.in);
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";


    public Shifter() {
        super();
    }

    public Shifter(int[][] data, String[][] strData) {
        numbers = data;
        letters = strData;
        clearLetters();
        copyNumsToLetters();
    }

    public void swapLetter(int num, String letter) {
        for(int i = 0; i < numbers.length; i++)
            for(int j = 0; j < numbers[i].length; j++)
                if(numbers[i][j] == num)
                    letters[i][j] = letter;
    }

    public void clearLetters() {
        for(int i = 0; i < letters.length; i++)
            for(int j = 0; j < letters[i].length; j++)
                letters[i][j] = "";
    }

    public void showBoard() {
        for(int i = 0; i < letters.length; i++){
            for(int j = 0; j < letters[i].length; j++) {
                if(Character.isLetter(letters[i][j].charAt(0))) {
                    System.out.print(" " + ANSI_RED + letters[i][j] + ANSI_RESET + " ");
                } else {
                    System.out.print(" " + letters[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public void copyNumsToLetters() {
        for(int i = 0; i < letters.length; i++){
            for(int j = 0; j < letters[i].length; j++) {
                letters[i][j] = numbers[i][j] + "";
            }
        }
    }

    /**
     * Method for shifting a word through the array
     * @param word
     */
    public void BeginShift(String word) {
        String[] letters = word.split("(?!^)");

        for(int i = 0;i < numbers.length; i++) {
            for(int j = 0; j < numbers[i].length; j++) {
                copyNumsToLetters();
                for(int x = 0; x < letters.length;x++) {
                    if((j + x) % 20 >= 0)
                        swapLetter(numbers[i][j + x], letters[x]);
                    else
                        swapLetter(numbers[i + 1][(j + x) % 20], letters[x]);
                }
                /**
                 * Logic should be added here where you can have one of three options:
                 * 1. Shift word to right "r"
                 * 2. Shift word to left "l"
                 * 3. Swap a letter for a number "n"
                 * 4. Swap a number back for a letter "u"
                 */
                showBoard();
                holder.next();
            }
        }
    }
}

import java.util.Scanner;

/**
 * Created by mrtvor on 2018-02-16.
 */
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
                showBoard();
                holder.next();
            }
        }
    }
}

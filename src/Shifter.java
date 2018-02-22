import java.util.Scanner;

public class Shifter {
    private String word;
    int wordRow = 0;
    int wordCol = 0;
    private int[][] numbers;
    private String[][] letters;
    private Scanner holder = new Scanner(System.in);
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";


    public Shifter() {
        super();
    }

    public Shifter(int[][] data, String[][] strData, String word) {
        this.word = word;
        numbers = data;
        letters = strData;
        clearLetters();
        copyNumsToLetters();
    }

    public void menu() {
        int input = 0;

        Shift(1);
        showBoard();

        while(input != 5) {
            System.out.println("1. Right Shift");
            System.out.println("2. Left Shift");
            System.out.println("3. Swap In Letter");
            System.out.println("4. Swap In Number");
            System.out.println("5. Exit");

            input = Integer.parseInt(holder.next());

            switch (input) {
                case 1: Shift(0);
                        break;
                case 2: Shift(1);
                        break;
                case 3: Shift(2);
                        Swap();
                        break;
                case 4: break;
                case 5: System.exit(0);
                        break;
                default:break;
            }

            showBoard();
            copyNumsToLetters();
        }
    }

    /**
     * Swap given a row, col, and letter
     * @param rowCol
     * @param rowNum
     * @param letter
     */
    public void swapPosition(int rowCol, int rowNum, String letter) {
        int num = numbers[rowNum][rowCol];

        for(int i = 0; i < numbers.length; i++)
            for(int j = 0; j < numbers[i].length; j++)
                if(numbers[i][j] == num)
                    letters[i][j] = letter;
    }

    /**
     * Swap given a number
     * @param num
     * @param letter
     */
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
     */
    public void Shift(int dir) {
        String[] letters = word.split("(?!^)");

        //Adjust starting point
        if(dir == 0) {
            if(wordCol == 19 - letters.length && wordRow == 25) {
                System.out.println("No more right-shifting");
            } else {
                if(wordCol == 19) {
                    wordCol = 0;
                    wordRow++;
                } else {
                    wordCol++;
                }
            }
        } else if(dir == 1) {
            if(wordCol == 0 && wordRow == 0) {
                System.out.println("No more left-shifting");
            } else {
                if(wordCol == 0) {
                    wordCol = 19;
                    wordRow--;
                } else {
                    wordCol--;
                }
            }
        }

        //Shift here based on wordCol & wordRow
        if(wordCol + letters.length > 20) {
            int pop = letters.length - (wordCol + letters.length - 20);
            for(int x = 0; x < letters.length - (letters.length - pop); x++) {
                swapPosition(wordCol + x,wordRow,letters[x]);
            }
            for(int x = 0; x < letters.length - pop; x++) {
                System.out.println("POP: " + pop);
                System.out.println("LETTER: " + letters[x + pop]);
                swapPosition(x,wordRow + 1,letters[x + pop]);
            }
        } else {
            for (int x = 0; x < letters.length; x++) {
                swapPosition(wordCol + x, wordRow, letters[x]);
            }
        }
    }

    /**
     * For swapping a letter for a num,not shifting
     */
    public void Swap() {
        System.out.println("What number do you want to swap?");
        int num = Integer.parseInt(holder.next());

        System.out.println("What letter are you replacing it with?");
        String let = holder.next();

        swapLetter(num, let);
    }
}

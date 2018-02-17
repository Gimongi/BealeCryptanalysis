public class CryptoStats {
    private int[][] occurences;
    private int[][] numbers;
    private String[][] letters;
    private int textLength;

    public CryptoStats() {
        super();
    }

    public CryptoStats(int length) {
        occurences = new int[length][2];
        textLength = length;
    }

    public void setLength(int length) {
        occurences = new int[length][2];
        textLength = length;
    }

    public void setData(int rows, int columns) {
        numbers = new int[rows][columns];
        letters = new String[rows][columns];
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

    private void PrintStats() {
        for(int i = 0; i < textLength; i++) {
            System.out.println(occurences[i][0] + ": " + occurences[i][1]);
        }
    }
}

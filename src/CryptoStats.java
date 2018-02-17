public class CryptoStats {
    private int[][] occurences;
    private int[][] numbers;
    private String[][] letters;
    private int textLength;

    public CryptoStats() {
        super();
    }

    public CryptoStats(int[][] data) {
        numbers = data;
        letters = new String[data.length][data[0].length];
        clearLetters();
        setLengths();
        countOccurrences();
        PrintStats();
    }

    public void setLengths() {
        int length = numbers.length * numbers[0].length;
        occurences = new int[length][2];
        for(int i = 0; i < occurences.length; i++) {
            occurences[i][0] = 0;
            occurences[i][1] = 0;
        }
        textLength = length;
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

    private void countOccurrences() {
        int placeholder = 0;
        int count = 0;

        for (int i = 0; i < 2500; i++) {
            for(int x = 0; x < numbers.length; x++) {
                for(int y = 0; y < numbers[x].length; y++){
                    if(numbers[x][y] == i);
                    count++;
                }
            }
            if(count > 0) {
                occurences[placeholder][0] = i;
                occurences[placeholder++][1] = count;
            }
            count = 0;
        }
    }

    private void PrintStats() {
        for(int i = 0; i < textLength; i++) {
            System.out.println(occurences[i][0] + ": " + occurences[i][1]);
        }
    }
}

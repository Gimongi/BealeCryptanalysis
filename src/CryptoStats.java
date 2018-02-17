public class CryptoStats {
    private int[][] occurences;
    private int[][] numbers;
    private String[][] letters;

    public CryptoStats() {
        super();
    }

    public CryptoStats(int[][] data, String[][] strData) {
        numbers = data;
        letters = strData;
        occurences = new int[540][2];
        clearLetters();
        countOccurrences();
        PrintStats();
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

        for (int i = 1; i < 2500; i++) {
            for(int x = 0; x < numbers.length; x++) {
                for(int y = 0; y < numbers[x].length; y++){
                    if(numbers[x][y] == i)
                        count++;
                }
            }
//            System.out.println("i: " + i);
//            System.out.println("Count: " + count);
            if(count > 0) {
                occurences[placeholder][0] = i;
                occurences[placeholder++][1] = count;
            }
            count = 0;
        }
    }

    private void PrintStats() {
        for(int i = 0; i < 540; i++) {
            if(occurences[i][0] != 0)
                System.out.println(occurences[i][0] + ": " + occurences[i][1]);
        }
    }
}

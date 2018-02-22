import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CryptoStats stats;

        String path = "/Users/mrtvor/Documents/Comp-Sci Stuff/Cryptography/BealeCryptanalysis/Beale1.rtf";

        Reader reader = new Reader(path);
        int[][] test = reader.FileToIntArray();

//        for(int i = 0; i < test.length; i++){
//            for(int j = 0; j < test[i].length; j++) {
//                    System.out.print("[" + test[i][j] + "]");
//            }
//            System.out.println();
//        }

//        stats = new CryptoStats(reader.FileToIntArray(),reader.FileToStringArray());

        Scanner wordGetter = new Scanner(System.in);

        System.out.println("Word to be shifted");
        String word = wordGetter.next();

        Shifter reveal = new Shifter(reader.FileToIntArray(), reader.FileToStringArray(), word);

//        reveal.showBoard();
        reveal.menu();
    }

}

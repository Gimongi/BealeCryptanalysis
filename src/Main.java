/**
 * Created by mrtvor on 2018-02-16.
 */
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

        Shifter reveal = new Shifter(reader.FileToIntArray(), reader.FileToStringArray());

//        reveal.showBoard();
        reveal.BeginShift("VAULT");
    }

}

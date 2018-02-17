import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Reader {
    private Scanner reader;
    private String location;

    Logger log = Logger.getLogger(this.getClass().getName());

    public Reader(String location) {
        super();
        reader = new Scanner(System.in);
        this.location = location;
    }

    /**
     * Reads in from file location and returns contents in a 2D String array
     * @return file from location
     */
    public int[][] FileToIntArray() {
        String[][] input = new String[27][20];
        int[][] output = new int[27][20];
        int count = 0;

        try {
            reader = new Scanner(new FileReader(location));
            String line = reader.nextLine();
            while (reader.hasNext()) {
//                System.out.println("READ:" + line);
                input[count++] = line.split(",");
                line = reader.nextLine();
            }
            input[count++] = line.split(",");
            reader.close();
        } catch (IOException io) {
            log.log(Level.WARNING,io.getMessage());
        }
        for(int i = 0; i < input.length; i++)
            for(int j = 0; j < input[i].length; j++) {
                output[i][j] = Integer.parseInt(input[i][j]);
            }

        return output;
    }

    public String[][] FileToStringArray() {
        String[][] input = new String[27][20];
        int count = 0;

        try {
            reader = new Scanner(new FileReader(location));
            String line = reader.nextLine();
            while (reader.hasNext()) {
//                System.out.println("READ:" + line);
                input[count++] = line.split(",");
                line = reader.nextLine();
            }
            input[count++] = line.split(",");
            reader.close();
        } catch (IOException io) {
            log.log(Level.WARNING,io.getMessage());
        }

        return input;
    }
}

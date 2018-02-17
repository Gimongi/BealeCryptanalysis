import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by mrtvor on 2018-02-16.
 */
public class Reader {
    private Scanner reader;
    private String location;

    Logger log = Logger.getLogger(this.getClass().getName());

    public Reader(String location) {
        super();
        reader = new Scanner(System.in);
        this.location = location;
    }

    public String[][] ReadFile() {
        String[][] input = new String[30][];
        Scanner readah;
        int count = 0;

        try {
            readah = new Scanner(new FileReader(location));
            String line = readah.nextLine();
            while (readah.hasNext()) {
//                System.out.println("READ:" + line);
                input[count++] = line.split(",");
                line = readah.nextLine();
            }
            readah.close();
        } catch (IOException io) {
            log.log(Level.WARNING,io.getMessage());
        }
        return input;
    }
}

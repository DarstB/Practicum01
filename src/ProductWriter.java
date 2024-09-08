import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class ProductWriter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        boolean doneInput = false;
        String ID, name, description, cost;
        String rec;
        ArrayList<String> recs = new ArrayList<>();

        // uses a fixed known path:
        //  Path file = Paths.get("c:\\My Documents\\data.txt");
        // use the toolkit to get the current working directory of the IDE
        // will create the file within the Netbeans project src folder
        // (may need to adjust for other IDE)
        // Not sure if the toolkit is thread safe...
        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\ProductTestData.txt");

        do {
            ID = SafeInput.getNonZeroLenString(in, "Enter the product ID: ");
            name = SafeInput.getNonZeroLenString(in, "Enter the product name: ");
            description = SafeInput.getNonZeroLenString(in, "Enter the product description: ");
            cost = SafeInput.getNonZeroLenString(in, "Enter the product cost: ");

            rec = ID + ", " + name + ", " + description + ", " + cost;
            System.out.println(rec + "\n");
            recs.add(rec);

            doneInput = SafeInput.getYNConfirm(in, "Are you finished? [Y/N]: ");
        } while(!doneInput);

        try {
            // Typical java pattern of inherited classes
            // we wrap a BufferedWriter around a lower level BufferedOutputStream
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            // Finally can write the file LOL!

            for(String record : recs) {
                writer.write(record, 0, record.length());  // stupid syntax for write rec
                // 0 is where to start (1st char) the write
                // rec. length() is how many chars to write (all)
                writer.newLine();  // adds the new line

            }
            writer.close(); // must close the file to seal it and flush buffer
            System.out.println("Data file written!");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

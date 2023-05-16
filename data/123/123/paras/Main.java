import java.io.BufferedReader;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // Get the path to the file to read from.
        File inputFile = new File("input.txt");

        // Create a BufferedReader to read from the file.
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));

        // Create a PrintWriter to write to the output file.
        PrintWriter printWriter = new PrintWriter(new FileWriter(args[1]));

        // Read each line from the file and write it to the output file.
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            printWriter.println(line);
        }

        // Close the BufferedReader and PrintWriter.
        bufferedReader.close();
        printWriter.close();
    }
}

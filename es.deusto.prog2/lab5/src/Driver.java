import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author CS2334
 * @version 2016-09-22
 * Lab 5
 * 
 * Read lines from the user's keyboard.  For each line, attempt to interpret
 * it as a mathematical expression and print out the result (or an error message).
 * 
 * Lines are read as long as the user has not requested that the program be quit
 *
 */

public class Driver {

    /**
     * @param args Not used
     * @throws IOException If there is an IO error
     */
    public static void main(String[] args) throws IOException {

        // Open standard in for input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Loop until quit
        while(true)
        {
            // Read the next line of input
            String input = br.readLine();

            // Parse, compute and report the result
            if(Calculator.parseAndCompute(input)) 
            {
                // Quit has been specified
                break;
            }

        }

        // Close out the buffered reader
        br.close();
    }
}

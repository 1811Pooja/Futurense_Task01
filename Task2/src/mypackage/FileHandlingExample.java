package mypackage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileHandlingExample {

    public static void readFile(String fileName) throws FileNotFoundException, InvalidFileFormatException, FileProcessingException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            
            // Process file contents
            while ((line = reader.readLine()) != null) {
                // Example processing: Assuming processing involves splitting CSV data
                String[] data = line.split(",");
                
                // Simulate invalid file format
                if (data.length != 3) {
                    throw new InvalidFileFormatException("Invalid file format: Each line should have three fields separated by commas.");
                }
                
                // Process the data further (example: printing)
                System.out.println("Processed data: " + line);
            }
            
            reader.close();
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File not found: " + e.getMessage());
        } catch (IOException e) {
            throw new FileProcessingException("File processing error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String fileName = "financial_data.csv";

        try {
            // Read and process the file
            readFile(fileName);
        } catch (FileNotFoundException e) {
            System.err.println("File Not Found: Error: File 'financial_data.csv' not found." );
            // Detailed logging or specific actions for file not found scenario
        } catch (InvalidFileFormatException e) {
            System.err.println("Invalid File Format Exception ");
            // Detailed logging or specific actions for invalid file format scenario
        } catch (FileProcessingException e) {
            System.err.println("File Processing Exception: " + e.getMessage());
            // Detailed logging or specific actions for file processing errors
        }
    }
}


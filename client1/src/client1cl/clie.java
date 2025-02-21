package client1cl;
import com.opencsv.CSVReader;
import com.opencsv.stream.reader.*;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Base64;

public class clie {

    public static void main(String[] args) {
        // Master key must be 16 bytes for AES-128
        String masterKey = "ifanowMsTrSEcRet";
        String inputFile = "input.csv";    // Path to your input CSV file
        String outputFile = "output.csv";  // Path for the output CSV file

        try {
            // Setup AES cipher in ECB mode with PKCS5Padding
            SecretKeySpec keySpec = new SecretKeySpec(masterKey.getBytes("UTF-8"), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);

            // Open the CSV file for reading and writing
            CSVReader reader = new CSVReader(new FileReader(inputFile));
            CSVWriter writer = new CSVWriter(new FileWriter(outputFile));

            // Read the header row and add a new header for the encrypted column.
            String[] header = reader.readNext();
            if (header == null) {
                System.err.println("Input CSV file is empty.");
                reader.close();
                writer.close();
                return;
            }
            String[] newHeader = new String[header.length + 1];
            System.arraycopy(header, 0, newHeader, 0, header.length);
            newHeader[header.length] = "Encrypt request";
            writer.writeNext(newHeader);

            // Find the index of the "Decrypt request" column (case-insensitive)
            int decryptIndex = -1;
            for (int i = 0; i < header.length; i++) {
                if ("Decrypt request".equalsIgnoreCase(header[i])) {
                    decryptIndex = i;
                    break;
                }
            }
            if (decryptIndex == -1) {
                System.err.println("The 'Decrypt request' column was not found in the CSV header.");
                reader.close();
                writer.close();
                return;
            }

            // Process each row in the CSV file
            String[] row;
            while ((row = reader.readNext()) != null) {
                String plaintext = row[decryptIndex];
                String encryptedText = "";
                if (plaintext != null && !plaintext.isEmpty()) {
                    // Encrypt the plaintext
                    byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes("UTF-8"));
                    // Encode encrypted bytes in Base64 for safe CSV storage
                    encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);
                }
                // Append the encrypted text to the current row
                String[] newRow = new String[row.length + 1];
                System.arraycopy(row, 0, newRow, 0, row.length);
                newRow[row.length] = encryptedText;
                writer.writeNext(newRow);
            }

            // Close resources
            reader.close();
            writer.close();
            System.out.println("Encryption complete. Output file: " + outputFile);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

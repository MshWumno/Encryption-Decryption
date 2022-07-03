
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        HashMap<String, String> hm = new HashMap<String, String>();

        for (int i = 0;i < args.length - 1; i+=2) {
            hm.put(args[i], args[i + 1]);
        }

        String mode = hm.get("-mode");
        int key = Integer.parseInt(hm.get("-key"));
        String outAddress = hm.get("-out");
        String inAddress = hm.get("-in");
        String alg = hm.get("-alg");

        String answer = "";
        String message = "";
        if (hm.get("-data") == null) {
            try {
                File fileRead = new File(inAddress);
                Scanner scanner = new Scanner(fileRead);
                message = scanner.nextLine();
                scanner.close();
            } catch (FileNotFoundException e) {
                message = hm.get("-data");
            }
        } else {
            message = hm.get("-data");
        }

        if (alg.equals("unicode")) {
            Unicode unicode = new Unicode(message, key);
            answer = mode.equals("dec") ? unicode.decipher() : unicode.cipher();
        } else {
            Shift shift = new Shift(message, key);
            answer = mode.equals("dec") ? shift.decipher() : shift.cipher();
        }

        try {
            FileWriter writer = new FileWriter(outAddress);
            writer.write(answer);
            writer.close();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}

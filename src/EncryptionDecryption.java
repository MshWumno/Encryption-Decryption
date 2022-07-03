

public abstract class EncryptionDecryption {
    public static String message;
    public static int key;

    public EncryptionDecryption(String message, int key) {
        this.message = message;
        this.key = key;
    }


}

class Unicode extends EncryptionDecryption {
    public Unicode(String message, int key) {
        super(message, key);
    }


    static String cipher() {
        String text = "";
        for (char character : message.toCharArray()) {
            character += key;
            text += character;
        }
        return text;
    }


    static String decipher() {
        String text = "";
        for (char character : message.toCharArray()) {
            character -= key;
            text += character;
        }
        return text;
    }
}

class Shift extends EncryptionDecryption {
    public Shift(String message, int key) {
        super(message, key);
    }


    static String cipher() {
        StringBuilder text = new StringBuilder();
        for (char character : message.toCharArray()) {
            if (character != ' ') {
                int originalAlphabetPosition = character - 'a';
                int newAlphabetPosition = (originalAlphabetPosition + key) % 26;
                char newCharacter = (char)('a' + newAlphabetPosition);
                text.append(newCharacter);
            } else {
                text.append(character);
            }
        }
        return String.valueOf(text);

    }



    static String decipher() {

        StringBuilder text = new StringBuilder();
        for (char character : message.toCharArray()) {
            if (character != ' ') {
                int originalAlphabetPosition = character - 'a';
                int newAlphabetPosition = (originalAlphabetPosition + (26- key % 26)) % 26;
                char newCharacter = (char)('a' + newAlphabetPosition);
                text.append(newCharacter);
            } else {
                text.append(character);
            }
        }
        return String.valueOf(text);

    }
}



